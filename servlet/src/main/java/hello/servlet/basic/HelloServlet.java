package hello.servlet.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
/*
 * @WebServlet : 이 애너테이션은 서블릿 클래스를 서블릿 컨테이너에 등록할 때 쓰인다.
 * 	즉, 톰캣 같은 서블릿 컨테이너가 이 클래스를 인식해서 HTTP 요청이 들어올 때 
 *  적절한 URL를 매핑하여 해당 서블릿을 실행하게 해줌.
 */
public class HelloServlet extends HttpServlet {

	/*
	 * 서블릿 컨테이너 동작 방식
	 * 
	 * 1. 내장 톰캣 서버 생성 (Spring Boot)
	 *  스프링부트 애플리케이션을 실행하면 내장 톰캣 서버가 함께 실행됨.
	 *  이 서버는 서블릿 컨테이너 역할을 수행함.
	 *  @ServletComponenetScan으로 설정된 서불릿(@WebServlet 등)을 찾아 톰캣에 등록.
	 * 
	 * 2. HTTP 요청 수신
	 *  클라이언트(브라우저)가 /hello?username=John과 같은 URL로 요청을 보냄
	 *  내장 톰캣은 요청을 받아 해당 경로에 매핑된 서블릿을 찾음 (urlPatterns = "/hello)
	 * 
	 * 3. HttpServletRequest / HttpSerlvetResponse 생성
	 *  서블릿 컨테이너는 HTTP 요청을 받아 다음 객체들을 생성: 
	 *  	HttpServletRequest : 요청 데이터 보관 (파라미터, 헤더 등)
	 *  	HttpServletResponse : 응답을 작성하는 객체 
	 *  
	 * 4. 서블릿 호출
	 *  /hello 경로에 매핑된 HelloServlet 클래스의 service() 메서드 실행
	 *  이때 톰캣이 만든 두 객체를 메서드의 매개변수로 전달함
	 *  
	 * 5. 응답 전송
	 * 	서블릿이 response.getWriter.write("hello : " + username)처럼 응답을 작성하면
	 *  서블릿 컨테이너는 이를 기반으로 HTTP 응답 메세지를 만들어 클라이언트에 전달함
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {
		
		System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        
        String username = request.getParameter("username");
        
        System.out.println("username = " + username);
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
	}
}
