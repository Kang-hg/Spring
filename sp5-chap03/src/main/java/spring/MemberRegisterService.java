package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public Long regist(RegisterRequest req)
	{
		// Member 자료형을 하는 member 변수를 만들고
		// 그 값은 memberDao에 selectByEmail 함수를 호출하고 req변수의 getEmail 함수에서 리턴되는 값을 넘겨준다.
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) // member에 값이 있다는것 똑같은 이메일 있다는 겁니다.
		{
			throw new DuplicateMemberException("dup email" + req.getEmail());
			// Exception이 발생합니다. "dup email" + req.getEmail()이 값을 넘겨주면서 발생합니다.
			
		}
		// Member 객체를 생성합니다. 변수 이름은 newMember
		// 객체 생성할 때 들어가는 인자는 이메일, 패스워드, 이름, 현재시간 들어값니다.
		Member newMember = new Member(
				req.getEmail(), req.getPassword(),
				req.getName(), LocalDateTime.now());
		//memberDao에서 insert 함수를 호출을 하는데 newMember의 값을 인자로 넣어줍니다.
		memberDao.insert(newMember);
		
		// 리턴 값을 새로 추가된 정수형 ID를 줍니다.
		return newMember.getId();
	}
}
