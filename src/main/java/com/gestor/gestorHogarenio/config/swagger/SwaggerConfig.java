package com.gestor.gestorHogarenio.config.swagger;


import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(new ApiInfoBuilder()
                        .title("Swagger Super")
                        .description("Swagger Description details")
                        .version("1.0").build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
                .paths(PathSelectors.any()).build();
        //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        //.paths(PathSelectors.any()).build();
    }

    public void addResourceHandler(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resource/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resource/webjars/");
    }

}
