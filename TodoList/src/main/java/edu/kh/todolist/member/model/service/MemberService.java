package edu.kh.todolist.member.model.service;

import java.sql.Connection;

import static edu.kh.todolist.common.JDBCTemplate.*;
import edu.kh.todolist.member.model.dao.MemberDAO;
import edu.kh.todolist.member.model.dto.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();

	/** 로그인 서비스
	 * @param inputId
	 * @param inputPw
	 * @return member
	 */
	public Member login(String inputId, String inputPw) throws Exception{
		Connection conn = getConnection();
		
		Member member = dao.login(conn, inputId, inputPw);
		
		close(conn);
		
		return member;
	}
}
