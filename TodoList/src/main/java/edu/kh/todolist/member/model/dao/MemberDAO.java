package edu.kh.todolist.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import static edu.kh.todolist.common.JDBCTemplate.*;
import edu.kh.todolist.member.model.dto.Member;

public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MemberDAO() {
		try {
			
			prop = new Properties();
			
			String filePath 
				= MemberDAO.class.getResource("/edu/kh/todolist/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 로그인 SQL 수행 DAO
	 * @param conn
	 * @param inputId
	 * @param inputPw
	 * @return member
	 * @throws Exception
	 */
	public Member login(Connection conn, String inputId, String inputPw) throws Exception {
		Member member = null;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			
				member = new Member();
				
				member.setMemberNo( rs.getInt(1) );
				member.setMemberId(rs.getString(2));
				member.setMemberNickname(rs.getString(3));
				member.setEnrollDate(rs.getString(4));
				
				
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}

	/** 회원  가입 SQL 수행 DAO
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickname());
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			
			close(pstmt);
		}
		
		
		return result;
	}

}
