package cn.dong111.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.dong111.pojo.User;


//Dao 接口实现类
public class UserDaoImpl implements UserDao {
	//需要向dao里面注入sqlSessionFactory
	//这里通过构造函数创建
	private SqlSessionFactory sqlSessionFactory;
	
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory ) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	@Override
	public User findUserById(int id) {
		//获取session会话
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		
		User user = sqlSession.selectOne("test.findUserById",1);
		
		sqlSession.close();
		
		return user;
	}


	@Override
	public List<User> findUserByUserName(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> users = sqlSession.selectList("test.findUserByUserName",name);
		
		sqlSession.close();
		
		return users;
	}


	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.insert("test.insertUser",user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void delUserById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("test.deleteUser",id);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	
	


}
