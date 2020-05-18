## spring-boot-demo项目
- 初始化项目，引入web依赖
- 项目入口Application中添加简单接口，返回字符串：
> Hello! Docker!
- 根目录添加Dockerfile文件
```dockerfile
FROM maven:3.3.3

ADD pom.xml /tmp/build/
RUN cd /tmp/build && mvn -q dependency:resolve

ADD src /tmp/build/src

RUN cd /tmp/build && mvn -q -DskipTests=true package \
    && mv target/*.jar /app.jar \
    && cd / && rm -rf /tmp/build

VOLUME /tmp
EXPOSE 8033
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
```
- 使用docker构建镜像文件
```shell
docker build -t docker-demo-spring-boot .
```
- 查看构建成功的镜像
```shell
docker images|grep docker-demo
```
- 从镜像启动容器
```shell
docker run -d -p 8033:8080 docker-demo-spring-boot
```
- 查看启动成功的容器
```
docker ps|grep docker-demo
```
- 访问项目
```shell
curl http://localhost:8033
```
会看到输出
```
Hello! Docker!
```

