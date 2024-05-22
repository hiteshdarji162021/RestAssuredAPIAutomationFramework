#use Base Image with maven and Java
FROM maven:3.8.3-openjdk-11

#Set working directory inside the container

WORKDIR /app

# Copy maven project file in container

COPY ml .
COPY src ./src

# Switch to directory containing the pom.xml
WORKDIR /app

# Run maven tests
CMD ["mvn", "test"]




