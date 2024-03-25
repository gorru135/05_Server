package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")// 현재 클래스를 Servlet 등록 +/login 요청을 처리
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전달받은 값(파라미터) 다 얻어와 변수에 저장 
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		// 입력된 ID/PW 가 user01/pass01 이면 "로그인 성공"
		// 아니면 "아이디 또는 비밀번호가 일치하지 않습니다" 출력 
		
		String message = null;
		
		if(id.equals("user01") && pw.equals("pass01") ) {
			message = "로그인 성공";
			
		} else {
			message = "아이디 또는 비밀번호가 일치하지 않습니다";
		}
		
		// Servlet 으로 클라이언트에게 응답할 와면을 만들어야함. 
		// -> 작성하기 힘드니까 JSP로 위임 
		
		// Request : 요청 
		// Dispatcher : 발송자, 필요한 정보를 제공하는자, 역활을 넘긴다.. 
		
		// RequestDispatcher : 요청 정보, (응답)역활을 넘기는 객체 
		
		// ** JSP 경로 작성방법 ** 
		// -> webapp폴더 기준으로 경로를 작성 
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/WEB-INF/views/loginResult.jsp");
		
		// message 값을 속성(attribute)으로 추가 
		// -> MAP 형식으로 작성 (K:V) 
		req.setAttribute("message", message);
		
		
		//***********
		// forward 
		// 전송하다, 전달하다, 보내다 
		
		// forward를 하면 
		// 주소창이 요청 주소로 바뀌고 
		// 그 요청에 맞는 화면으로 변함 
		// 요청에 맞는 응답을 했기 때문에..
		
		// -> servlet이 가지고 있던 req, resp 객체를 
		// 		jsp에게 전달하여 요청을 위임
		
		dispatcher.forward(req, resp);
	
	}
}
