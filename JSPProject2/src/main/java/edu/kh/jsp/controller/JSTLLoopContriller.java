package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.model.dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/loop")
public class JSTLLoopContriller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<Book> bookList = new ArrayList<Book>();
		
		bookList.add(new Book("자바의 정석", "남궁성",30000));
		bookList.add(new Book("자바의 정석2", "남궁성2",20000));
		bookList.add(new Book("자바의 정석3", "남궁성3",10000));
		bookList.add(new Book("자바의 정석4", "남궁성4",40000));
		
		req.setAttribute("bookList", bookList);
		
		req.getRequestDispatcher("/WEB-INF/views/jstl/loop.jsp").forward(req, resp);
		
	 
	}
}
