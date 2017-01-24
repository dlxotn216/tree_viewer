package com.taesu.test.spec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpecController {

	@Autowired
	private SpecService specService;
	
	@ResponseBody
	@RequestMapping( value="/spec/tree", method=RequestMethod.GET)
	public Object readSpecTree(){
		
		return specService.readAllSpecList();
	}
}
