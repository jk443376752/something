package com.buy.tsg.service;

import java.util.Map;

import com.buy.tsg.query.PatientQueryParameter;
import com.buy.tsg.utils.PageList;

public interface PatientService {
	
	PageList<Map<String , Object>> getPatientTableList(PatientQueryParameter patientQueryParameter);

	void deleteTableList(String paId);

}
