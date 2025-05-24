package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse
    response) throws ServletException, IOException {
    	
        //[status-line] HTTP 응답코드 지정
        response.setStatus(HttpServletResponse.SC_OK); //200
        
        //[response-headers] 헤더 생성
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, mustrevalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header","hello");
        
        //[Header 편의 메서드]
        content(response);
        cookie(response);
        //redirect(response);
        
        //[message body] 바디 생성
        PrintWriter writer = response.getWriter();
        writer.println("ok");
	}
    
    private void content(HttpServletResponse response) {
        response.setContentType("text/plain"); // Content-Type 헤더를 설정
        response.setCharacterEncoding("utf-8"); 
    }
    
    private void cookie(HttpServletResponse response) {
        // 클라이언트에게 myCookie=good 이라는 이름과 값을 가지는 쿠키를 보내고, 유효시간을 600초로 설정함
        Cookie cookie = new Cookie("myCookie", "good"); 
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }
    
    private void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/basic/hello-form.html");
    }
}