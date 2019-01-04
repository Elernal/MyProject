package org.cwf.controller;

import javax.annotation.Resource;

import org.cwf.service.DocumentDeployService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DocumentDeployController {

	@Resource
	private DocumentDeployService documentDeployService;
	
	@PostMapping("/getDocumentDeploy")
	@ResponseBody
	public int getDocumentDeploy() {
		return documentDeployService.selectDocumentDeploy();
	}
	
	@PostMapping("/setDocumentDeploy")
	@ResponseBody
	public int setDocumentDeploy(int id,int score) {
		return documentDeployService.updateDocumentDeploy(id, score);
	}
}
