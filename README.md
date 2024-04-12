# 湖南机电web作业（非JSP）
使用Spring Boot + Thymeleaf实现JSP作业的相关需求，
并使用kotlin + gradle管理项目依赖，
权当复习。

## 使用方式
1. 安装Docker
2. 填写 `app/src/main/resources/application.properties` 中的OpenAI-API-Key项。 （必须，不然项目启动不了，或者把springframework.ai给删了也行。）
3. 运行 `app/src/main/kotlin/com/hnjd/hyx/Application.kt`
4. 访问对应Controller的路径即可