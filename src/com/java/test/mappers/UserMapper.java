package com.java.test.mappers;

import java.util.List;

import com.java.test.beans.User;

public interface UserMapper {
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int add(User user);
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */	
	public int update(User user);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * 根据id查询该id所属用户
	 * @param id
	 * @return
	 */
	public User selectOne(int id);
	/**
	 * 查询所有用户
	 * @return 用户组列表
	 */
	public List<User> selectList();
	/**
	 * 根据ID查询该用户的一条属性
	 * @param id
	 * @return 该用户的一条属性
	 */
	public Object selectById(int id);
}
