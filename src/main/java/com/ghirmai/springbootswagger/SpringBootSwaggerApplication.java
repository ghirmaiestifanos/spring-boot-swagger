package com.ghirmai.springbootswagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SpringBootSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSwaggerApplication.class, args);
        System.out.println("Hello world");
    }
@Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/contacts**/**"))
                .apis(RequestHandlerSelectors.basePackage("com.ghirmai"))
                .build().apiInfo(apiDetails());

    }
    private ApiInfo apiDetails(){

        ApiInfo apiInfo = new ApiInfo(
                "Address book Resource",
                "sample tutorial from javaBrains",
                "1.0",
                "http://www.Terms of service.com",
                "Selamino",
                "Apache license version 2.0",
                "http://licenseUrl.com");
        return apiInfo;
    }

}
