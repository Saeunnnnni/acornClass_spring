package com.gura.spring03.file.dto;

import org.springframework.web.multipart.MultipartFile;

public class fileDto {
	
	//필드
	private String title;
	//<input type ="file" name="myFile"> 전송되는 파일의 파라미터명과 dto의 필드명을 일치 시켜야한다.
	private MultipartFile myFile;
	
	//디폴트 생성자
	public fileDto() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getMyFile() {
		return myFile;
	}

	public void setMyFile(MultipartFile myFile) {
		this.myFile = myFile;
	}

	public fileDto(String title, MultipartFile myFile) {
		super();
		this.title = title;
		this.myFile = myFile;
	}
	
}
