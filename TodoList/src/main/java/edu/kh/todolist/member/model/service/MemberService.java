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

	/** 회원가입 서비스
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.signUp(conn,member);
		
		if(result > 0)commit(conn);
		else rollback(conn);
		
		return result;
	}
}
