package mipt.highload.hw2;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import mipt.highload.hw2.grpc.*;

import java.util.Scanner;

public class GrpcClient {
    private static String name = "";
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8803)
                .usePlaintext()
                .build();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        name = scanner.nextLine();
        System.out.println("Successfully connected to server");

        ChatServiceGrpc.ChatServiceStub stub = ChatServiceGrpc.newStub(channel);

        StreamObserver<ChatMessage> chat =
                stub.sendChatMessage(new StreamObserver<ChatMessageFromServer>() {
                    @Override
                    public void onNext(ChatMessageFromServer value) {
                        ChatMessage message = value.getMessage();
                        if (!message.getSenderUsername().equals(""))
                            System.out.println("\nMessage from " +
                                    message.getSenderUsername() + ":" +
                                    message.getMessage()
                            );
                        else {
                            System.out.println(message.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println();
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Disconnected");
                    }
                });

        chat.onNext(ChatMessage
                .newBuilder()
                .setSenderUsername(name)
                .build()
        );

        System.out.println("Command exit() - exit from session");
        System.out.println("\t\tchange() - change user chat");
        System.out.println("\t\tshow() - change user chat");
        System.out.print("Please choose user for sending message: ");
        String user = scanner.nextLine();
        while (true) {
            System.out.print(user + ": ");
            String message = scanner.nextLine();
            if (message.equals("exit()")) {
                break;
            }
            if (message.equals("change()")) {
                System.out.print("Enter user: ");
                user = scanner.nextLine();
                System.out.print(user + ": ");
                message = scanner.nextLine();
                chat.onNext(ChatMessage
                        .newBuilder()
                        .setSenderUsername(name)
                        .setMessage(message)
                        .setReceiverName(user)
                        .build()
                );
            } else {
                chat.onNext(ChatMessage
                        .newBuilder()
                        .setSenderUsername(name)
                        .setMessage(message)
                        .setReceiverName(user)
                        .build()
                );
            }
        }

        scanner.close();
        channel.shutdown();
    }
}
