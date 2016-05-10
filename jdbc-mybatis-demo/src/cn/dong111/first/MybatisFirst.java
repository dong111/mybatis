package cn.dong111.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.dong111.pojo.User;

/**
 * mybatis 第一个入门程序
 * @author chendong
 *
 */
public class MybatisFirst {

	//根据id查询用户信息
	@Test
	public void findUserById() throws Exception {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过sqlSession操作数据库
		//第一个参数:映射文件中statement的id，等同于namespace+"."+statement的id
		//第二个参数:指定和映射文件匹配的parameterType的类型参数
		//sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
		//selectOne查询出来一条结果
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user.getUsername());
		System.out.println("-------------------------");
		
		//释放资源
		sqlSession.close();
		
	}
	
	
	
	
	//根据用户名称模糊查询用户信息
	@Test
	public void findUserByUserName() throws Exception {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userList = sqlSession.selectList("test.findUserByUserName", "小明");

		System.out.println("list size :"+userList.size());
		
		//释放资源
		sqlSession.close();
		
	}
	
	
	
	//插入用户信息
	@Test
	public void insertUserTest() throws Exception {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//构造插入用户对象
		User user = new User();
		user.setAddress("湖南长沙");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setUsername("cd");
		
		sqlSession.insert("test.inserUser",user);
		
		
		sqlSession.commit();
		
		//获取用户自增长的主键id
		System.out.println("gain userid :"+user.getId());
		//释放资源
		sqlSession.close();
		
	}
	
	
	
	
	
	//删除用户信息
	@Test
	public void updateUserTest() throws Exception {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//构造插入用户对象
		User user = new User();
		user.setId(32);
		user.setAddress("湖南长沙");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setUsername("cdong");
		
		sqlSession.update("test.updateUser",user);
		
		
		sqlSession.commit();
	
		//释放资源
		sqlSession.close();
		
	}
	
	

	
	
	//删除用户信息
	@Test
	public void deleteUserTest() throws Exception {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis配置信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.delUserById",31);
		
		
		sqlSession.commit();
	
		//释放资源
		sqlSession.close();
		
	}
	
	
	
	
	
}
