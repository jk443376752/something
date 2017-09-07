package com.buy.tsg.mapper;

import java.util.List;

import com.buy.tsg.entity.Auth;

public interface AuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Auth record);

    int insertSelective(Auth record);

    Auth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Auth record);

    int updateByPrimaryKey(Auth record);
    
    /**
     * 以上为自动生成
     * @param username
     * @return List<Auth>
     */
    List<String> selectAuthByUsername(String username);
    
	List<String> selectAuthByRoleNames(List<String> roleNames);

}