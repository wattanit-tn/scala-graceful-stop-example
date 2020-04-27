FROM ubuntu:18.04
RUN apt-get update &&\
    apt-get install -y scala
WORKDIR /root
COPY test.scala /root/test.scala
RUN scalac test.scala
ENTRYPOINT ["scala", "Test"]
