package cn.dong111.mapper;

import java.util.List;

import cn.dong111.pojo.User;
import cn.dong111.pojo.UserCustom;
import cn.dong111.pojo.UserQueryVo;

/**
 * 使用 mapper 代理开发
 * @author chendong
 *
 */
public interface UserMapper {
	//用户综合信息查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	//用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	//根据id查询用户信息
	public User findUserById(int id) throws Exception; 
	
	//根据id查询用户信息，使用resultmap输出
	public User findUserByResultMap(int id) throws Exception;
	
	//根据用户名列表查询用户列表
	public List<User> findUserByName(String name) throws Exception;
	
	//插入用户
	public void insertUser(User user) throws Exception;
	
	//删除用户
	public void deleteUser(int id) throws Exception;
	
	//更新用户
	public void updateUser(User user);
	
	

}
