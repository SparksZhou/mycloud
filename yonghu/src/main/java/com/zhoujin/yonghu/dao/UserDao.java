package com.zhoujin.yonghu.dao;

import com.zhoujin.commons.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao {
	
	public User getUserById(@Param("id") long id);

}
