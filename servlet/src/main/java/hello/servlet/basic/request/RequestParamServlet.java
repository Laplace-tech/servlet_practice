package hello.servlet.basic.request;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * HTTP 요청 데이터 : HTTP 요청 메세지를 통해 클라이언트에서 서버로 데이터를 전달
 * 
 * 1. GET 방식 : URL에 쿼리 파라미터를 포함해서 데이터를 전달
 *  메세지 바디가 없이 URL에 직접 데이터가 붙음(Content-Type 헤더가 없음),
 *  주로 검색이나 필터, 페이징 등에 사용함.
 *  
 * 2. POST 방식 (HTML Form): content-type: application/x-www-form-urlencoded
 * 	데이터를 HTTP 메세지 바디에 담아서 전송한다. 회원가입, 상품 주문 시 주로 사용
 * 
 * 위의 두 방식은 클라이언트 입장에서는 차이가 있지만 서버 입장에서는 동일함
 * 
 * 3. POST 방식 (API 전송): 메세지 바디에 JSON 같은 포맷으로 직접 데이터를 담아 전송
 */

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[전체 파라미터 조회] - start");

		request.getParameterNames().asIterator()
				.forEachRemaining(paramName 
						-> System.out.println(paramName + "=" + request.getParameter(paramName)));
		System.out.println("[전체 파라미터 조회] - end");
		System.out.println();

		System.out.println("[단일 파라미터 조회]");
		String username = request.getParameter("username");
		System.out.println("request.getParameter(username) = " + username);

		String age = request.getParameter("age");
		System.out.println("request.getParameter(age) = " + age);
		System.out.println();

		System.out.println("[이름이 같은 복수 파라미터 조회]");
		System.out.println("request.getParameterValues(username)");
		String[] usernames = request.getParameterValues("username");
		for (String name : usernames) {
			System.out.println("username=" + name);
		}

		resp.getWriter().write("ok");
	}

}
