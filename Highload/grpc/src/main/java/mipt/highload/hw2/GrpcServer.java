package mipt.highload.hw2;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8803)
                .addService(new ChetServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}