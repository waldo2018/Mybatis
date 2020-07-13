package com.java.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.java.test.beans.User;
import com.java.test.mappers.UserMapper;
import com.java.test.mybatis.SqlSessionFactoryUtils;

public class TestUser {
	
	private SqlSession sqlSession = null;
	private UserMapper userMapper = null;
	
	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtils.openSqlSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
	}

	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	@Test
	public void testAdd() {
		User user = new User(3,"lisi", 0, 15);
		int result = userMapper.add(user);
		sqlSession.commit(); 
		if (result > 0 ) {
			System.out.println("插入成功");
		}
	}
	
	@Test
	public void testUpdate() {
		User user = new User(2, "zhangsan", 1, 13);
		int result = userMapper.update(user);
		sqlSession.commit();
		if (result > 0 ) {
			System.out.println("修改成功");
		}
	}
	@Test
	public void testDel() {
		userMapper.delete(3);
		sqlSession.commit();
	}
	
	@Test
	public void testSelectOne() {
		User user = userMapper.selectOne(2);
		System.out.println(user);
	}
	
	@Test
	public void testSelectList() {
		List<User> userList = userMapper.selectList();
		System.out.println(userList);
	}
	
	@Test
	public void testSelectById() {
		Object o = userMapper.selectById(2);
		System.out.println((String)o);
	}
}
