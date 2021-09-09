package controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;

@Controller
public class MemberDetailController {
	
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	// 예 id = 7
	@GetMapping("/members/{id}")
	public String detail(@PathVariable("id") Long memId, Model model)
	{	// memberDao => selectById(7)
		Member member = memberDao.selectById(memId);
		// Member가 null 인지 확인
		if (member == null)
		{	// null이면 MemberNotFoundException 호출
			throw new MemberNotFoundException();
		}
		// null이 아니면 실행
		// ui 모델에 추가 => 이름은 member, 데이터는 Member member
		model.addAttribute("member", member);
		// memberDetail.jsp 호출
		return "member/memberDetail";
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException()
	{
		return "member/invalidld";
	}
	
	@ExceptionHandler(MemberNotFoundException.class)
	public String handleMemberNotFoundException()
	{
		return "member/noMember";
	}
	
}






