<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		
		<link rel="stylesheet" href="/resources/css/bootstrap-datepicker3.css">
		
		<!-- 让bootstrap表单居中显示 -->
		<style type="text/css">
			            .table th, .table td { 
						text-align: center; 
						height:38px;
						}
		</style>
		<script src="/resources/assets/js/ace-extra.min.js"></script>
		<script src="/resources/layer/layer.js"></script>
</head>

		<body>
				<div class="page-content">
						<!-- 表单开始 -->
							<div class="row">
								<div class="col-xs-12">
								
								
									<!-- 搜索功能 -->
									<div class="widget-header widget-header-small">
										<fieldset>
											用户名&nbsp;
											<input type="text" size="8" placeholder="" id="queryapplyname"  name="queryapplyname">
											
											&nbsp;&nbsp;&nbsp;
											电话&nbsp; 
											<input type="text" placeholder=""  size="12" id="queryapplyphone" name="queryapplyphone">
											
											&nbsp;&nbsp;&nbsp;
											提交人用户名&nbsp;
											<input type="text" placeholder="" size="8" id="querysubmitname" name="querysubmitname">
											
											&nbsp;&nbsp;&nbsp;
											提交人电话&nbsp;
											<input type="text" placeholder="" size="12" id="querysubmitphone" name="querysubmitphone">
											
											  申请时间&nbsp;&nbsp;从&nbsp;<input type="text" placeholder="请选择" class="datepicker" size="12" id="starttime" name="starttime"
						                     data-date-format="yyyy-mm-dd" data-date-end-date="0d">&nbsp;到&nbsp;
						                     
		                                    <input type="text" class="datepicker" size="12" placeholder="请选择" id="endtime" name="endtime"
		            						data-date-format="yyyy-mm-dd" data-date-end-date="0d">  
						            						
											
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<button id="applyingsousuo" onclick="applyingsousuo()" class="btn btn-success">搜索</button>
											&nbsp;
											<button id="applyingreset" onclick="AuthApplyAdd()" class="btn btn-primary">新增</button>
											&nbsp;
											<button id="applyingreset" onclick="applyingreset()" class="btn btn-purple">重置</button>
										</fieldset>
										
									</div>
								
								
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
													<th class="hidden-480">提交申请人姓名</th>
													<th class="hidden-480">提交申请人电话</th>
													<th class="hidden-480">提交申请时间</th>
													<th class="hidden-480">备注</th>
													<th class="hidden-480">操作</th>
												</tr>
											</thead>
				
									 <tbody id="myPaTbody">
<%-- 											<c:forEach items="${authApplyMessagePageList.data}" var="item" varStatus="status">   --%>
<!-- 												  <tr >   -->
<%-- 												    <td>${item.apply_name}</td>   --%>
<%-- 												    <td>${item.applysex}</td>   --%>
<%-- 												    <td>${item.apply_telphone}</td>   --%>
<%-- 												    <td>${item.submit_name}</td>   --%>
<%-- 												    <td>${item.submit_telphone}</td>   --%>
<%-- 												    <td>${item.submit_time}</td>   --%>
<%-- 												    <td style="width:150px">${item.beizhu}</td>  --%>
<!-- 												  </tr>   -->
<%-- 											</c:forEach>   --%>
										</tbody>
											
										</table>
									</div>
									
									<!-- 分页  -->
									
									<div class="modal-footer no-margin-top">
									
												<ul class="pagination" style="float: left; font-size:16px">
													总共    <i id="iTotalPage"></i> 条数据
													/ 共    <i id="iLastPage"></i> 页 /当前第 <i id="icurrentPage"></i> 页 
												</ul>
												
												<ul class="pagination" id="pageMessage" style="float: rigth; font-size:14px">
													<li id="firstLi">
														<a href="javascript:goPage('1')">
															首页
														</a>
													</li>
													
													<li id="preLi">
														<a href="#">
															<<
														</a>
													</li>
													
													
													<li id="nextLi">
														<a href="#">
															>>
														</a>
													</li>
													
													<li id="lastLi">
														<a href="#">
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
					
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">  
			    <div class="modal-dialog" role="document">  
			        <div class="modal-content">  
			            <div class="modal-header">  
			                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span  
			                        aria-hidden="true">×</span></button>  
			                <h4 class="modal-title" id="exampleModalLabel">新增申请</h4>  
			            </div>  
			            <div class="modal-body"> 
			                <form>  
			                    <div class="form-group">  
			                        <label for="recipient-name"  class="control-label">申请的用户名:</label>  
			                        <input type="text" class="form-control" placeholder="请输入申请的用户名" id="myModelApplyName">  
			                    </div>  
			                    
			                   <div class="form-group">  
			                        <label for="recipient-name" class="control-label">申请用户的电话:</label>  
			                        <input type="text" class="form-control" placeholder="请输入申请用户的电话" id="myModelApplyTelphone">  
			                    </div>  
			                    
			                    <div class="form-group">  
			                        <label for="recipient-name" class="control-label">提交人用户名:</label>  
			                        <input type="text" class="form-control" placeholder="请输入提交人的用户名" id="myModelSubmitTelphone">  
			                    </div>  
			                    
			                   <div class="form-group">  
			                        <label for="recipient-name" class="control-label">提交人的电话:</label>  
			                        <input type="text" class="form-control" placeholder="请输入提交人的电话" id="myModelSubmitTelphone">  
			                    </div> 
			                    
			                     <div class="form-group">  
			                     	<label for="recipient-name" class="control-label">申请时间:</label>
			                     	</br>
			                     	 
				                    <input type="text" placeholder="请选择申请时间" class="datepicker" style="height:37px;width:535px"   name="myModelSubmitTime"
							         data-date-format="yyyy-mm-dd" data-date-end-date="0d">
			                     </div>
			                      
			                    <div class="form-group">  
			                        <label for="message-text" class="control-label">备注信息:</label>  
			                        <textarea class="form-control" placeholder="请备注申请权限"  id="myModelbeizhu"></textarea>  
			                    </div>  
			                </form>  
			            </div>  
			            <div class="modal-footer">  
			                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
			                <button type="button" id="myModelSubmit" class="btn btn-primary" data-dismiss="modal">提交</button>  
			            </div>  
			        </div>  
			    </div>  
			</div>  
<!-- 			模态框结束	 -->
					
		<script src="/resources/jquery/jquery-1.11.1.js"></script>
		<script src="/resources/assets/js/bootstrap.min.js"></script>
		<script src="/resources/assets/js/typeahead-bs2.min.js"></script>
		
		<!-- bootstrap日历插件 -->
		
		<script src="/resources/js/bootstrap-datepicker.min.js"></script>
		<script src="/resources/js/bootstrap-datepicker.zh-CN.min.js"></script>
		
		<!-- ace scripts -->
		<!-- 必须引入 ,否则导航栏不能用 -->
		<script src="/resources/assets/js/ace-elements.min.js"></script>
		<script src="/resources/assets/js/ace.min.js"></script>
		<script src="/resources/layer/layer.js"></script> 
		
		<script type="text/javascript">
			$(function() {
				
				//页面加载的时候加载时间按钮
                $('.datepicker').datepicker({
                	keyboardNavigation:false,
                    language: "zh-CN",
                    minDate: new Date(),
                    autoclose: true,//选中之后自动隐藏日期选择框
                    clearBtn: true,//清除按钮
                    //todayBtn: "linked",//显示今日按钮
                    todayHighlight : true,//如果为true, 高亮当前日期。
                    format: "yyyy-mm-dd"
                });
				//初始化的时候默认加载第一页的数据
				goPage(1);
			});
		</script>
		
		<script type="text/javascript">
		
			function goPage(parameter){
					var parameters = {currentPage:parameter};
					$.post("/AuthApplyMessage/goPage",parameters,function(data){
						var currentPage = data.pageList.currentPage;
						$("#icurrentPage").text(currentPage);
						
						var totalCount = data.pageList.totalCount;
						$("#iTotalPage").text(totalCount);
						
						var upPage = data.pageList.upPage;
						$("#preLi").find("a").attr("href","javascript:goPage("+upPage+")");
						
						var nextPage = data.pageList.nextPage;
						$("#nextLi").find("a").attr("href","javascript:goPage("+nextPage+")");
						
						var lastPage = data.pageList.lastPage;
						$("#lastLi").find("a").attr("href","javascript:goPage("+lastPage+")");
						
						$("#iLastPage").text(lastPage);
						
						var data = data.pageList.data;
						
						$("#myPaTbody").empty();
						$.each(data,function (index,data){
							$("#myPaTbody").append(
								'<tr>'+
									'<td>'+data.apply_name+'</td>'+
									'<td>'+data.applysex+'</td>'+
									'<td>'+data.apply_telphone+'</td>'+
									'<td>'+data.submit_name+'</td>'+
									'<td>'+data.submit_telphone+'</td>'+
									'<td>'+data.submit_time+'</td>'+
									'<td style="width:150px">'+data.beizhu+'</td>'+
									'<td>'+
									
										'<a class="red" href="javascript:AuthApplyDelete('+data.id+')"><i class="icon-trash bigger-130"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
										
										'<a class="green" href="javascript:AuthApplyUpdate('+data.id+')"><i class="icon-pencil bigger-130"></i></a></td>'+
								'</tr>'
							)
						})
						
						//禁用分页条
						if(currentPage==1){
							$("#firstLi").attr("class","disabled");
							$("#preLi").attr("class","disabled");
							$("#nextLi").attr("class","");
							$("#lastLi").attr("class","");
						}
						if(currentPage==lastPage){
							$("#nextLi").attr("class","disabled");
							$("#lastLi").attr("class","disabled");
							$("#firstLi").attr("class","");
							$("#preLi").attr("class","");
						}
					})

			}
			
			function applyingsousuo(){
				var queryapplyname = $("#queryapplyname").val();
				var queryapplyphone = $("#queryapplyphone").val();
				var querysubmitname = $("#querysubmitname").val();
				var querysubmitphone = $("#querysubmitphone").val();
				var starttime = $("#starttime").val();
				var endtime = $("#endtime").val();
				var parameters = JSON.stringify(
						{
							queryapplyname:queryapplyname,
							queryapplyphone:queryapplyphone,
							querysubmitname:querysubmitname,
							querysubmitphone:querysubmitphone,
							starttime:starttime,
							endtime:endtime
						});
				$.ajax({    
			            type:"POST",   
			            contentType:"application/json; charset=utf-8",    
			            url:"/AuthApplyMessage/sousuo",
			            data:parameters,   
			            dataType: "json", 
			            success: function (data) {
			            	
			            	var currentPage = data.pageList.currentPage;
							$("#icurrentPage").text(currentPage);
							
							var totalCount = data.pageList.totalCount;
							$("#iTotalPage").text(totalCount);
							
							var upPage = data.pageList.upPage;
							$("#preLi").find("a").attr("href","javascript:goPage("+upPage+")");
							
							var nextPage = data.pageList.nextPage;
							$("#nextLi").find("a").attr("href","javascript:goPage("+nextPage+")");
							
							var lastPage = data.pageList.lastPage;
							$("#lastLi").find("a").attr("href","javascript:goPage("+lastPage+")");
							
							$("#iLastPage").text(lastPage);
							//获取分页后的数据
							var data = data.pageList.data;
							//先清空myPaTbody的数据
							$("#myPaTbody").empty();
							$.each(data,function (index,data){
								$("#myPaTbody").append(
									'<tr>'+
										'<td>'+data.apply_name+'</td>'+
										'<td>'+data.applysex+'</td>'+
										'<td>'+data.apply_telphone+'</td>'+
										'<td>'+data.submit_name+'</td>'+
										'<td>'+data.submit_telphone+'</td>'+
										'<td>'+data.submit_time+'</td>'+
										'<td style="width:150px">'+data.beizhu+'</td>'+
										'<td>'+
										
											'<a class="red" href="javascript:AuthApplyDelete('+data.id+')"><i class="icon-trash bigger-130"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
											
											'<a class="green" href="javascript:AuthApplyUpdate('+data.id+')"><i class="icon-pencil bigger-130"></i></a></td>'+
									'</tr>'
								)
							})
							
							//禁用分页条
							if(currentPage==1){
								$("#firstLi").attr("class","disabled");
								$("#preLi").attr("class","disabled");
								$("#nextLi").attr("class","");
								$("#lastLi").attr("class","");
							}
							if(currentPage==lastPage){
								$("#nextLi").attr("class","disabled");
								$("#lastLi").attr("class","disabled");
								$("#firstLi").attr("class","");
								$("#preLi").attr("class","");
							}

			            },
					})
				}
			
			
			function applyingreset(){
				var queryapplyname = $("#queryapplyname").val("");
				var queryapplyphone = $("#queryapplyphone").val("");
				var querysubmitname = $("#querysubmitname").val("");
				var querysubmitphone = $("#querysubmitphone").val("");
				var starttime = $("#starttime").val("");
				var endtime = $("#endtime").val("");
			}
			
			function AuthApplyDelete(parameter){
				layer.open({
					title:'温馨提示',
					//大小
					area: ['350px', '180px'],
					//坐标
				    offset: '100px',
					content:'删除后不可恢复 ,你确定删除？',
					btn: ['确认', '取消'],
					yes: function(index,layero){
						layer.close(index);
						$.post("/AuthApplyMessage/AuthApplyDelete",{id:parameter},function(data){
							var reminder = data.remark;
							layer.alert(reminder,{
								title:'温馨提示',
								//大小
								area: ['350px', '180px'],
								//坐标
							    offset: '100px',
							});
							location.reload();
						})
					},
				});

			}
			
			
			function AuthApplyUpdate(parameter){
				alert(parameter);
			}
			
			function AuthApplyAdd(parameter){
				$('#myModal').modal('show');  

			}
		</script>
		
</body>
</html>