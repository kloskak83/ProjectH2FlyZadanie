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
#RUN ls -l

#CMD ["java", "-jar", "target/ProjectH2Fly-1.0-SNAPSHOT.jar"]
# Komenda uruchamiająca aplikację
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar target/ProjectH2Fly-0.0.1-SNAPSHOT.jar"]