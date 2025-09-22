package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.PhotoDao;
import vo.PhotoVo;

@Controller
public class PhotoController {

	@Autowired
	PhotoDao photo_dao;
	
	public PhotoController() {
		System.out.println("-[PhotoController()]");
	}
	
	//전체조회
	@RequestMapping("/photo/list.do")
	public String list(Model model) {
		
		List<PhotoVo> list =photo_dao.selectList();
		
		//결과적으로 request binding
		model.addAttribute("list", list);
		
		return "photo/photo_list";
	}
	
}
