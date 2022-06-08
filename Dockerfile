FROM ubuntu:16.04
RUN apt-get update && apt-get install -y openjdk-8-jdk
RUN apt-get install maven
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN wget -N http://chromedriver.storage.googleapis.com/2.39/chromedriver_linux64.zip
RUN unzip chromedriver_linux64.zip
RUN maven clean test