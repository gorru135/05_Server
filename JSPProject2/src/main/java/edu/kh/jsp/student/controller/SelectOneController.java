package edu.kh.jsp.student.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.jsp.student.model.dto.Student;
import edu.kh.jsp.student.model.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/student/selectOne")
public class SelectOneController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentService service = new StudentService();
	
		
		try {
			String deptName = req.getParameter("deptName");
			
			List<Student> stdList = service.selectOne(deptName);
			
			req.setAttribute("stdList", stdList);
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}

		req.getRequestDispatcher("/WEB-INF/views/student/selectOne.jsp").forward(req, resp);
	}
}
