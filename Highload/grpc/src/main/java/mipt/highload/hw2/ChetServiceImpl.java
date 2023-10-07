package mipt.highload.hw2;

import io.grpc.stub.StreamObserver;
import mipt.highload.hw2.grpc.ChatMessage;
import mipt.highload.hw2.grpc.ChatMessageFromServer;
import mipt.highload.hw2.grpc.ChatServiceGrpc;

import java.util.HashMap;
import java.util.Map;


public class ChetServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {

    private static final Map<String, StreamObserver<ChatMessageFromServer>> mapUsers = new HashMap<>();

    @Override
    public StreamObserver<ChatMessage> sendChatMessage(StreamObserver<ChatMessageFromServer> responseObserver) {
        return new StreamObserver<ChatMessage>() {

            @Override
            public void onNext(ChatMessage value) {
                if (mapUsers.containsKey(value.getReceiverName())) {
                    System.out.println(value.getMessage());

                    ChatMessageFromServer message = ChatMessageFromServer
                            .newBuilder()
                            .setMessage(value)
                            .build();

                    mapUsers.get(value.getReceiverName()).onNext(message);
                } else {
                    if (!mapUsers.containsKey(value.getSenderUsername())) {
                        mapUsers.put(value.getSenderUsername(), responseObserver);
                        StringBuilder builder = new StringBuilder();
                        for (Map.Entry entry : mapUsers.entrySet()) {
                            builder.append(entry.getKey()).append("\t");
                        }
                        responseObserver.onNext(ChatMessageFromServer
                                .newBuilder()
                                .setMessage(ChatMessage
                                        .newBuilder()
                                        .setMessage(builder.toString())
                                        .build())
                                .build()
                        );
                        System.out.println("Connect to server with name=" + value.getSenderUsername());
                    } else {
                        responseObserver.onNext(ChatMessageFromServer
                                .newBuilder()
                                .setMessage(ChatMessage
                                        .newBuilder()
                                        .setMessage("Users with name={" + value.getReceiverName() + "} doesn't exist")
                                        .build())
                                .build()
                        );
                    }
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed!");
            }
        };
    }
}