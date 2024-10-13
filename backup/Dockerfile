# Dockerfile

# Używamy obrazu JDK
FROM openjdk:latest

# Dodajemy nasz JAR do obrazu
COPY target/ProjectH2Fly-0.0.1-SNAPSHOT.jar /ProjectH2Fly-0.0.1-SNAPSHOT.jar

# Ustawiamy zmienną środowiskową dla Javy
ENV JAVA_OPTS=""

# Komenda uruchamiająca aplikację
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /ProjectH2Fly-0.0.1-SNAPSHOT.jar"]


# Dockerfile

# Użyj obrazu z Mavenem i JDK
FROM maven as build

# Ustaw katalog roboczy w kontenerze
WORKDIR /app

# Skopiuj pliki projektu do kontenera
COPY . .

# Zbuduj aplikację przy użyciu Mavena
RUN mvn clean package

# Uruchom aplikację

# Sprawdź, czy plik JAR został wygenerowany
WORKDIR /app

#CMD ["java", "-jar", "target/ProjectH2Fly-1.0-SNAPSHOT.jar"]
CMD ["java", "-jar", "ProjectH2Fly-1.0-SNAPSHOT.jar"]