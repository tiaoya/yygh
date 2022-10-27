package com.zhong.yygh.common.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : zhong
 * @Description :
 * @create : 2022/10/18-21:49
 */
@Configuration
@EnableSwagger2 // 开启Swagger支持
public class SwaggerConfig {

    // 每一个 docket对象 对应一组

    // 管理员一组
    @Bean
    public Docket getAdminDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("admin")
                .apiInfo(getAdminApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }

    public ApiInfo getAdminApiInfo(){
        return new ApiInfoBuilder()
                .title("管理员系统")
                .description("尚医通预约挂号平台系统之管理员系统")
                .version("1.0")
//                .contact(new Contact("zhong","http://www.baidu.com","xxx@163.com"))
                .build();
    }

    // 用户一组
    @Bean
    public Docket getUserDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user")
                .apiInfo(getUserApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/user/.*")))
                .build();
    }

    public ApiInfo getUserApiInfo(){
        return new ApiInfoBuilder()
                .title("用户系统")
                .description("尚医通预约挂号平台系统之用户系统")
                .version("1.0")
//                .contact(new Contact("zhong","http://www.baidu.com","xxx@163.com"))
                .build();
    }

    // 第三方 api 一组
    @Bean
    public Docket getApiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Api")
                .apiInfo(getApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/api/.*")))
                .build();
    }

    public ApiInfo getApiInfo(){
        return new ApiInfoBuilder()
                .title("第三方医院")
                .description("尚医通预约挂号平台系统之第三方对接系统")
                .version("1.0")
//                .contact(new Contact("zhong","http://www.baidu.com","xxx@163.com"))
                .build();
    }



}
