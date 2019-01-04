package org.cwf.service;

import org.cwf.model.JsonUser;
import org.cwf.model.User;
import org.springframework.cache.annotation.Cacheable;

import com.github.pagehelper.PageInfo;

public interface UserService {
	
	PageInfo<User> getUserData(JsonUser jsonUser);
	
	//禁用
	Integer updateUserBearByPrimaryKey(int id) throws Exception;
	
	//启用
	Integer updateUserStartByPrimaryKey(int id) throws Exception;
}
