FROM postgres:16
ENV TZ=America/Sao_Paulo
COPY init/*.sql /docker-entrypoint-initdb.d/
EXPOSE 5432