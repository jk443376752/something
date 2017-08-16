package com.buy.tsg.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;


public class ResponseInfo {
	

	
	/**
	 * <p>
	 * Description:[1表示正常,0表示异常 ]
	 * </p>
	 */
	private Integer is_abnormal;
	
	/**
	 * <p>
	 * Description:返回的消息
	 * </p>
	 */
	private String remark;
	
	/**
	 * 传入分页数据
	 */
	
	private PageList pageList;


	private Map<String, Object> dataMap = new HashMap<String, Object>();
	
	/**
	 *  mybatis ,返回Map , 传入List<Map<String ,Object>>类型的数据
	 */
	private List<Map<String, Object>> dataMapList  = new ArrayList<Map<String, Object>>() ;
	
	
	public ResponseInfo() {
		this.remark = remark;
		this.is_abnormal = is_abnormal;
	}

	public PageList getPageList() {
		return pageList;
	}


	public void setPageList(PageList pageList) {
		this.pageList = pageList;
	}




	public Integer getIs_abnormal() {
		return is_abnormal;
	}

	public void setIs_abnormal(Integer is_abnormal) {
		this.is_abnormal = is_abnormal;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public void setDataMapList(List<Map<String, Object>> dataMapList) {
		this.dataMapList = dataMapList;
	}

	public List<Map<String, Object>> getDataMapList() {
		return dataMapList;
	}

	public String toJsonString(ResponseInfo responseInfo) {
	  JSONObject jsonObject = new JSONObject();
    try {
      jsonObject.put("is_abnormal", responseInfo.getIs_abnormal());
      jsonObject.put("remark", responseInfo.getRemark());
      jsonObject.put("dataMapList", responseInfo.getDataMapList());
      jsonObject.put("dataMap", responseInfo.getDataMap());
      jsonObject.put("pageList", responseInfo.getPageList());
    } catch (JSONException e) {
      jsonObject = null;
      e.printStackTrace();
    }
		return jsonObject.toString();
	}
}
