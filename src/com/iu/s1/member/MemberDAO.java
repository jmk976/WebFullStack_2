package com.iu.s1.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MemberDAO {
	
	//memberJoin 데이터를 받아서 Db에 insert하는 메서드
	
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";

		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		con.setAutoCommit(false);
		
		String sql = "insert into member(id, pw, name, phone, email) values(?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql); 
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		
		int result = st.executeUpdate();
		
		if(result>0) {
			con.commit();
		} else {
			con.rollback();
		}
		
		con.setAutoCommit(true);
		
		st.close();
		con.close();
		
		return result;
		
		
	}
	
	//login -id pw 를 받아서 조회
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		
		
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
	

		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql ="select * from member where id=? and pw=?";
		
		PreparedStatement st = con.prepareStatement(sql); 
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setPhone(rs.getString("phone"));
		} else {
			
			memberDTO = null;
		}
		
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
		
	}

}
