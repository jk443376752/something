package com.buy.tsg.service;

import java.util.Map;

import com.buy.tsg.query.AuthApplyMessageQueryParameter;
import com.buy.tsg.utils.PageList;
import com.buy.tsg.utils.ResponseInfo;

public interface AuthApplyMessageService{
	
	PageList<Map<String,Object>> getAll(AuthApplyMessageQueryParameter authApplyMessageQueryParameter);
	
	ResponseInfo deleteById(Integer id);

}
