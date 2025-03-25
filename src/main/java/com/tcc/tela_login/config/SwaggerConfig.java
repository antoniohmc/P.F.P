package com.tcc.tela_login.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;

/**
 * Configuração do Swagger para a API.
 * Essa classe configura a documentação da API usando o Swagger.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Configura a documentação da API com título, versão e descrição.
     *
     * @return OpenAPI Objeto que contém as informações da documentação da API.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API do TCC")
                        .version("1.0")
                        .description("Documentação da API do TCC"));
    }
}
