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
                .endpoint("http://localhost:9000") 
                .credentials("minio", "minio123") 
                .build();
    }
}
