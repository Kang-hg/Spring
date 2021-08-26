package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {

	private MemberDao memberDao;
	
	// 생성자 오버로딩
	public MemberRegisterService()
	{
		
	}
	
	public MemberRegisterService(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	
	
	
	public Long regist(RegisterRequest req)
	{
		Member member = memberDao.selectByEmail(req.getEmail());
		
		if(member != null)
			throw new DuplicateMemberException("dup email" + req.getEmail());
		
		Member newMember = new Member(req.getEmail(),req.getPassword(),
				req.getName(),LocalDateTime.now(), req.getBirthdate());
		memberDao.insert(newMember);
		return newMember.getId();
		
	}
	
	public boolean loginCheck(RegisterRequest req)
	{
		Member member = memberDao.selectByEmailPassword(req.getEmail(), req.getPassword());
		
		if (member == null)
		{
			throw new MemberNotFoundException();
		}
		
		if (member.getPassword().equals(req.getPassword()))
		{
			return true;
		}
		else
			return false;
	}

//	public int checkCount(RegisterRequest req)
//	{
//		int count = memberDao.checkCount(req.getEmail(), req.getPassword());
//		return count;
//	}
	
}



