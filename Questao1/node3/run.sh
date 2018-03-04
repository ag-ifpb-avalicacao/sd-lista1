mvn clean install
sudo docker build -t atividade/sd/node3 .
sudo docker run -d --name node3 -p 1235:1235 atividade/sd/node3
