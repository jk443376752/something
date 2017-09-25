package com.buy.tsg.mapper;

import java.util.List;
import java.util.Map;

import com.buy.tsg.entity.AuthApplyMessage;
import com.buy.tsg.query.AuthApplyMessageQueryParameter;

public interface AuthApplyMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthApplyMessage record);

    int insertSelective(AuthApplyMessage record);

    AuthApplyMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthApplyMessage record);

    int updateByPrimaryKey(AuthApplyMessage record);
    
    //以上为Mybatis3自动生成
    
    List<Map<String ,Object>> getAuthApplyMessageAll(AuthApplyMessageQueryParameter authApplyMessageQueryParameter);
    
    Integer getTotalCount (AuthApplyMessageQueryParameter authApplyMessageQueryParameter);
    
    List<String> selectSubmitTelphoneBysubmitName(String submitName);
    
    AuthApplyMessage selectAuthApplyMessageByApplyMap(Map<String,Object> parameterMap);
    
    AuthApplyMessage selectAuthApplyMessageByApplyTelphone(String submitTelphone);

}