package spring;

public class RegisterRequest {
	
	// email, password, confirmPassword, name get set 구현
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// 비밀번호랑 비밀번호확인이랑 같은지 비교하는 함수
	public boolean isPasswordEqualToConfirmPassword()
	{
		return password.equals(confirmPassword);
	}
}
