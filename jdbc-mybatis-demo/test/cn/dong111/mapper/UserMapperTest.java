package cn.dong111.mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
		userCustom.setSex("1");
		userCustom.setUsername("小明");
		
		//传入多个id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(10);
		ids.add(16);
		//将ids通过userQueryVo传入statement中
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		
		List<UserCustom> userList =  userMapper.findUserList(userQueryVo);
		
		System.out.println(userList.size());
		
	}

	@Test
	public void testFindUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建查询pojo 包装类
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("小明");
		
		//传入多个id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(10);
		ids.add(16);
		//将ids通过userQueryVo传入statement中
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		
		
		int count = userMapper.findUserCount(userQueryVo);
		System.out.println(count);
	}

	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user =  userMapper.findUserById(1);
		System.out.println(user);
	}

	@Test
	public void testFindUserByResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserByResultMap(1);
		System.out.println(user);
		
	}

	/**
	 * sql注入测试
	 * @throws Exception
	 */
	@Test
	public void testFindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//这个就是典型的sql注入测试用例  这样的参数需要我们在代码中手工进行处理来防止注入
//		List<User> users = userMapper.findUserByName("小明' or 1=1 or '");
		List<User> users = userMapper.findUserByName("小明");
		
		System.out.println(users.size());
		
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
