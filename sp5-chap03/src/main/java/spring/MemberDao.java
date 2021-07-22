package spring;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long nextId = 0;
	
	// 컬렉션 Map -> <Key,Value> => 키가 문자열, 값이 Member
	private Map<String, Member> map = new HashMap<>();
	
	public Member selectByEmail(String email)
	{
		return map.get(email); // email값을 키로 써서 map에 있는 Member를 넘겨준다.
	}
	
	public void insert(Member member)
	{
		// 인자로 받은 member에서 setId 함수를 호출을 하는데 정수값은 nextId를 1을 증가해서 넣어줍니다.
		member.setId(++nextId);
		// Map컬렉션에 키값을 member에 이메일로 값을 member로 추가합니다.
		map.put(member.getEmail(), member);
	}
	
	public void update(Member member)
	{
		map.put(member.getEmail(), member);
	}
}
