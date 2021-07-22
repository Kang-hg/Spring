package spring;

public class ChangePasswordService {
	
	private MemberDao memberDao;
	// changePassword 인자로 email oldPwd newPwd
	public void changePassword(String email, String oldPwd, 
			String newPwd) 
	{
		// 같은 email이 있는지 확인절차
		Member member = memberDao.selectByEmail(email);
		if (member == null)
		{
			throw new MemberNotFoundException();
		}
		// changePassword 함수를 호출 oldPwd newPwd 문자열을 인자로 넣어서 호출
		member.changePassword(oldPwd, newPwd);
		
		// memberDao에 update 함수를 호출 할 때 member 변수를 넣어줍니다.
		memberDao.update(member);
	}

	// MemberDao Set 해주는 함수
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
}
