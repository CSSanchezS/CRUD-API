package example;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class Application {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		SpringApplication.run(example.Application.class, args);
		//openHomePage(); //with this line call automatically the web service
	}
	
	private static void openHomePage() throws IOException {
	       Runtime rt = Runtime.getRuntime();
	       rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/get");
	    }

}
