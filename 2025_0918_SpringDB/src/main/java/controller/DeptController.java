package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDao;
import vo.DeptVo;

@Controller
public class DeptController {
	
	
	DeptDao dept_dao;

	// XML에서 Constructor Injection 사용하기위해서
	public DeptController(DeptDao dept_dao) {
		super();
		this.dept_dao = dept_dao;
	}
	
	//전체조회 코드
	@RequestMapping("/dept/list.do")
	public String list(Model model) {
		
		List<DeptVo> list = dept_dao.selectList();
		// model -> DS -> request binding
		model.addAttribute("list", list);
		
		return "dept/dept_list";
		//		/WEB_Inf/views/ + dept/dept_list + .jsp
		//		/WEB_Inf/views/dept/dept_list.jsp
		
	}
}
