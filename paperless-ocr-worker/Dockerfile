# # Use maven to build
# FROM maven:3.9.2-eclipse-temurin-17 AS builder

# # Establish the working directory
# WORKDIR /app

# # Copy the source code and pom.xml
# COPY ./pom.xml ./
# COPY ./src ./src

# # Build the JAR file
# RUN mvn package -DskipTests

# # Eclipse JRE 17 Base Image
# FROM eclipse-temurin:17.0.7_7-jre

# ## Create a directory to store OCR data
# #RUN mkdir /ocr-data

# # Set the working directory
# WORKDIR /app

# # Copy the JAR file
# COPY --from=builder /app/target/*.jar ./app.jar

# # Run the JAR file
# ENTRYPOINT java -jar app.jar

# # Use maven to build
# FROM maven:3.9.2-eclipse-temurin-17 AS builder

# # Establish the working directory
# WORKDIR /app

# # Copy the source code and pom.xml
# COPY ./pom.xml ./
# COPY ./src ./src

# # Build the JAR file
# RUN mvn package -DskipTests

# # Eclipse JRE 17 Base Image
# FROM eclipse-temurin:17.0.7_7-jre

# # Install Tesseract and its dependencies
# RUN apt-get update && \
#     apt-get install -y tesseract-ocr && \
#     rm -rf /var/lib/apt/lists/*

# ## Create a directory to store OCR data
# #RUN mkdir /ocr-data

# # Set the working directory
# WORKDIR /app

# # Copy the JAR file
# COPY --from=builder /app/target/*.jar ./app.jar

# # # Run the JAR file
# # ENTRYPOINT java -jar app.jar
# # Run the JAR file
# ENTRYPOINT java -DTESSDATA_PREFIX=/usr/share/tesseract-ocr/ -jar app.jar

# Use maven to build
FROM maven:3.9.2-eclipse-temurin-17 AS builder

# Establish the working directory
WORKDIR /app

# Copy the source code and pom.xml
COPY ./pom.xml ./
COPY ./src ./src

# Build the JAR file
RUN mvn package -DskipTests

# Eclipse JRE 17 Base Image
FROM eclipse-temurin:17.0.7_7-jre

# Install Tesseract and its dependencies
RUN apt-get update && \
    apt-get install -y tesseract-ocr && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /app

# Copy the JAR file
COPY --from=builder /app/target/*.jar ./app.jar

# Copy the tessdata directory
COPY ./tessdata /usr/share/tesseract-ocr/tessdata

# Run the JAR file
ENTRYPOINT java -DTESSDATA_PREFIX=/usr/share/tesseract-ocr/ -jar app.jar

