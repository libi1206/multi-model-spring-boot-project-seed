package com.company.project.configurer;

import com.company.project.constent.ProjectConstant;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis扫描接口
 *  注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的@AutoConfigureAfter注解
 * @author libuyi
 * @date 2019-09-16
 */
@Configuration
@AutoConfigureAfter(MybatisConfigure.class)
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(ProjectConstant.MAPPER_PACKAGE);
        return mapperScannerConfigurer;
    }

}