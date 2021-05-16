build image :
docker build -t local-keycloak:1.0 .

run keycloack command :
docker run -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin quay.io/keycloak/keycloak:13.0.0