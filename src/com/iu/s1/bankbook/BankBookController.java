package com.iu.s1.bankbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iu.s1.util.ActionForward;

/**
 * Servlet implementation class BankBookController
 */
@WebServlet("/BankBookController")
public class BankBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BankBookService bankBookService;
	
	@Override
	public void init() throws ServletException {
		//Controller 객체 생성후 자동 호출되는 초기화 메서드
	     bankBookService = new BankBookService();
	     BankBookDAO bankBookDAO = new BankBookDAO();
	     bankBookService.setBankBookDAO(bankBookDAO);
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MemberController 참조 해서 완성
		
		//한글 Encoding 처리 모든 Controller에 다 작성
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
		
		
		
		System.out.println("Bank Controller!");
		String uri=request.getRequestURI();
		System.out.println(uri);
		int index = uri.lastIndexOf("/");
		uri = uri.substring(index+1);
		System.out.println(uri);

		
		
		
		ActionForward actionForward = null;
		
		
			
			try {
				if(uri.equals("bankbooklist.do")) {
				actionForward = bankBookService.getList(request);
				} else if(uri.equals("bankbookSelect.do")) {
				actionForward = bankBookService.getSelect(request);
				} else if(uri.equals("bankbookWrite.do")){
				actionForward = bankBookService.setWrite(request);
				} else {
					System.out.println("그 외 다른 처리");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("error!!!");
				e.printStackTrace();
			}
			
		
		
		
		//forward
		if(actionForward.isCheck()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
		} else {
			response.sendRedirect(actionForward.getPath());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
