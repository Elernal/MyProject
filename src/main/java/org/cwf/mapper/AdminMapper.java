package org.cwf.mapper;

import org.cwf.model.Admin;

public interface AdminMapper {
	
	//登陆
	Admin selectByLogin(Admin admin);
	
}
