package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.Member;
import spring.MemberDao;

@Controller
public class MemberListController {
	
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@RequestMapping("/members")
	public String list(
			@ModelAttribute("cmd") ListCommand listCommand,
			Errors errors, Model model /* 결과값을 View로 올리기 위해 */)
	{
		if (errors.hasErrors())
		{	// 에러가 발생하면 유효성 검사 - LoginCommandValidator 오버라이딩
			return "member/memberList";
		}
		
		// from, to에 값이 있으면
		if (listCommand.getFrom() != null && listCommand.getTo() != null)
		{	// 컬렉션 프레임워크인 리스트에 담는게 Member인 변수 members를 만들어서
			// select 결과를 담는다.
			// Controller => Dao
			// Dao(result) => members
			List<Member> members = memberDao.selectByRegdate(
					listCommand.getFrom(), listCommand.getTo());
			// ui에 사용할 수 있는 model에 members라는 이름으로 정하고 데이터는
			// List<Member> members 대입
			model.addAttribute("members", members);
		}
		return "member/memberList";
	}
	
}










