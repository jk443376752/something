package com.buy.tsg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buy.tsg.entity.Patient;
import com.buy.tsg.mapper.PatientMapper;
import com.buy.tsg.query.BaseQueryParemeter;
import com.buy.tsg.query.PatientQueryParameter;
import com.buy.tsg.service.PatientService;
import com.buy.tsg.utils.PageList;
@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientMapper patientMapper;
	
	@Override
	public PageList<Map<String, Object>> getPatientTableList (PatientQueryParameter patientQueryParameter) {
		 //拿到分页后的数据
		 List<Map<String, Object>> mapList = patientMapper.queryList(patientQueryParameter);
		 //查询一共有多少条数据
		 Integer totalCount = patientMapper.totalCount(patientQueryParameter);
		 
		 PageList<Map<String, Object>> pageList = new PageList<Map<String, Object>>(patientQueryParameter.getCurrentPage(), patientQueryParameter.getPageSize(),totalCount);

		 pageList.setData(mapList);
		 
		return pageList;
	}

	@Override
	public void deleteTableList(String paId) {
		
		Patient patient = patientMapper.selectByPrimaryKey(Integer.valueOf(paId));
		if(patient!=null){
			patientMapper.deleteTableList(Integer.valueOf(paId));
		}
		
	}
}
