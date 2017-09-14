<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>正在申请中</title>

		<link href="/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="/resources/assets/css/font-awesome.min.css" />
		
		<!-- page specific plugin styles -->
		
		<!-- fonts -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
		
		<!-- ace styles -->
		<link rel="stylesheet" href="/resources/assets/css/ace.min.css" />
		<link rel="stylesheet" href="/resources/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="/resources/assets/css/ace-skins.min.css" />
		
		<!-- 让bootstrap表单居中显示 -->
		<style type="text/css">
			            .table th, .table td { 
						text-align: center; 
						height:38px;
						}
		</style>
		<script src="/resources/assets/js/ace-extra.min.js"></script>
</head>

<body>

				<div class="page-content">
						<!-- 表单开始 -->
							<div class="row">
								<div class="col-xs-12">
									<div class="table-header">
										正在申请
									</div>
				
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover">
											<thead align="center">
												<tr>
													<th>姓名</th>
													<th>性别</th>
													<th class="hidden-480">电话</th>
													<th>单位</th>
													<th class="hidden-480">提交申请人姓名</th>
													<th class="hidden-480">提交申请人电话</th>
													<th class="hidden-480">提交申请人单位</th>
													<th class="hidden-480">提交申请时间</th>
													<th>状态</th>
												</tr>
											</thead>
				
									 <tbody id="myPaTbody">
											<c:forEach items="${authApplyMessagePageList.data}" var="item" varStatus="status">  
											  <tr >  
											    <td>${item.apply_name}</td>  
											    <td>${item.apply_sex}</td>  
											    <td>${item.apply_telphne}</td>  
											    <td>${item.apply_department}</td>  
											    <td>${item.submit_name}</td>  
											    <td>${item.submit_telphone}</td>  
											    <td>${item.submit_department}</td>  
											    <td>${item.submit_time}</td>  
											    <td>${item.status}</td>  
											  </tr>  
											</c:forEach>  
										</tbody>
											
										</table>
									</div>
									
									<!-- 分页  -->
									
									<div class="modal-footer no-margin-top">
									
												<ul class="pagination" style="float: left; font-size:16px">
													总共    <i id="iTotalPage">${authApplyMessagePageList.totalCount}</i> 条数据
													/ 共    <i id="iLastPage">${authApplyMessagePageList.lastPage}</i> 页 /当前第 <i id="icurrentPage">${authApplyMessagePageList.currentPage}</i> 页 
												</ul>
												
												<ul class="pagination" id="pageMessage" style="float: rigth; font-size:14px">
													<li id="firstLi">
														<a href="javascript:goPage('1')">
															首页
														</a>
													</li>
													
													<li id="preLi">
														<a href="javascript:goPage(${authApplyMessagePageList.upPage})">
															<<<
														</a>
													</li>
													
													
													<li id="nextLi">
														<a href="javascript:goPage(${authApplyMessagePageList.nextPage})">
															>>>
														</a>
													</li>
													
													<li id="lastLi">
														<a href="javascript:goPage(${authApplyMessagePageList.lastPage})">
															末页
														</a>
													</li>
												</ul>
										</div>
									<!-- 分页结束  -->
								</div>
							</div>
						<!-- 表单结束 -->
					</div><!-- /.page-content -->
					
					
		<script src="/resources/jquery/jquery-1.11.1.js"></script>
		<script src="/resources/assets/js/bootstrap.min.js"></script>
		<script src="/resources/assets/js/typeahead-bs2.min.js"></script>
		
		<!-- ace scripts -->
		<!-- 必须引入 ,否则导航栏不能用 -->
		<script src="/resources/assets/js/ace-elements.min.js"></script>
		<script src="/resources/assets/js/ace.min.js"></script>
		<script src="/resources/layer/layer.js"></script> 
		<script type="text/javascript">
			$(function() {
			  //禁用分页条
				var currentPage = ${authApplyMessagePageList.currentPage};
				if(currentPage==1){
					$("#firstLi").attr("class","disabled");
					$("#preLi").attr("class","disabled");
					$("#nextLi").attr("class","");
					$("#lastLi").attr("class","");
				}
				var lastPage = ${authApplyMessagePageList.lastPage};
				if(currentPage==lastPage){
					$("#nextLi").attr("class","disabled");
					$("#lastLi").attr("class","disabled");
					$("#firstLi").attr("class","");
					$("#preLi").attr("class","");
				}
			});
		</script>
		
		<script type="text/javascript">
		
			function goPage(parameter){
				if(parameter==1&&$("#firstLi").attr("class")=="disabled"){
					return;
				}else if(parameter==$("#iLastPage").text()&& $("#lastLi").attr("class")=="disabled"){
					return;
				}else{
					//重新去创建session
					$.post("/AuthApplyMessage/getAll",{currentPage:parameter},function(){
						self.location.reload();
					})
				}

			}
		</script>
</body>
</html>