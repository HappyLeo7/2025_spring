package controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dao.PhotoDao;
import vo.MemberVo;
import vo.PhotoVo;

@Controller
public class PhotoController {

	@Autowired
	PhotoDao photo_dao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext application;
	
	@Autowired
	HttpServletRequest request;
	
	public PhotoController() {
		System.out.println("-[PhotoController()]");
	}
	
	//전체조회
	@RequestMapping("/photo/list.do")
	public String list(Model model) {
		
		List<PhotoVo> list =photo_dao.selectList();
		//System.out.println(list.get(0).getP_filename());
		//결과적으로 request binding
		model.addAttribute("list", list);
		
		return "photo/photo_list";
	}
	
	//TODO 등록폼 띄우기
	@RequestMapping("/photo/insert_form.do")
	public String insert_form() {
		
		return "photo/photo_insert_form";
	}
	
	//추가
	@RequestMapping("/photo/insert.do")
	public String insert(PhotoVo vo,@RequestParam MultipartFile photo
							,RedirectAttributes ra) throws Exception{
		
		//세션에서 로그인 정보 가져오기
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		//Session Timeout
		if(user==null) {
			ra.addAttribute("reason","session_timeout");
			// redirect:../member/login_form.do?reason=session_timeout
			return "redirect:../member/login_form.do";
		}
		
		//상대경로(웹경로) -> 절대경로(저장경로)
		String webPath = "/images/";
		String absPath = application.getRealPath(webPath);
		
		String p_filename="no_file";
		if(!photo.isEmpty()) { //업로드파일이 있으면
			p_filename = photo.getOriginalFilename();
			//저장할 파일정보
			File f =new File(absPath,p_filename);
			if(f.exists()) { //같은 이름의 파일이 존재하면
				long tm =System.currentTimeMillis();
				p_filename=String.format("%d_%s", tm,p_filename);
						 
				f= new File(absPath,p_filename);
			}
			//위에서 경로와 파일명을 정의한다음에 아래에 MultipartFile에 임시로 저장되어있는 파일을
			// 내가 설정한 절대경로로 파일을 복사해서 옮겨준다.
			//임시파일 -> f로 지정된 파일로 복사
			photo.transferTo(f);
		}
		
		//현재 업로드된 파일명 vo에 넣는다.
		vo.setP_filename(p_filename);
		
		//아이피넣기
		vo.setP_ip(request.getRemoteAddr());
		
		//로그인한 유저정보 넣기
		vo.setMem_idx(user.getMem_idx());
		
		//\n 엔터를 를 <br>로 바꾸기
		String p_content=vo.getP_content().replaceAll("\n", "<br>");
		vo.setP_content(p_content);
		
		int res = photo_dao.insert(vo);
		
		return"redirect:list.do";
	}
	
	
	//   /photo/photo_one.do?p_idx=5
	@RequestMapping("/photo/photo_one.do")
	@ResponseBody
	public PhotoVo photo_one(int p_idx) {
		System.out.println("ajax를 통해서 데이터 1개 가져오기");
		return photo_dao.selecOne(p_idx);
	}
	
	//수정폼
	// /photo/photo_modify_form.do?p_idx=10
	@RequestMapping("/photo/modify_form.do")
	public String photo_modify_form(int p_idx,Model model) {
		PhotoVo vo = photo_dao.selecOne(p_idx);
		//내용을 <br>이기때문에 \n으로 바꿔야한다.
		vo.setP_content(vo.getP_content().replaceAll("<br>", "\n"));
		// request binding
		model.addAttribute("vo", vo);
		return"photo/photo_modify_form";
	}
	
	
	//	/photo/photo_upload.do?
	@RequestMapping("/photo/photo_upload.do")
	@ResponseBody
	public Map<String,String> photo_upload(int p_idx,@RequestParam MultipartFile photo) throws Exception{
		//리턴값 넣을곳
		Map<String,String> map =new HashMap<String,String>();
		
		map.put("result", "fail");
		
		if(!photo.isEmpty()) { //업로드 파일 있으면
			
		
			// Web 경로 -> 절대경로
			String absPath=application.getRealPath("/images/");
			System.out.println(absPath);
			//수정할 포토 객체 정보
			PhotoVo vo = photo_dao.selecOne(p_idx);
			System.out.println(vo.getP_filename());
			//기존파일 삭제
			File delFile=new File(absPath,vo.getP_filename());
			delFile.delete();
			
			//새파일 업로드처리
			String p_filename = photo.getOriginalFilename(); // 받아온 정보에서 파일 순수한이름
			File newFile = new File(absPath,p_filename);
			
			//아주 작은 확률로 동시에 들어올 경우를 방지하기 위해선 와일반복문을 써도된다.
			if(newFile.exists()) {  //동일 파일명을 갖는 파일이 존재하냐
				long tm =System.currentTimeMillis();
				p_filename = String.format("%d_%s", tm,p_filename);
				
				newFile = new File(absPath,p_filename);
				
			}
			
			photo.transferTo(newFile);
			
			//새로운 파일명을 vo에 넣는다.
			vo.setP_filename(p_filename);
			
			int res = photo_dao.update_filename(vo);
			
			//결과반환
			map.put("result", "success");
			map.put("p_filename", p_filename);
			
			return map;
			
		}//

		
		return map;
	}
	
}
