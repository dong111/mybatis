package cn.dong111.dao;

import java.util.List;

import cn.dong111.pojo.User;

/**
 * 
 * <p>Title: UserDao</p>
 * <p>Description: dao接口，用户管理</p>
 * <p>Company: www.dong111.cn</p> 
 * @author	陈栋
 * @date	2016-5-13上午8:23
 * @version 1.0
 */
public interface UserDao {
	//根据id查询用户信息
	public User findUserById(int id);
	
	//根据用户名列查询用户列表
	public List<User> findUserByUserName(String name);
	
	//添加用户信息
	public void insertUser (User user);
		
	//删除用户信息
	public void delUserById (int id);

}
