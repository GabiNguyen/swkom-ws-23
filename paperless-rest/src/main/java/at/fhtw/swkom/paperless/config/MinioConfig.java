package at.fhtw.swkom.paperless.config;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    @Bean
    public MinioClient minioClient() {
        // Initialize Minio client
        return MinioClient.builder()
                .endpoint("http://localhost:9000") // Replace with your Minio server URL
                .credentials("minio", "minio123") // Replace with your Minio credentials
                .build();
    }
}
