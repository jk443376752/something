package com.buy.tsg.mapper;

import java.util.List;

import com.buy.tsg.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    //以上为自动生成
    
	List<String> selectRoleByUsername(String currentUsername);

}