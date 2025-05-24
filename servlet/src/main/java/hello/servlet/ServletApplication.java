package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan 
/*
 * "서블릿 자동등록"
 * @ServletComponentScan은 Spring Boot 애플리케이션에서 @WebServlet으로 둥록된
 * 서블릿 컴포넌트들을 자동으로 스캔하고 등록해주는 애너테이션이다. 
 */
public class ServletApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
