# Fase de build
FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app

# Define um argumento para armazenar a semana no build
ARG DB_PASS
ENV MONGO_DB_PASS=$DB_PASS
ENV AWS_REGION=us-east-1

# Constrói a aplicação
RUN ./mvnw clean package -DskipTests

# Fase final: imagem otimizada para execução
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia o JAR gerado na fase anterior
COPY --from=build /app/target/*.jar video-manager.jar

# Define a variável de ambiente na imagem final
ARG DB_PASS
ENV MONGO_DB_PASS=$DB_PASS
ENV AWS_REGION=us-east-1

# Expondo a porta padrão do Spring Boot
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "video-manager.jar"]
