package com.iu.s1.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MemberDAO {
	
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
		
		st.setString(1, memberDTO.getID());
		st.setString(2, memberDTO.getPW());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			memberDTO.setNAME(rs.getString("NAME"));
			memberDTO.setEMAIL(rs.getString("EMAIL"));
			memberDTO.setPHONE(rs.getString("PHONE"));
		} else {
			
			memberDTO = null;
		}
		
		rs.close();
		st.close();
		con.close();
		
		return memberDTO;
		
	}

}
