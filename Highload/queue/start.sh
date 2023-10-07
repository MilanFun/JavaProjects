#!/bin/bash

echo "Run RabbitMQ container..."
docker run -dit --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.11-management 

echo "Build java-spring project..."
mvn install 

echo "Run application..."
java -jar ./target/queue-0.0.1-SNAPSHOT.jar
