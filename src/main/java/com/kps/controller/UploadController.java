package com.kps.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@PostMapping("/file/upload")
	public String upload(@RequestParam("file") List<MultipartFile> files) throws IOException{
		
		String uploadPath = "/opt/images/";
		File path = new File(uploadPath);
		if(!path.exists())
			path.mkdirs();
		
		for(MultipartFile file: files){
		//generate random file name
			String fileName = file.getOriginalFilename();
			fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
			System.out.println(fileName);
			
			//upload file to project path
			Files.copy(file.getInputStream(), Paths.get(uploadPath, fileName));
		}
		
		return "fileupload";
	}
	
	
	/*@PostMapping("/file/upload")
	public String upload(@RequestParam("file") MultipartFile file) throws IOException{
		System.out.println(file.getOriginalFilename());
		
		String uploadPath = "/opt/images/";
		File path = new File(uploadPath);
		if(!path.exists())
			path.mkdirs();
		
		//generate random file name
		String fileName = file.getOriginalFilename();
		fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.println(fileName);
		
		//upload file to project path
		Files.copy(file.getInputStream(), Paths.get(uploadPath, fileName));
		
		return "fileupload";
	}*/
	
	
/*	@PostMapping("/file/upload")
	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{
		System.out.println(file.getOriginalFilename());
		
		String uploadPath = request.getServletContext().getRealPath("resources/images/");
		System.out.println(uploadPath);
		
		//upload file to project path
		Files.copy(file.getInputStream(), Paths.get(uploadPath, file.getOriginalFilename()));
		
		return "fileupload";
	}*/
}
