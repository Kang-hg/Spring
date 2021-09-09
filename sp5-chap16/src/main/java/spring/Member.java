package spring;

import java.time.LocalDateTime;

public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	private String birthdate;
	
	public Member(String email, String password,
			String name, LocalDateTime regDateTime)
	{
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = regDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}
	
	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public void changePassword(String oldPassword, String newPassword)
	{
		if(!password.equals(oldPassword))
		{
			throw new WrongIdPasswordException();
		}
		this.password = newPassword;
	}
	
	public boolean matchPassword(String password)
	{
		return this.password.equals(password);
	}
}





