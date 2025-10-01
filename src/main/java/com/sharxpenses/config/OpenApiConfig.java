package com.sharxpenses.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI baseOpenAPI() {
    return new OpenAPI().info(new Info()
      .title("SharXpenses API")
      .version("1.0.0")
      .description("Documentação da API do SharXpenses"));
  }
}
