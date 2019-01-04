package org.cwf.service.impl;

import javax.annotation.Resource;

import org.cwf.mapper.AdminMapper;
import org.cwf.mapper.RegisScoreMapper;
import org.cwf.model.Admin;
import org.cwf.service.AdminService;
import org.cwf.service.RegisScoreService;
import org.springframework.stereotype.Service;

@Service("regisScoreService")
public class RegisScoreServiceImpl implements RegisScoreService{

	@Resource
	private RegisScoreMapper regisScoreMapper;
	
	@Override
	public Integer updateScore(int val) {
		// TODO Auto-generated method stub
		return regisScoreMapper.updateScore(val);
	}


}
