FROM postgres:14.3
EXPOSE 5432
#ENV LANG en_US.utf8
#ENV DBNAME bank
#ENV POSTGRES_USERNAME sophos
#ENV POSTGRES_PASSWORD mybank
COPY initdb.sql /docker-entrypoint-initdb.d/


#sudo docker build -t sophosbank-postgres .
#sudo docker container run -d --rm --name db-bank -p 5432:5432 -e POSTGRES_PASSWORD=postgres sophosbank-postgres
#sudo docker container run -it --rm --name db-bank -p 5432:5432 -e POSTGRES_PASSWORD=postgres sophosbank-postgres
#sudo docker container run -it --rm --name db-bank -p 5432:5432 -e POSTGRES_PASSWORD=postgres sophosbank-postgres
#sudo docker container run -d -it --rm --name mipsql -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres:14.3
#sudo docker exec -it db-bank /bin/bash