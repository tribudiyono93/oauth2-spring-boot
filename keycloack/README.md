build image :
docker build -t local-keycloak:1.0 .

run keycloack command :
docker run -p 8080:8080 --env-file ./.env local-keycloak:1.0
