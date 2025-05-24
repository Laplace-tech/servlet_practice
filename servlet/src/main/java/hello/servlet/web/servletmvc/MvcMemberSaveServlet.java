package hello.servlet.web.servletmvc;

import java.io.IOException;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * <!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<!-- FROM : http://localhost:8080/servlet-mvc/members/new-form
	 TO :   http://localhost:8080/servlet-mvc/members/save -->
 */

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(username, age);
		System.out.println("member = " + member);
		memberRepository.save(member);
		
		request.setAttribute("member", member);
		
		String viewPath = "/WEB-INF/views/save-result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
		
	}

}
