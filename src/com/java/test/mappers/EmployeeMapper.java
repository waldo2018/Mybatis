package com.java.test.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.java.test.beans.Employee;

public interface EmployeeMapper {
	
	@Select("select id, last_name lastName, gender, email  from tbl_employee where id = #{id}")
	public Employee get(@Param("id") int id);
}
