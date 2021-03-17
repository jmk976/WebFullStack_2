package com.iu.s1.bankbook;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iu.s1.util.ActionForward;

public class BankBookService {
	
	private BankBookDAO bankBookDAO;
	
	public void setBankBookDAO(BankBookDAO bankBookDAO) {
		this.bankBookDAO = bankBookDAO;
	}
	
	
	public ActionForward setWrite(HttpServletRequest request) throws Exception{
		ActionForward actionForward = new ActionForward();
		
	     
		System.out.println("set Write");
		
		//GET
		actionForward.setPath("../WEB-INF/bankbook/bankbookWrite.jsp");
		actionForward.setCheck(true);
		
		if(request.getMethod().toUpperCase().equals("POST")) {
			System.out.println(request.getParameter("bookname"));
			BankBookDTO bankBookDTO = new BankBookDTO();
			
			bankBookDTO.setBookname(request.getParameter("bookname"));
			bankBookDTO.setBookrate(Double.parseDouble(request.getParameter("bookrate")));
			bankBookDTO.setBooksale(request.getParameter("booksale"));
			
			 int result= bankBookDAO.setWrite(bankBookDTO);
			 System.out.println(result);
			 //DAO
			 actionForward.setPath("./bankbooklist.do");
			 actionForward.setCheck(false);
			 
			
		}
		return actionForward;
	}
	
	//bankbook 1개의 row 조회
	
	public ActionForward getSelect(HttpServletRequest request) throws Exception{
		
		ActionForward actionForward = new ActionForward();
		
		
		Long booknumber = Long.parseLong(request.getParameter("booknumber"));
		
		BankBookDTO bankBookDTO = bankBookDAO.getSelect(booknumber);
		
		actionForward.setPath("../WEB-INF/bankbook/bankbookSelect.jsp");
		actionForward.setCheck(true);
		
		request.setAttribute("select", bankBookDTO);
		
		
		return actionForward;
		
	}
	
	
	
	
	//getList dao의 getList 호출  후 리턴  
	
   public ActionForward getList(HttpServletRequest request) throws Exception{
	   
	   ActionForward actionForward = new ActionForward();
	   List<BankBookDTO> ar = bankBookDAO.getList();
//	   String method = request.getMethod();
	   
	   request.setAttribute("list", ar);
	   actionForward.setPath("../WEB-INF/bankbook/bankbooklist.jsp");
	   actionForward.setCheck(true);
	   
//	   if(method.toUpperCase().equals("POST")) {
//		   BankBookDTO bankBookDTO = new BankBookDTO();
//		   bankBookDTO.setBookname(request.getParameter("bookname"));
//		   bankBookDTO.setBooknumber(Integer.parseInt(request.getParameter("booknumber")));
//		   bankBookDTO.setBookrate(Double.parseDouble(request.getParameter("bookrate")));
//		   bankBookDTO.setBooksale(request.getParameter("booksale"));
//		   
//		   ArrayList ar =bankBookDAO.getList(bankBookDTO);
//		   
//		   actionForward.setPath("../index.do");
//		   actionForward.setCheck(false);
//	   }
	   
	   return actionForward;
   }

}
