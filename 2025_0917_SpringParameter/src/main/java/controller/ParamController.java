package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vo.PersonVo;

@Controller
public class ParamController {

	
	//   /insert1.do?name=홍길동&age=30&tel=010-123-1234
	@RequestMapping("/insert.do")
	//	                 method의 인자는 호출의 주체(DS)에 대한 요구사항이다.
	public String insert1(String tel,int age,String name) {
		//				 파라미터에 오는 순서 관계 없이 해당 파라미터이름으로 매핑한다.
		System.out.println(name);
		System.out.println(tel);
		System.out.println(age);
		
		return "insert1";
	}
	//   /insert2.do?name=홍길동&age=30&tel=010-123-1234
	@RequestMapping("/insert1.do")
	//	                 method의 인자는 호출의 주체(DS)에 대한 요구사항이다.
	public String insert2(@RequestParam(name = "name", required=true) String irum,int age,String tel
			//				 받아온파라미터 이름 말고 다른걸로 쓰고싶을땐 위와같이 바꿀수있다.
							,@RequestParam(name="gender",defaultValue = "남자") String gender
							,Model model) {
		System.out.println(irum);
		
		System.out.println(age);
		System.out.println(tel);
		System.out.println(gender);
		//System.out.printf("%s, %d, %s, %s\n",irum,age,tel,gender);
		
		// Model을 통해서 전달 ->DS
		// DS-> model data를 request binding
		model.addAttribute("name",irum);
		model.addAttribute("age",age);
		model.addAttribute("tel",tel);
		
		return "result1";
	}
	
	
	// /insert2.do?name=홍길동&age=30&tel=010-123-1234
	@RequestMapping("/insert2.do")
	public String insert2(PersonVo vo, Model model) {
		//		  method(인자) -> DS에 대한 요구사항
		//		  1. 각각의 parameter를 받아서 PersonVo객체로 포장해준다.
		//		  2. 조건 : parameter이름하고 Vo의 속성명이 동일해야한다.
		
		// 결과적으로 request binding
		model.addAttribute("vo",vo);
		vo.getName();
		return "result2";
	}
	
	// /insert3.do?name=홍길동&age=30&tel=010-123-1234
	@RequestMapping("/insert3.do")
	public String insert3(@RequestParam Map map, Model model) {
		//				  DS에 대한 요구사항 : parameter -> Map으로 포장해줘
						 //   			  반드시 @RequestParam을 붙여야한다.
		System.out.println(map);
		model.addAttribute("map", map);
		
		return "result3";
	}
	
	
	
	
}
