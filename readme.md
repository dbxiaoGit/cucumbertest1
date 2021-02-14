
***
# gradle配置
## gradle-wrapper.properties
```
    distributionBase=GRADLE_USER_HOME
    distributionPath=wrapper/dists
    distributionUrl=file:///d:/BaiduNetdiskDownload/gradle-6.7.1-all.zip
    zipStoreBase=GRADLE_USER_HOME
    zipStorePath=wrapper/dists
    org.gradle.jvmargs=-Dfile.encoding=UTF-8
```
## 仓库配置
```groovy
    maven { url 'http://maven.aliyun.com/nexus/content/groups/public/' }
```
## 添加依赖
```groovy
    implementation 'io.cucumber:cucumber-java8:6.9.1'
    implementation 'io.cucumber:cucumber-spring:6.9.1'
    implementation 'org.projectlombok:lombok:1.18.16'
    implementation 'org.springframework.boot:spring-boot-starter-logging:2.4.2'
    implementation 'org.springframework.boot:spring-boot-starter-test:2.4.2'

    annotationProcessor 'org.projectlombok:lombok:1.18.16'
    testAnnotationProcessor 'org.projectlombok:lombok:1.18.16'
```
## 添加配置
```groovy
    configurations {
        cucumberRuntime {
            extendsFrom testImplementation
        }
    }
```
## 添加任务
```groovy
    task cucumber() {
        dependsOn assemble, testClasses
        doLast {
            javaexec {
                main = "io.cucumber.core.cli.Main"
                classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
                args = ['--plugin', 'pretty','--plugin','json:target/cucumber.json', '--glue', 'cn.rbl', 'src/test/resources' ]
            }
        }
    }
```
***
# 执行命令
* gradle clean cucumber -Dfile.encoding=UTF-8
* chmod 777 gradlew && ./gradlew :runtest:clean cucumber -Dfile.encoding=UTF-8

***
# 其他
```
    cucumber-spring 6.9.1包含
    5.3.2版本的
    spring-web 
    spring-webmvc
    spring-context-support
    spring-test
```
