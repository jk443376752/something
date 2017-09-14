package com.buy.tsg.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy.tsg.controller.AuthApplyMessageController;
import com.buy.tsg.mapper.AuthApplyMessageMapper;
import com.buy.tsg.query.AuthApplyMessageQueryParameter;
import com.buy.tsg.service.AuthApplyMessageService;
import com.buy.tsg.utils.HttpSessionUtil;
import com.buy.tsg.utils.PageList;

@Service
public class AuthApplyMessageServiceImpl implements AuthApplyMessageService {
	private Logger log = LoggerFactory.getLogger(AuthApplyMessageServiceImpl.class);
	@Autowired
	private AuthApplyMessageMapper authApplyMessageMapper;

	@Override
	public PageList<Map<String,Object>> getAll(AuthApplyMessageQueryParameter authApplyMessageQueryParameter) {
		
		//1.拿到当前页的数据
		List<Map<String, Object>> mapList = authApplyMessageMapper.getAuthApplyMessageAll(authApplyMessageQueryParameter);
		//2.查询一共有多少条数据 , 分页的时候要用到
		Integer totalCount = authApplyMessageMapper.getTotalCount(authApplyMessageQueryParameter);
		//3.将当前第几页 ,每页的长度 ,总共的数据封装到PageList里面
		PageList<Map<String ,Object>> pageList = new PageList<>(authApplyMessageQueryParameter.getCurrentPage(),
				authApplyMessageQueryParameter.getPageSize(),totalCount);
		//4.将当前页的数据封装到pageList的data里面取
		pageList.setData(mapList);
		//5.讲取得的数据放到session里面去
		log.debug("==================="+pageList);
		HttpSessionUtil.getSession().setAttribute("authApplyMessagePageList",pageList);
		return pageList;
	}

}
