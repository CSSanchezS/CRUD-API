package example;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		SpringApplication.run(example.Application.class, args);
		
	}
	
}
