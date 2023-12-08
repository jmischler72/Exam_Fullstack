package fr.polytech.backend_exam.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.minio.MinioClient;

@Configuration
public class MinioConfig {

    @Value("${s3.accesskey}")
    String accesskey;

    @Value("${s3.secretkey}")
    String secetkey;

    @Value("${s3.endpoint}")
    String endpoint;

    @Bean
    public MinioClient generateMinioClient() {
        try {
            return MinioClient.builder()
                    .endpoint(this.endpoint)
                    .credentials(this.accesskey, this.secetkey)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}