package com.company.project.constent;

/**
 * 项目常量
 */
public final class ProjectConstant {
    //生成代码所在的基础包名称，可根据自己公司的项目修改
    // 注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）
    public static final String BASE_PACKAGE = "com.company.project";

    //controller所在包名
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";

    //MyBatis自动生成的Bean
    public static final String BEAN_PACKAGE = BASE_PACKAGE + ".bean";

    //MyBatisMapper所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";


}
