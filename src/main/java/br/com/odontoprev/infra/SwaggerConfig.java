package br.com.odontoprev.infra;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.security.SecurityRequirement;

import java.util.Comparator;
import java.util.List;

@Configuration
@SecurityScheme(
        name = "BearerAuth",
        description = "Insira o token JWT no formato: Bearer {seu_token}",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("OdontoPrev - Adaptive Dialogs")
                        .version("v1")
                        .description("RESTful API with Java and Spring Boot 3")
                        .license(new License()
                                .name("OdontoPrev")
                                .url("https://www.odontoprev.com.br/")))
                .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("BearerAuth",
                                new io.swagger.v3.oas.models.security.SecurityScheme()
                                        .name("Authorization")
                                        .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT").description("Basta adicionar o token")));
    }


    @Bean
    public OpenApiCustomizer sortTagsAlphabetically() {
        return openApi -> {
            List<Tag> tags = openApi.getTags();
            if (tags != null) {
                tags.sort(Comparator.comparing(Tag::getName));
            }
        };
    }
}
