package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //컨트롤러라고 어노테이션으로 꼬리표를 달아주는것이다.
public class TestController {
	
	@RequestMapping("/test.do")
	public String test(Model model) {
		
		//Data 생성 / 가공 .....
		String name = "홍길동";
		
		// model에 넣은 데이터는 DispatcherServlet에게 전달
		// DispatcherServlet는 데이터를 request binding 시킨다.
		model.addAttribute("name",name);
		
		return"test"; // ViewName : test
					  // DispatcherServlet -> ViewResolver에서 경로완성
					  // 					  /WEB-INF/views/test.jsp
					  //					  forward시킨다.
	}
	
	@RequestMapping("/test2.do")
	public ModelAndView test2() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", "김길동"); // Data (model)
		mv.setViewName("test2"); // test2.jsp  View
		
		return mv;
	}
}
