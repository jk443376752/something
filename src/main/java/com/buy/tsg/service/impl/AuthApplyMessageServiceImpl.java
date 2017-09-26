package com.buy.tsg.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy.tsg.controller.AuthApplyMessageController;
import com.buy.tsg.entity.AuthApplyMessage;
import com.buy.tsg.mapper.AuthApplyMessageMapper;
import com.buy.tsg.query.AuthApplyMessageQueryParameter;
import com.buy.tsg.service.AuthApplyMessageService;
import com.buy.tsg.utils.HttpSessionUtil;
import com.buy.tsg.utils.PageList;
import com.buy.tsg.utils.ResponseInfo;

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
		//5.讲取得的数据放到session里面去 ,可以选择这个做 , 但是sessio太多了会对服务器造成极大的压力 , 所有不建议使用session
		//HttpSessionUtil.getSession().setAttribute("authApplyMessagePageList",pageList);
		return pageList;
	}

	@Override
	public ResponseInfo deleteById(Integer id) {
		ResponseInfo rfi = new ResponseInfo();
		AuthApplyMessage selectByPrimaryKey = null;
		try {
			selectByPrimaryKey = authApplyMessageMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			rfi.setIs_abnormal(0);
			rfi.setRemark("数据异常 ,删除失败!");
		}
		if(selectByPrimaryKey==null){
			rfi.setIs_abnormal(0);
			rfi.setRemark("不存在的数据,删除失败!");
		}
		try {
			authApplyMessageMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			rfi.setIs_abnormal(0);
			rfi.setRemark("数据异常 ,删除失败!");
		}
		rfi.setIs_abnormal(1);
		rfi.setRemark("已成功删除该记录");
		return rfi;
	}

	@Override
	public List<String> selectSubmitTelphoneBysubmitName(String submitName) {
		// TODO Auto-generated method stub
		return authApplyMessageMapper.selectSubmitTelphoneBysubmitName(submitName);
	}

	@Override
	public void updateByPrimaryKey(AuthApplyMessage authApplyMessage) {
		authApplyMessageMapper.updateByPrimaryKey(authApplyMessage);
		
	}

}
