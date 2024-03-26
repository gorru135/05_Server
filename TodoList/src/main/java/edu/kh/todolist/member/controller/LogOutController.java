package edu.kh.todolist.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOutController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// HTTPSession 을 얻어와 
		HttpSession session = req.getSession();
		
		// Session을 무효화 하고 
		session.invalidate();
		
		// 메인 페이지를 재요청(redirect)
		resp.sendRedirect("/");
	}
	
}
