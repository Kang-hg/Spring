package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.DuplicateMemberException;
import spring.Member;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	
	private MemberRegisterService memberRegisterService;
	
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	@RequestMapping("/register/step1")
	public String handleStep1()
	{
		return "register/step1";
	}
	
//	@PostMapping("/register/step2")
//	public String handleStep2(
//			@RequestParam(value = "agree", defaultValue = "false") Boolean agree)
//	{
//		if (!agree)
//		{
//			return "register/step1";
//		}
//		return "register/step2";
//	}
	
	@PostMapping("/register/step2")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model)
	{
		if (!agree)
		{
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}
	
	@PostMapping("/register/step3")
	public String handleStep3(RegisterRequest regReq, Errors errors)
	{
		new RegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors())
		{
			return "register/step2";
		}
		try
		{
			memberRegisterService.regist(regReq);
			return "register/step3";
		}
		catch (DuplicateMemberException ex)
		{
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}
	
	@RequestMapping("/login")
	public String handleLogin(Model model)
	{
		model.addAttribute("registerRequest", new RegisterRequest());
		return "login";
	}
	
	@RequestMapping("/main")
	public String handleStep4(RegisterRequest regReq)
	{
		return "main";
	}
	
	@PostMapping("/result")
	public String result(RegisterRequest regReq, Model model)
	{
		int count = memberRegisterService.checkCount(regReq);
		
		if (count > 0)
		{
			model.addAttribute("result", regReq.getEmail()+"??? ???????????????.");
		}
		else
		{
			model.addAttribute("result", "????????? ????????? ????????? ????????????.");
		}
		return "/main";
	}
	
//	@PostMapping("/main")
//	public String handleStep5(RegisterRequest regReq, Model model, Errors errors)
//	{
//		new RegisterRequestValidator().validateLogin(regReq, errors);
//		if (errors.hasErrors())
//		{
//			return "login";
//		}
//		try
//		{
//			memberRegisterService.loginCheck(regReq);
//			model.addAttribute("result", regReq.getEmail()+"??? ???????????????.");
//			return "main";
//		}
//		catch (MemberNotFoundException ex)
//		{
//			model.addAttribute("result", "????????? ???????????? ??????????????? ????????????.");
//			return "main";
//		}
//	}
	
	
	
	
}










