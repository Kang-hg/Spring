package spring;

public class AlreadyExistingMemberException extends RuntimeException{
	public AlreadyExistingMemberException(String message)
	{
		// RuntimeException에 객체를 생성할 때 문자열 전달합니다.
		// 전달을 하면 RuntimeException에서 여기서 정의한 문자열 출력이 됩니다.
		super(message);
	}
}
