FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app

# Copia os arquivos do projeto
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

# Garante que o mvnw seja executável
RUN chmod +x mvnw

# Constrói a aplicação
RUN ./mvnw clean package -DskipTests

# Fase final: imagem otimizada para execução
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia o JAR gerado na fase anterior
COPY --from=build /app/target/*.jar video-manager.jar

# Expondo a porta padrão do Spring Boot
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "video-manager.jar"]
