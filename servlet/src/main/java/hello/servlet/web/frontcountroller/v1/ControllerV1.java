package hello.servlet.web.frontcountroller.v1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * FrontController 패턴의 특징
 * 
 * 	1. 중앙 집중식 진입점 : 모든 HTTP 요청을 하나의 서블릿(FrontController)이 받아들임
 * 	2. 요청 분배 역할 : 요청 URL에 따라 적절한 실제 컨트롤러로 분기
 * 	3. 공통 처리 용이 : 인증, 로깅, 예외 처리, 보안 등 공통 로직을 한 곳에서 관리 가능
 *  4. 유지보수성 증가 : 컨트롤러 개별 구현은 단순해지고, 요청 흐름 제어는 프론트 컨트롤러가 담당
 *  5. 서블릿 종속 최소화 : 개별 컨트롤러는 더 이상 HttpServlet을 상속하지 않아도 됨
 * 
 *  스프링 MVC = FrontController 패턴
 *  
 *   1. DispatcherServlet : 스프링의 FrontController, 모든 요청을 이 서블릿이 받음
 *   2. @Controller 클래스들 : DispatcherSerlvet이 URL 매핑으로 찾아서 호출
 *   3. ViewResolver : 뷰 이름을 뷰 템플릿 경로로 바꿔주는 역할
 *   4. Model : 뷰에 전달할 데이터를 담는 객체
 */
public interface ControllerV1 {

	void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
