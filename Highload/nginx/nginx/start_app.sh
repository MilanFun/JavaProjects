#!/bin/bash

set -e
# Build
cd ..
mvn clean install > /dev/null
echo "Build finished with: $?"

find_free_port() {
  read LOWERPORT UPPERPORT < /proc/sys/net/ipv4/ip_local_port_range
  while :
  do
    FREE_PORT=$(shuf -i $LOWERPORT-$UPPERPORT -n 1)
    ss -lpn | grep -q ":$PORT " || break
  done
}

# Start 3 services on different port
for i in 1 2 3
do
  find_free_port
  echo "Starting service on port: $FREE_PORT"
	java -jar target/nginx-0.0.3-SNAPSHOT.jar --server.port=$FREE_PORT > /dev/null &
	sleep 5
done