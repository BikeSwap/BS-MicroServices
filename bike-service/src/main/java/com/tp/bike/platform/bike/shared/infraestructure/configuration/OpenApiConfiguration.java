package com.tp.bike.platform.bike.shared.infraestructure.configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI houseonsalePlatformOpenApi(){
        return new OpenAPI()
                .info(new Info().title("CycleScape platform")
                        .description(
                                "CycleScape.com Platform application REST API documentation"
                        + "@author: BikeSwap")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("https://springgoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("CycleScape.com Platform with Documentation")
                        .url("https://CycleScape-platform.wik.github.org/docs"));
    }
}
