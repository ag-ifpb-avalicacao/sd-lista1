sudo docker build -t sd/postgres2 .
sudo docker run -p 5434:5432 -d --name pg2 sd/postgres2
