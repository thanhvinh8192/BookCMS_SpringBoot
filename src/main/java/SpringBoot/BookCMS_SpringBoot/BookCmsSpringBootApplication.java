package SpringBoot.BookCMS_SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class BookCmsSpringBootApplication {
	public static void main(String[] args) {
		System.out.println("Starting Spring Boot Project");
		SpringApplication.run(BookCmsSpringBootApplication.class, args);
		System.out.println("Started Spring Boot Project");
	}

}
