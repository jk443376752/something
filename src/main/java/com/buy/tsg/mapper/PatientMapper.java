package com.buy.tsg.mapper;

import java.util.List;
import java.util.Map;

import com.buy.tsg.entity.Patient;
import com.buy.tsg.query.PatientQueryParameter;

public interface PatientMapper {
	
    int deleteByPrimaryKey(Integer paId);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(Integer paId);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
    
    //以上是mybatis自动生成
    List<Map<String , Object>> queryList(PatientQueryParameter patientQueryParameter);

	Integer totalCount(PatientQueryParameter patientQueryParameter);

	void deleteTableList(Integer paId);
    
}