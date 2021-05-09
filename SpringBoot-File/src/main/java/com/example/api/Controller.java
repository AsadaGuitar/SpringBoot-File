package com.example.api;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.FileData;

@org.springframework.stereotype.Controller
@RequestMapping(path="/")
public class Controller {

	@GetMapping
	public String home(Model model) {
		model.addAttribute(new FileData());
		return "home";
	}
	
	@PostMapping(path="/upload")
	public String viewFile(@Validated FileData fileData, 
			BindingResult result, Model model){
		if(result.hasErrors())
			return "home";
		model.addAttribute("fileName", fileData.getUploadFile().getOriginalFilename());
		return "viewFile";
	}
}
