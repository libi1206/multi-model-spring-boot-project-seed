# 多模块的SpringBoot项目脚手架

## 简介
本项目是一个基于SpringBoot&MyBatis的多模块项目脚手架，整个项目不同的功能会被拆分到不同的模块中去，比如`web`模块是可以运行的web项目，一般用来封装业务系统；`core`模块封装Dao层等最基本的代码等。这样可以比较方便的处理一个项目多个应用的情况

## 模块概览
parent 最外层的聚合模块 <br>
├─ core 整个项目的核心，聚合了返回模板，异常处理，DAO层，你也可以自己往里面添加每个模块都应该有的功能。几乎每个子模块都应该依赖它<br>
├─ web  一个主要的web应用，业务代码都应该在这，我已经写好了实例代码，后面的模块都可以仿照他完成 <br>
├─ admin 应用的管理端Web应用，我没有实现（需要的话自己实现，下同） <br>
├─ mobile 应用的移动端后端，没有实现 <br>
└─ common 一些公共的工具代码，没有实现 

剩下的模块可以根基自己的业务需求自行添加模块，只需要创建maven项目，在依赖core模块就可以上手编写需要的代码了。

## 相关配置
### MyBatis Generator和数据库配置
* 相关的代码全部在`core`模块中
* generator的配置文件：`sqlmap/auto/StudentExampleBeanMapper.xml`，修改其中的数据库信息和需要更改的表信息就好
* `core`模块的maven中配置了Generator的maven插件，修改好了generator的配置后使用插件启动generator即可
* generator会生成mapper.xml文件、mapper接口和Bean类（Pojo类），会放在起名为auto的文件夹/包下，我已经放入了用于演示的文件
* DataSource的bean配置在Core模块中，这样每个依赖core模块的模块都可以不用再写一遍dataSource，但是需要注意的是**依赖core模块的基础报名必须要和core模块的基础包名一样**，不然的话会导致DataSource这个Bean无法被注入
* 其他的模块虽然不用写DataSource这个Bean，但是还是需要在`application.yml`中配置数据库相关信息

### 2. swagger

`core`模块集成了swagger，使用时只需要修改每个模块中的`Swagger2`类，并且参照示例controller中的用法即可生成接口文档



### 3. 常量和基础响应结构

* 全局的常量字符串可以放到`ProjectConstant`类中，全局的返回之后状态码可以放到`Code`类中
* 所有的service都会返回一个基础的响应结构`BaseResult`，使用`BaseResultFactory`类中的方法传入`Code`对象和承载返回数据的POJO就可以快速打造规范化的响应
* 建议：在Service中返回的对象都应该是**带泛型的`BaseResult`类**的对象（除了data是空的情况），这样代码的可阅读性会大大提升。



### 4. 异常抛出

* 本系统拥有异常处理器：`GlobalExceptionHandlerAdvice`,在**业务代码**的任何地方都可以抛出异常，异常都会被异常处理器捕获并且抛出`BaseResult`
* 有标准的业务异常类`BusinessException`，推荐相关的业务异常继承这个类，业务流程中直接抛出，然后在异常处理器中处理

