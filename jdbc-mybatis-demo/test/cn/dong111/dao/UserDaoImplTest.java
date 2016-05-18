package cn.dong111.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.dong111.pojo.User;

public class UserDaoImplTest {
	
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		//mybatis 配置文件名称
		String resource = "SqlMapConfig.xml";
		InputStream inputStream =  Resources.getResourceAsStream(resource);
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	@Test
	public void testFindUserById() {
		
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		
		User user = userDao.findUserById(1);
		
		System.out.println(user);
		
	}
	
	
	
	@Test
	public void testFindUserByName() {
		UserDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		
		List<User> users = userDao.findUserByUserName("小明");
		
		System.out.println(users.size());
	}
	
	
	@Test
	public void testInsertUser() {
		
	}
	
	
	
	@Test
	public void testDeleteUser() {
		
	}

}
