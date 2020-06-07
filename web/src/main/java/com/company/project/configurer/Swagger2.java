package com.company.project.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.company.project.constent.ProjectConstant.CONTROLLER_PACKAGE;

/**
 * Created by superlee on 2017/11/3.
 * swagger配置
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApiMobile(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("示例项目")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("项目接口调试")
                .description("测试接口连通性")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
