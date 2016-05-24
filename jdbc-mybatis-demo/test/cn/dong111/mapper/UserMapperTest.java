package cn.dong111.mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.dong111.pojo.User;
import cn.dong111.pojo.UserCustom;
import cn.dong111.pojo.UserQueryVo;

public class UserMapperTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws IOException {
		// 创建sqlSessionFactory

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}

	@Test
	public void testFindUserList() throws Exception {
	
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建查询pojo 包装类
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("男");
		userCustom.setUsername("小明");
		
		userQueryVo.setUserCustom(userCustom);
		
		List<UserCustom> userList =  userMapper.findUserList(userQueryVo);
		
		System.out.println(userList.size());
		
	}

	@Test
	public void testFindUserCount() {
		
	}

	@Test
	public void testFindUserById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserByResultMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindUserByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

}
