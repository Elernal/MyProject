package org.cwf.service;

import org.cwf.model.Admin;

public interface AdminService {
	
	//登陆
	Admin selectByLogin(Admin admin);
}
