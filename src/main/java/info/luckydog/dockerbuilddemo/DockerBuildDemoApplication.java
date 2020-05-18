package info.luckydog.dockerbuilddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerBuildDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerBuildDemoApplication.class, args);
    }

    @RequestMapping("")
    public String hello(){
        return "Hello! Docker!";
    }

}
