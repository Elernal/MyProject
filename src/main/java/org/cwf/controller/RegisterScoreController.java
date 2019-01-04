package org.cwf.controller;

import javax.annotation.Resource;

import org.cwf.service.RegisScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterScoreController {

	@Resource
	private RegisScoreService regisScoreService;
	
	@PostMapping("/regisScore")
	@ResponseBody
	public int regisScore(int val) throws Exception {
		Integer a = regisScoreService.updateScore(val);
		if (a<1) {
			throw new Exception();
		}
		return 1;
	}
	
}
