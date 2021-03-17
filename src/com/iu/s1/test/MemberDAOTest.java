package com.iu.s1.test;

import com.iu.s1.member.MemberDAO;
import com.iu.s1.member.MemberDTO;

public class MemberDAOTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Web 에서 메인 메서드는 테스트 용도로만 사용
		

		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
	     memberDTO.setId("id3");
	     memberDTO.setPw("id3");
	     memberDTO.setName("id3");
	     memberDTO.setPhone("010-2223344");
	     memberDTO.setEmail("id3@naver.com");
	     
		int result =memberDAO.memberJoin(memberDTO);
		
		if(result>0) {
			System.out.println("회원가입 정보 입력 성공");
		}else {
			System.out.println("회원가입 정보 입력 실패!	");
		}
	}

}
