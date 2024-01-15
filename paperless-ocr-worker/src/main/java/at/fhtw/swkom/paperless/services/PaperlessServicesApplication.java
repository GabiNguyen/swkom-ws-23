package at.fhtw.swkom.paperless.services;

import com.fasterxml.jackson.databind.Module;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(
        basePackages = {"at.fhtw.swkom.paperless.persistence.entity"}
)
@EnableJpaRepositories(
        basePackages = {"at.fhtw.swkom.paperless.persistence.repository"}
)
@SpringBootApplication(
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(
        basePackages = {"at.fhtw.swkom.paperless.services", "at.fhtw.swkom.paperless.controller" , "at.fhtw.swkom.paperless.config"},
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
public class PaperlessServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaperlessServicesApplication.class, args);
    }

    @Bean(name = "at.fhtw.swkom.paperless.services.PaperlessServicesApplication.jsonNullableModule")
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

}