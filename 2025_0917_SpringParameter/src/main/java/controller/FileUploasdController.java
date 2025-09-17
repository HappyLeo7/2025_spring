package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploasdController {
	
	//자동으로 연결 : Auto Injection
	@Autowired 
	ServletContext application;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	
	
	@RequestMapping("/upload1.do")
	public  String upload(String title , @RequestParam("photo") MultipartFile photo
							,Model model) throws Exception {
									   //MultipartFile photo => 업로드된 임시파일 정보 요청 
		
		String webPath = "/images/";
		// 절대 경로가 필요하다. 어플리케이션
		String absPath=application.getRealPath(webPath);
		//System.out.println(absPath);
		
		//임시파일 -> 원하는 위치로 복사
		String filename="no_file";
		//if(photo.isEmpty()==false) {
		if(!photo.isEmpty()) {
			filename = photo.getOriginalFilename();
			File f = new File(absPath, filename);
			//파일 존재유무 체크
			if(f.exists()) {
				//동일 파일명이 존재하면 이름을 변경해준다. : 시간_원본파일명 으로 변경
				long tm = System.currentTimeMillis();
				filename = String.format("%d_%s", tm,filename);
				f=new File(absPath,filename);
			}
			//임시 파일을 복제 -> 지정위치로
			photo.transferTo(f);
		}
		
		model.addAttribute("filename",filename);
		model.addAttribute("title",title);
		return"upload_result1";
	}
	
	
	@RequestMapping("/upload2.do")
	public String upload2(String title 
			,@RequestParam("photo") MultipartFile[] photo_array
			,Model model) throws Exception {
		String webPath= "/images/";
		String absPath=application.getRealPath(webPath);
		String filename1 = "no_file";
		String filename2 = "no_file";
		
		for(int i=0; i<photo_array.length;i++) {
			MultipartFile photo = photo_array[i];
			if(!photo.isEmpty()) {
				String filename=photo.getOriginalFilename();
				File f=new File(absPath,filename);
				//파일 존재유무 체크
				if(f.exists()) {
					//동일 파일명이 존재하면 이름을 변경해준다. : 시간_원본파일명 으로 변경
					long tm = System.currentTimeMillis();
					filename = String.format("%d_%s", tm,filename);
					f=new File(absPath,filename);
				}
				//임시 파일을 복제 -> 지정위치로
				photo.transferTo(f);
				
				if(i==0) {
					filename1=filename;
				}else if(i==1) {
					filename2=filename;
				}
			}
		}//end : for
		
		model.addAttribute("title", title);
		model.addAttribute("filename1",filename1);
		model.addAttribute("filename2",filename2);
		
		return"upload_result2";
	}
	
}
