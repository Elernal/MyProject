package org.cwf.service.impl;

import javax.annotation.Resource;

import org.cwf.mapper.UserMapper;
import org.cwf.model.JsonUser;
import org.cwf.model.User;
import org.cwf.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	
	/**
	 * 将方法的运行结果进行缓存：以后再要相同的数据，就直接从缓存中获取
	 * 
	 * 几个属性：
	 * 		cacheNames/value:指定缓存的名字：
	 * 		key：缓存数据使用的key：可以用它来指定。默认是使用方法参数的值 1-方法的返回值
	 * 			编写SqEL：#id;参数id的值 #a0 #p0
	 */
	@Cacheable(cacheNames = {"emp"})
	@Override
	public PageInfo<User> getUserData(JsonUser jsonUser) {
		// TODO Auto-generated method stub
		PageHelper.startPage(jsonUser.getPage(),jsonUser.getLimit());
		PageInfo<User> pageInfoUserList = new PageInfo<User>(userMapper.getUserData(jsonUser));
		return pageInfoUserList;
	}

	@Override
	public Integer updateUserBearByPrimaryKey(int id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updateUserBearByPrimaryKey(id);
	}

	@Override
	public Integer updateUserStartByPrimaryKey(int id) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updateUserStartByPrimaryKey(id);
	}
	
}
