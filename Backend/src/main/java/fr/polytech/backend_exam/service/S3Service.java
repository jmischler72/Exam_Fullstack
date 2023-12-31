package fr.polytech.backend_exam.service;

import fr.polytech.backend_exam.exception.ResourceBadRequestException;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.http.Method;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class S3Service {
    
    private final MinioClient minioClient;

    private String getPresignedUrl(Method method, String bucketName, String objectName) {
        try {
            return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                    .method(method)
                    .bucket(bucketName)
                    .object(objectName)
                    .build()
            );
        }catch (Exception e){
            throw new ResourceBadRequestException(e.getMessage());
        }
    }

    public String getImageUrl(String imageName, String bucket) {
        return this.getPresignedUrl(Method.GET, bucket, imageName);
    }

    public String putImageUrl(String imageName, String bucket) {
        return this.getPresignedUrl(Method.PUT, bucket, imageName);
    }
}