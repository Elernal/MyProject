package org.cwf.mapper;

import java.util.List;

import org.cwf.model.JsonUser;
import org.cwf.model.User;

public interface UserMapper {
	
	List<User> getUserData(JsonUser jsonUser);
	
	//禁用
	Integer updateUserBearByPrimaryKey(int id) throws Exception;
	
	//启用
	Integer updateUserStartByPrimaryKey(int id) throws Exception;
}
