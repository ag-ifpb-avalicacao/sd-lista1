mvn clean install
sudo docker build -t atividade/sd/node1 .
sudo docker run -d --name node1 --link node2:host-node2 atividade/sd/node1
