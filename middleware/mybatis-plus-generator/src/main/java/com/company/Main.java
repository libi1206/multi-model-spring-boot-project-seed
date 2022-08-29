package com.company;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * 生成路径
     */
    private static final String outputDir="out";
    /**
     * 表名称
     */
    private static final String [] tableName= {
            "student"
    };


    //数据库配置========
    private static final String dbUrl="jdbc:mysql://192.168.56.101:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    private static final String dbDriver="com.mysql.cj.jdbc.Driver";

    private static final String dbUserName="root";
    private static final String dbPassword="123456";

    private static final String devAuthor="libi";

    private static final String parentPackage="com.company";

//    private static final String datasourcePackageName="dao";

    public static void main(String[] args) throws SQLException {

        // 1. 全局配置

        GlobalConfig config =new GlobalConfig();

        config.setOutputDir(outputDir); //生成路径
        config.setAuthor(devAuthor); //作者
        config.setFileOverride(true); // 文件覆盖
        config.setActiveRecord(true);// 是否支持AR模式
        config.setEnableCache(false);// XML 二级缓存
        config.setBaseResultMap(true);// XML ResultMap
        config.setBaseColumnList(true);// XML columList
        config.setOpen(false);//是否打开目录
        config.setDateType(DateType.ONLY_DATE);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        config.setMapperName("%sMapper");
        config.setXmlName("%sMapper");
        config.setServiceName("%sService");
        config.setServiceImplName("%sServiceImpl");
        config.setControllerName("%sController");


        // 2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL); // 设置数据库类型
        dsConfig.setDriverName(dbDriver);
        dsConfig.setUrl(dbUrl);
        dsConfig.setUsername(dbUserName);
        dsConfig.setPassword(dbPassword);

        // 3. 策略配置globalConfiguration中
        StrategyConfig stConfig = new StrategyConfig();
        //stConfig.setCapitalMode(true); // 全局大写命名
        stConfig.setNaming(NamingStrategy.underline_to_camel); // 数据库表映射到实体的命名策略
        stConfig.setEntityLombokModel(true);
        stConfig.setRestControllerStyle(true);
        List<TableFill> tableFillList = new ArrayList<>();
        //需要关注的底层逻辑
        tableFillList.add(new TableFill("insert_time", FieldFill.INSERT));
        tableFillList.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("operator_name", FieldFill.INSERT_UPDATE));
        stConfig.setTableFillList(tableFillList);
        stConfig.setLogicDeleteFieldName("remove_tag");

        stConfig.setInclude(tableName); // 生成的表





        // 4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent(parentPackage)
                .setMapper("dao")// dao
                .setService("service")// servcie
                .setServiceImpl("service.impl")
                .setController("controller")// controller
                .setEntity("bean")
                .setXml("sqlmap");// mapper.xml

        // 5. 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config);
        ag.setDataSource(dsConfig);
        ag.setStrategy(stConfig);
        ag.setPackageInfo(pkConfig);

        // 6. 执行
        ag.execute();
    }

}