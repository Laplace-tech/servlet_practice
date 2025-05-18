package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // @WebServlet으로 등록된 서블릿 자동 스캔
public class ServletApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
