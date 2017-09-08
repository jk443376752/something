<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>后台主页面</title>
		<!-- basic styles -->
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
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							权限管理系统后台管理
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
					
					
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="/resources/assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎你</small>
									${username}
								</span>
								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										修改资料
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-user"></i>
										个人详情
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="/loginOutManager">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<ul class="nav nav-list">
						<li class="active">
							<a href="/main">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 首页 </span>
							</a>
						</li>
						
						
						
						<li>
							<a href="#" class="dropdown-toggle">
								<span class="menu-text">待办事务</span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="form-elements.html">
										<i class="icon-double-angle-right"></i>
										权限添加申请
									</a>
								</li>

								<li>
									<a href="form-wizard.html">
										<i class="icon-double-angle-right"></i>
										权限移除申请
									</a>
								</li>
								
								<li>
									<a href="form-wizard.html">
										<i class="icon-double-angle-right"></i>
										今日处理申请
									</a>
								</li>
							</ul>
						</li>
						
						
						
						<li>
							<a href="#" class="dropdown-toggle">
								<span class="menu-text">详情信息</span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="form-elements.html">
										<i class="icon-double-angle-right"></i>
										用户信息
									</a>
								</li>

								<li>
									<a href="form-wizard.html">
										<i class="icon-double-angle-right"></i>
										角色信息
									</a>
								</li>

								<li>
									<a href="wysiwyg.html">
										<i class="icon-double-angle-right"></i>
										权限信息
									</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="#" class="dropdown-toggle">
								<span class="menu-text">配置管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="form-elements.html">
										<i class="icon-double-angle-right"></i>
										用户管理
									</a>
								</li>

								<li>
									<a href="form-wizard.html">
										<i class="icon-double-angle-right"></i>
										角色管理
									</a>
								</li>

								<li>
									<a href="wysiwyg.html">
										<i class="icon-double-angle-right"></i>
										权限管理
									</a>
								</li>
							</ul>
						</li>
						
						
						<li>
							<a href="#" class="dropdown-toggle">
								<span class="menu-text">个人中心 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="form-elements.html">
										<i class="icon-double-angle-right"></i>
										基本信息
									</a>
								</li>

								<li>
									<a href="form-wizard.html">
										<i class="icon-double-angle-right"></i>
										修改基本资料
									</a>
								</li>

								<li>
									<a href="wysiwyg.html">
										<i class="icon-double-angle-right"></i>
										修改密码
									</a>
								</li>
							</ul>
						</li>
						
						
						<li>
							<a href="#" class="dropdown-toggle">
								<span class="menu-text">日志管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="form-elements.html">
										<i class="icon-double-angle-right"></i>
										系统日志
									</a>
								</li>
							</ul>
						</li>
						
						
				</div>

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="/main">首页</a>
							</li>
							<li class="active">控制台</li>
						</ul><!-- .breadcrumb -->


					<div class="page-content">
						<!-- 表单开始 -->
							<div class="row">
								<div class="col-xs-12">
									<div class="table-header">
										权限添加申请
									</div>
				
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover">
											<thead align="center">
												<tr>
													<th>姓名</th>
													<th>性别</th>
													<th>申请用户名</th>
													<th>申请密码</th>
													<th class="hidden-480">电话</th>
													<th>单位</th>
													<th class="hidden-480">提交申请人姓名</th>
													<th class="hidden-480">提交申请人电话</th>
													<th class="hidden-480">提交申请人单位</th>
													<th class="hidden-480">提交申请时间</th>
													<th>操作</th>
													<th>操作</th>
												</tr>
											</thead>
				
											<tbody id="myPaTbody">
												<tr>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td><a>通过</a></td>
													<td><a>退回</a></td>
												</tr>
											</tbody>
											
										</table>
									</div>
									
									<!-- 分页  -->
									
									<div class="modal-footer no-margin-top">
									
												<ul class="pagination" style="float: left; font-size:16px">
													从   <i id="iStart"></i> 条 到   <i id="iEnd"></i> 条  / 总共    <i id="iTotalPage"></i> 条数据
													/ 共    <i id="iLastPage"></i> 页 /当前第 <i id="icurrentPage"></i> 页 
												</ul>
												
												
												<ul class="pagination pull-right no-margin" id="pageMessage">
													<li id="firstLi">
														<a href="javascript:goPage('1')">
															首页
														</a>
													</li>
													
													<li id="preLi">
														<a href="javascript:goPage('upPage')">
															上一页
														</a>
													</li>
													
													<li id="nextLi">
														<a href="javascript:goPage('nextPage')">
															下一页
														</a>
													</li>
													
													<li id="lastLi">
														<a href="javascript:goPage('lastPage')">
															尾页
														</a>
													</li>
												</ul>
										</div>
									<!-- 分页结束  -->
								</div>
							</div>
						<!-- 表单结束 -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->

<!-- 			<a href="" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> -->
<!-- 				<i class="icon-double-angle-up icon-only bigger-110"></i> -->
<!-- 			</a> -->

		<script src="/resources/jquery/jquery-1.11.1.js"></script>
		<script src="/resources/assets/js/bootstrap.min.js"></script>
		<script src="/resources/assets/js/typeahead-bs2.min.js"></script>
		
		<!-- ace scripts -->
		<!-- 必须引入 ,否则导航栏不能用 -->
		<script src="/resources/assets/js/ace-elements.min.js"></script>
		<script src="/resources/assets/js/ace.min.js"></script>
		
		<script src="/resources/layer/layer.js"></script> 
		
		
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				$('#loading-btn').on(ace.click_event, function () {
					var btn = $(this);
					btn.button('loading')
					setTimeout(function () {
						btn.button('reset')
					}, 2000)
				});
			
				$('#id-button-borders').attr('checked' , 'checked').on('click', function(){
						$('#default-buttons .btn').toggleClass('no-border');
				});
			})
		</script>
<!-- 请求数据 ,然后追加到首页去 --> 
		<script>
// 			//dom模型加载完成后自动初始化
// 			$(function(){
// 				getTableList(1);
// 			})
			
// 			//加载首页表单数据
// 			function getTableList(parameter){
// 				 $("#myPaTbody").empty();
// 				 $.post('patient/getPatientTableList',
// 						 {
// 						 	currentPage:parameter
// 				 		 },
// 			    	     function(data,status){
// 						 var dataPageList = data.pageList.data;
// 						 $.each(dataPageList,function(index ,value){
// 							 if(value.pa_id){
// 							 	var pa_id = value.pa_id;
// 							 }else{
// 								var pa_id ="";
// 							 }
							 
// 							 if(value.pa_name){
// 								 	var pa_name = value.pa_name;
// 							 }else{
// 									var pa_name ="";
// 							 }
							 
// 							 if(value.pa_receivable){
// 								 	var pa_receivable = value.pa_receivable;
// 							 }else{
// 									var pa_receivable ="";
// 							 }
							 
// 							 if(value.pa_net_receipts){
// 								 	var pa_net_receipts = value.pa_net_receipts;
// 							 }else{
// 									var pa_net_receipts ="";
// 							 }
							 
// 							 if(value.pa_phone){
// 								 	var pa_phone = value.pa_phone;
// 							 }else{
// 									var pa_phone ="";
// 							 }
							 
// 							 if(value.pa_case_history){
// 								 	var pa_case_history = value.pa_case_history;
// 							 }else{
// 									var pa_case_history ="";
// 							 }
							 
// 							 if(value.pa_case_history_num){
// 								 	var pa_case_history_num = value.pa_case_history_num;
// 							 }else{
// 									var pa_case_history_num ="";
// 							 }
							 
// 							 if(value.pa_doctor_name){
// 								 	var pa_doctor_name = value.pa_doctor_name;
// 							 }else{
// 									var pa_doctor_name ="";
// 							 }
							 
// 							 if(value.pa_clinic_time){
// 								 	var pa_clinic_time = value.pa_clinic_time;
// 							 }else{
// 									var pa_clinic_time ="";
// 							 }
							 
// 							 if(value.pa_attendance_status){
// 								 	var pa_attendance_status = value.pa_attendance_status;
// 							 }else{
// 									var pa_attendance_status ="";
// 							 }
							 
// 							 $("#myPaTbody").append('<tr id=myTr'+index+'>'+'</tr>');
// 							 $('#myTr'+index).append(
// 									 '<td>'+pa_name+'</td>'
// 									 +'<td>'+pa_receivable+'</td>'
// 									 +'<td>'+pa_receivable+'</td>'
// 									 +'<td>'+pa_net_receipts+'</td>'
// 									 +'<td>'+pa_phone+'</td>'
// 									 +'<td>'+pa_case_history+'</td>'
// 									 +'<td>'+pa_case_history_num+'</td>'
// 									 +'<td>'+pa_doctor_name+'</td>'
// 									 +'<td>'+pa_clinic_time+'</td>'
// 									 +'<td>'+pa_attendance_status+'</td>'
// 									 +'<td><a href="#">通过</a></td>'
// 									 +'<td><a href="#">退回</a></td>'
// 							)
// 						 })
// 						 $("#iStart").empty();
// 						 $("#iEnd").empty();
// 						 $("#iTotalPage").empty();
// 						 $("#iLastPage").empty();
// 						 $("#icurrentPage").empty();
// 						 //加载分页信息
// 						 var pageStrat = (data.pageList.currentPage-1)*data.pageList.pageSize+1;
// 						 var pageEnd = pageStrat-1+data.pageList.pageSize;
// 						 var totalCount = data.pageList.totalCount;
// 						 var lastPage = data.pageList.lastPage;
// 						 var currentPage = data.pageList.currentPage;
// 						 $("#iStart").append(pageStrat);
// 						 $("#iEnd").append(pageEnd);
// 						 $("#iTotalPage").append(totalCount);
// 						 $("#iLastPage").append(lastPage);
// 						 $("#icurrentPage").append(currentPage)
// 					   });
					
// 			}
			
// 			//分页条信息处理
// 			function goPage(page){
// 				//加载页面信息
// 				var parameter = []
// 				if(page=='1'){
// 					parameter.currentPage = 1;
// 				}
				
// 				if(page=='upPage'){
// 					if($("#icurrentPage").text()-1<1){
// 						parameter.currentPage = 1;
// 					}else{
// 						parameter.currentPage = $("#icurrentPage").text()-1;
// 					}
// 				}
				
// 				if(page=='nextPage'){
// 					if(parseInt($("#icurrentPage").text())+1>$("#iLastPage").text()){
// 						parameter.currentPage = $("#iLastPage").text();
// 					}else{
// 						parameter.currentPage =  parseInt($("#icurrentPage").text())+1;
// 					}
// 				}
				
// 				if(page=='lastPage'){
// 					parameter.currentPage = $("#iLastPage").text();
// 				}
				
// 				//判断第一页或最后一页是否被禁用了 , 被禁用了点击就不加载数据 .
// 				if(parameter.currentPage==1&&$("#firstLi").attr("class")=="disabled"){
// 					return;
// 				}
// 				if(parameter.currentPage==$("#iLastPage").text()&& $("#lastLi").attr("class")=="disabled"){
// 					return;
// 				}
// 				getTableList(parameter.currentPage);
				
// 				//禁用分页条按钮
// 				if(parameter.currentPage==1){
// 					$("#firstLi").attr("class","disabled");
// 					$("#preLi").attr("class","disabled");
// 					$("#nextLi").attr("class","");
// 					$("#lastLi").attr("class","");
					
// 				}else if(parameter.currentPage==$("#iLastPage").text()){
// 					$("#firstLi").attr("class","");
// 					$("#preLi").attr("class","");
// 					$("#nextLi").attr("class","disabled");
// 					$("#lastLi").attr("class","disabled");
// 				}else{
// 					$("#firstLi").attr("class","");
// 					$("#preLi").attr("class","");
// 					$("#nextLi").attr("class","");
// 					$("#lastLi").attr("class","");
// 				}
// 			}
			
			
			
// 			function updateTableList(id){
// 				$('#myMainModal').modal('show');
// 			}
			
			
// 			function deleteTableList(id){
// 				layer.confirm('你确定要删除吗?', {
// 						area: ['350px', '180px'], //宽高
// 						offset: '100px',
// 						btn: ['确定','取消'] //按钮
// 						}, function(){
// 							//点确认执行的方法
// 							$.post("patient/deleteTableList",
// 							  {
// 								pa_id:id,
// 							  });
// 							  //重新加载数据
// 							  getTableList(1)
// 							  layer.msg("成功删除一条数据");
// 						}, function(){
// 						}); 
// 			}
			
		</script>
		
		
	<!-- bootstrap模态框开始 -->
			<div class="modal fade" id="myMainModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" data-dismiss="modal" 
			                        aria-hidden="true">×
			                </button>
			                <h4 class="modal-title" id="myModalLabel">
			                   		修改患者信息
			                </h4>
			            </div>
			            <div class="modal-body" id="myContent">
				           <form role="form">
							  <div class="form-group">
							    <input class="form-control input-lg" type="text" >
							  </div>
							</form>
			            </div>
			            	
			            	
			            <div class="modal-footer">
			                <button type="button" class="btn btn-default" 
			                        data-dismiss="modal">确认
			                </button>
			            </div>
			        </div><!-- /.modal-content -->
			    </div><!-- /.modal-dialog -->
			</div>
	<!-- 模态框结束 -->
</body>
</html>
