package com.iu.s1.test;

import java.util.List;

import com.iu.s1.bankbook.BankBookDAO;
import com.iu.s1.bankbook.BankBookDTO;

public class BankBookDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankBookDAO bankBookDAO = new BankBookDAO();
//		List<BankBookDTO> ar;
		try {
			
			BankBookDTO bankBookDTO = bankBookDAO.getSelect(10);
			System.out.println(bankBookDTO != null);
//			ar = bankBookDAO.getList();
//			System.out.println(ar.size()==4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}