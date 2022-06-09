FROM jenkins/jenkins

USER root
RUN apt-get update -y
RUN apt-get install -y ntp
RUN apt-get install -y maven
RUN apt-get install -y wget
RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get install ./google-chrome-stable_current_amd64.deb -y

USER jenkins

ENTRYPOINT ["/usr/local/bin/jenkins.sh"]

#Instalación del plugin cucumber reports
RUN jenkins-plugin-cli --plugins cucumber-reports:5.7.1
