package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Service.NewService;
import spring.LoginData;
import spring.RegisterData;

@Controller
public class NewController {
	
	private NewService service;
	
	public NewController(NewService service) {
		this.service = service;
	}
	
	
	// main => login
	@GetMapping("/")
	public String firstLogin(Model model)
	{
		model.addAttribute("loginData", new LoginData());
		return "/mainLogin";
	}
	
	// 회원가입화면
	@GetMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("registerData", new RegisterData());
		return "/register";
	}
	
	// 회원가입 버튼 입력 시 실행
	@PostMapping("/submit")
	public String submit(RegisterData rd)
	{
		System.out.println(rd.getName());
		service.insert(rd);
		// DB 회원가입이 진행되는 소스
		return "/mainLogin";
	}
	
	// 로그인 성공 또는 실패 시 나오는 화면
//	@PostMapping("/runLogin")
//	public String runLogin()
//	{
//		
//		// DB 로그인 확인이 진행되는 소스
//		if ()
//		{
//			// 성공 시 나오는 화면 출력
//			return
//		}
//		else
//		{	// 실패 시 나오는 화면 출력
//			
//		}
//	}
	
}















