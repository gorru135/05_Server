package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test/result")
public class TestController extends HttpServlet{
	
	// a 태그의 href 속성을 통해서 요청받음 -> GET요청 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 사용X, 값 세팅 X 
		// 바로 JSP로 위임코드 작성 
		RequestDispatcher dispatcher =req.getRequestDispatcher("/WEB-INF/views/testResult.jsp");
		
		dispatcher.forward(req, resp);
	}
}
