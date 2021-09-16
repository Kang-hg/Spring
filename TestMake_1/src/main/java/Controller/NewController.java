package Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String firstLogin()
	{
		return "/mainLogin";
	}
	
	// 로그인 성공 또는 실패 시 나오는 화면
	@PostMapping("/runLogin")
	public String runLogin(/*@RequestParam Map<String, Object> paramMap*/ HttpServletRequest req)
	{
//		String id = paramMap.get("id").toString();
//		String pw = paramMap.get("password").toString();
//		
//		LoginData ld = new LoginData();
//		ld.setId(id);
//		ld.setPassword(pw);
		
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		
		LoginData ld = new LoginData();
		ld.setId(id);
		ld.setPassword(pw);
		
		int count = service.checkCount(ld);
		// DB 로그인 확인이 진행되는 소스
		if (count > 0)
		{// 성공 시 나오는 화면 출력
			return "/sucess";
		}
		else
		{	// 실패 시 나오는 화면 출력
			return "/fail";
		}
	}
	
}















