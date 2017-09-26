package com.buy.tsg.service;

import java.util.List;
import java.util.Map;

import com.buy.tsg.entity.AuthApplyMessage;
import com.buy.tsg.query.AuthApplyMessageQueryParameter;
import com.buy.tsg.utils.PageList;
import com.buy.tsg.utils.ResponseInfo;

public interface AuthApplyMessageService{
	
	PageList<Map<String,Object>> getAll(AuthApplyMessageQueryParameter authApplyMessageQueryParameter);
	
	ResponseInfo deleteById(Integer id);
	
    List<String> selectSubmitTelphoneBysubmitName(String submitName);
    
    void updateByPrimaryKey(AuthApplyMessage authApplyMessage);

}
