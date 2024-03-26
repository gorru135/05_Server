package edu.kh.todolist.todo.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.todolist.common.JDBCTemplate.*;
import edu.kh.todolist.todo.model.dao.TodoDAO;
import edu.kh.todolist.todo.model.dto.Todo;

public class TodoService {
	
	private TodoDAO dao = new TodoDAO();

	/** 로그인한 회원의 todoList 전체 조회하기 서비스
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public List<Todo> selectAll(int memberNo) throws Exception {
		Connection conn = getConnection();
		
		List<Todo> todoList = dao.selectAll(conn,memberNo);
		
		close(conn);
		
		return todoList;
	}
	
	
}
