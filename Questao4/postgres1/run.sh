sudo docker build -t sd/postgres1 .
sudo docker run -p 5433:5432 -d --name pg1 sd/postgres1
