package org.cwf.service.impl;

import javax.annotation.Resource;

import org.cwf.mapper.AdminMapper;
import org.cwf.mapper.DocumentDeployMapper;
import org.cwf.mapper.RegisScoreMapper;
import org.cwf.model.Admin;
import org.cwf.service.AdminService;
import org.cwf.service.DocumentDeployService;
import org.cwf.service.RegisScoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("documentDeployService")
public class DocumentDeployServiceImpl implements DocumentDeployService{
	
	@Resource
	private DocumentDeployMapper documentDeployMapper;

	@Override
	public int selectDocumentDeploy() {
		// TODO Auto-generated method stub
		return documentDeployMapper.selectDocumentDeploy();
	}


	@Transactional
	@Override
	public Integer updateDocumentDeploy(int id, int score) {
		// TODO Auto-generated method stub
		documentDeployMapper.deleteDocumentDeploy();
		return documentDeployMapper.updateDocumentDeploy(id, score);
	}



}
