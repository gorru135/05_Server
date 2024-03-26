package edu.kh.jsp.student.model.dao;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static edu.kh.jsp.common.JDBCTemplate.*;
import edu.kh.jsp.student.model.dto.Student;

public class StudentDAO {
	
	// JDBC 객체 저장용 참조 변수 선언 
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	private Properties prop;
	
	// 기본생성자로 객체가 생성될 때
	// sql이 작성된 xml 파일 읽어와 prop저장
	public StudentDAO() {
	
		try {
			
			String filePath = 
					StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
			
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch( Exception e) {
			e.printStackTrace();
		}
	}

	/** 학생 전체 조회 dao
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Student> selectAll(Connection conn) throws Exception {
		
		// 1. 결과 저장용 변수 선언
		List<Student> stdList = new ArrayList<Student>();
		
		try {
			// 2. sql 작성
			String sql = prop.getProperty("selectAll");
			
			// 3. Statment 객체 생성
			stmt = conn.createStatement();
			
			// 4. sql 수행 후 결과 반환받기
			rs = stmt.executeQuery(sql);
			
			// 5. ResultSet 1행씩 접근하면서 List에 옮겨 담기
			while(rs.next()) {
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				Student std = new Student(studentNo,studentName,studentAddress,departmentName);
				
				stdList.add(std);			
			}
						
		} finally {
			// 6. 사용한 JDBC 객체 자원 반환 
			close(rs);
			close(stmt);
		}
		
		// 7. 결과 반환
		return stdList;
	}

	public List<Student> selectArch(Connection conn) throws Exception {
		List<Student> stdList = new ArrayList<Student>();
		
		try {
			
			String sql = prop.getProperty("selectArch");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				Student std = new Student(studentNo,studentName,studentAddress,departmentName);
				
				stdList.add(std);			
				
			}
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return stdList;
	}

	public List<Student> selectOne(Connection conn, String deptName) throws Exception{
		
		List<Student> stdList = new ArrayList<Student>();
		
		try {
			
			String sql = prop.getProperty("selectOne");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptName);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				Student std = new Student(studentNo,studentName,studentAddress,departmentName);
				
				stdList.add(std);			
				
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return stdList;
	}
}
