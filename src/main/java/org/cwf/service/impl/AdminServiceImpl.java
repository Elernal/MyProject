package org.cwf.service.impl;

import javax.annotation.Resource;

import org.cwf.mapper.AdminMapper;
import org.cwf.model.Admin;
import org.cwf.service.AdminService;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Resource
	private AdminMapper adminMapper;
	
	@Override
	public Admin selectByLogin(Admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.selectByLogin(admin);
	}

}
