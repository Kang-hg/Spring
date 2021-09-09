package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
import controller.RegisterController;
import spring.MemberRegisterService;
import survey.SurveyController;
*/

import Controller.NewController;
import Service.NewService;
@Configuration
public class ControllerConfig {
/*
	@Autowired
	private MemberRegisterService memberRegSvc;

	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
	
	@Bean
	public SurveyController surveyController() {
		return new SurveyController();
	}
	*/
	
	
	@Autowired
	private NewService service;
	
	@Bean
	public NewController controller()
	{
		NewController c = new NewController(service);
		return c;
	}
}








