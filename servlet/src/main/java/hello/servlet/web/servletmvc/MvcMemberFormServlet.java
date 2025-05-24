package hello.servlet.web.servletmvc;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 *  /WEB-INF 폴더 안에 있는 JSP는 직접 접근할 수 없다.
	 *  
	 *  웹 브라우저가 직접 http://localhost:8080/WEB-INF/views/new-form.jsp 으로 
	 *  접근하려고 하면 404 오류가 난다. WEB-INF는 외부에서 URL로 직접 접근할 수 없도록 Tomcat이 차단해놓음.
	 *  
	 *  JSP는 오직 컨트롤러(Servlet)를 통해서만 보여지도록 하기 위함. 
	 *  JSP는 오직 뷰 역할만 해야 하고, 컨트롤러가 사용자 요청을 받아 적절한 JSP로 전달해야 한다.
	 *  
	 *  forward VS redirect
	 *  
	 *  forward : 서버 내부에서 JSP나 다른 컨트롤러로 요청을 넘김. (URL 그대로 유지)
	 *  request 객체를 공유하고 JSP에 데이터를 넘기며 뷰를 보여줄 때 사용한다.
	 *  
	 *  redirect : 쿨라이언트에게 새로운 요청을 하라고 응답을 보냄. (URL 바뀜)
	 *  다시 요청하므로 같은 request 객체를 공유하지 않는다. 작업 후 다른 URL로 이동시킬 때에 사용한다.
	 *  
	 */
	
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String viewPath = "/WEB-INF/views/new-form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		
		/*
		 * 디스패쳐 : 서버 내부에서 다른 리소스(JSP나 서블릿)로 요청을 전달(forward) 하거나,
		 * 특정 방식으로 처리를 위임하기 위헤 사용되는 객체이다. 포워딩 과정은 클라이언트가 모르게 
		 * 진행된다. URL이 바뀌지 않기 때문에 보안상 JSP 경로를 숨길 수 있는 장점도 있다. 
		 *
		 * dispatcher.forward() : 다른 서블릿이나 JSP로 이동할 수 있는 기능이다. 
		 * 서버 내부에서 다시 호출이 발생한다.
		 */
		dispatcher.forward(request, response);
		
	}
}
