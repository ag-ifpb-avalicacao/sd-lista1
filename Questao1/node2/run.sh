mvn clean install
sudo docker build -t atividade/sd/node2 .
sudo docker run -d --name node2 -p 1234:1234 --link node3:host-node3 atividade/sd/node2
