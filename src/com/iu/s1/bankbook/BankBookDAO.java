package com.iu.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankBookDAO {
	
	
public int setWrite(BankBookDTO bankBookDTO) throws Exception{
	String user="user01";
	String password="user01";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String driver="oracle.jdbc.driver.OracleDriver";

	
	Class.forName(driver);
	
	Connection con = DriverManager.getConnection(url, user, password);
	
	String sql = "insert into bankbook(booknumber, bookname, bookrate, booksale) values(bank_seq.nextval, '?', ?, '?') ";
	
	PreparedStatement st = con.prepareStatement(sql);
	
	
	st.setString(1, bankBookDTO.getBookname());
	st.setDouble(2, bankBookDTO.getBookrate());
	st.setString(3, bankBookDTO.getBooksale());
	
	int result = st.executeUpdate();
	
	
	st.close();
	con.close();
	
	return result;
}
	
	
public BankBookDTO getSelect(long bookNumber) throws Exception{
	String user="user01";
	String password="user01";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String driver="oracle.jdbc.driver.OracleDriver";

	
	Class.forName(driver);
	
	Connection con = DriverManager.getConnection(url, user, password);
	
	String sql = "select * from bankbook where booknumber =? ";
	
	PreparedStatement st = con.prepareStatement(sql);
	
	st.setLong(1, bookNumber);
	
	ResultSet rs = st.executeQuery();
	
	BankBookDTO bankBookDTO = null;
	
    if(rs.next()) {
    	bankBookDTO = new BankBookDTO();
    	bankBookDTO.setBooknumber(rs.getLong("booknumber"));
    	bankBookDTO.setBookname(rs.getString("bookname"));
    	bankBookDTO.setBookrate(rs.getDouble("bookrate"));
    	bankBookDTO.setBooksale(rs.getString("booksale"));
    	
    	
    }
    
    
    rs.close();
    st.close();
    con.close();
    
    return bankBookDTO;
	
	
  
	
}
	//getList
	//bankbook table의  모든 데이터 조회 후  리턴 
	

	
  public List getList() throws Exception {
	  
	  String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";

		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "select * from bankbook";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<BankBookDTO> ar = new ArrayList<>();
		
	    while(rs.next()) {
	    	BankBookDTO bankBookDTO = new BankBookDTO();
	    	bankBookDTO.setBooknumber(rs.getLong("booknumber"));
	    	bankBookDTO.setBookname(rs.getString("bookname"));
	    	bankBookDTO.setBookrate(rs.getDouble("bookrate"));
	    	bankBookDTO.setBooksale(rs.getString("booksale"));
	    	
	    	ar.add(bankBookDTO);
	    }
	    
	    
	    rs.close();
	    st.close();
	    con.close();
	    
	    return ar;
		
		
	  
  }

}
