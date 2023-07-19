package com.ogu.instagram.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// SwaggerConfig.java
/**
 * Swagger springdoc-ui 구성 파일
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Instagram 클론코딩 API 명세서")
                .version("v0.0.1")
                .description("멋쟁이사자처럼 Spring - Instagram 클론코딩 API 명세서");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}