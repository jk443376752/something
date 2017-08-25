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
							商城后台管理系统
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
										设置
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-user"></i>
										个人资料
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="/loginOut">
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
								<i class="icon-list"></i>
								<span class="menu-text"> 表格 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="tables.html">
										<i class="icon-double-angle-right"></i>
										简单 &amp; 动态
									</a>
								</li>

								<li>
									<a href="jqgrid.html">
										<i class="icon-double-angle-right"></i>
										jqGrid plugin
									</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-edit"></i>
								<span class="menu-text"> 表单 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="form-elements.html">
										<i class="icon-double-angle-right"></i>
										表单组件
									</a>
								</li>

								<li>
									<a href="form-wizard.html">
										<i class="icon-double-angle-right"></i>
										向导提示 &amp; 验证
									</a>
								</li>

								<li>
									<a href="wysiwyg.html">
										<i class="icon-double-angle-right"></i>
										编辑器
									</a>
								</li>

								<li>
									<a href="dropzone.html">
										<i class="icon-double-angle-right"></i>
										文件上传
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

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- #nav-search -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<button type="button" class="btn btn-success" style="width:318px">今日工作</button>
							<button type="button" class="btn btn-primary" style="width:318px">今日待访</button>
							<button type="button" class="btn btn-info" style="width:318px">今日结算</button>
							<button type="button" class="btn btn-warning" style="width:318px">今日生日</button>
						</div><!-- /.page-header -->
						<!-- 表单开始 -->
							<div class="row">
								<div class="col-xs-12">
									<div class="table-header">
										患者详情
									</div>
				
									<div class="table-responsive">
										<table id="sample-table-2" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
<!-- 													<th class="center"> -->
<!-- 														<label> -->
<!-- 															<input type="checkbox" class="ace" /> -->
<!-- 															<span class="lbl"></span> -->
<!-- 														</label> -->
<!-- 													</th> -->
													<th>患者姓名</th>
													<th>状态</th>
													<th class="hidden-480">病历情况</th>
				
													<th>
														病历号
													</th>
													<th class="hidden-480">就诊时间</th>
													
													<th class="hidden-480">预约时间</th>
													<th>医生</th>
													<th>电话</th>
													<th>就诊状态</th>
													<th>应收</th>
													<th>实收</th>
													<th>操作</th>
												</tr>
											</thead>
				
											<tbody id="myPaTbody">
<!-- 												<tr id="myTableTr"> -->
<!-- 													<td class="center"> -->
<!-- 														<label> -->
<!-- 															<input type="checkbox" class="ace" /> -->
<!-- 															<span class="lbl"></span> -->
<!-- 														</label> -->
<!-- 													</td> -->
				
<!-- 													<td > -->
<!-- 														<a href="#" id="myPaName">once.com</a> -->
<!-- 													</td> -->
<!-- 													<td>$20</td> -->
<!-- 													<td class="hidden-480"> -->
<!-- 														<span class="label label-sm label-info arrowed arrowed-righ">Sold</span> -->
<!-- 													</td> -->
<!-- 													<td class="hidden-480">1,400</td> -->
<!-- 													<td>Apr 04</td> -->
<!-- 													<td>Apr 04</td> -->
<!-- 													<td>Apr 04</td> -->
<!-- 													<td>Apr 04</td> -->
<!-- 													<td>Apr 04</td> -->
<!-- 													<td>Apr 04</td> -->
<!-- 													<td>Apr 04</td> -->
				
				
<!-- 													<td> -->
<!-- 														<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons"> -->
<!-- 															<a class="blue" href="#"> -->
<!-- 																<i class="icon-zoom-in bigger-130"></i> -->
<!-- 															</a> -->
				
<!-- 															<a class="green" href="#"> -->
<!-- 																<i class="icon-pencil bigger-130"></i> -->
<!-- 															</a> -->
				
<!-- 															<a class="red" href="#"> -->
<!-- 																<i class="icon-trash bigger-130"></i> -->
<!-- 															</a> -->
<!-- 														</div> -->
				
<!-- 														<div class="visible-xs visible-sm hidden-md hidden-lg"> -->
<!-- 															<div class="inline position-relative"> -->
<!-- 																<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown"> -->
<!-- 																	<i class="icon-caret-down icon-only bigger-120"></i> -->
<!-- 																</button> -->
				
<!-- 																<ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close"> -->
<!-- 																	<li> -->
<!-- 																		<a href="#" class="tooltip-info" data-rel="tooltip" title="View"> -->
<!-- 																			<span class="blue"> -->
<!-- 																				<i class="icon-zoom-in bigger-120"></i> -->
<!-- 																			</span> -->
<!-- 																		</a> -->
<!-- 																	</li> -->
				
<!-- 																	<li> -->
<!-- 																		<a href="#" class="tooltip-success" data-rel="tooltip" title="Edit"> -->
<!-- 																			<span class="green"> -->
<!-- 																				<i class="icon-edit bigger-120"></i> -->
<!-- 																			</span> -->
<!-- 																		</a> -->
<!-- 																	</li> -->
				
<!-- 																	<li> -->
<!-- 																		<a href="#" class="tooltip-error" data-rel="tooltip" title="Delete"> -->
<!-- 																			<span class="red"> -->
<!-- 																				<i class="icon-trash bigger-120"></i> -->
<!-- 																			</span> -->
<!-- 																		</a> -->
<!-- 																	</li> -->
<!-- 																</ul> -->
<!-- 															</div> -->
<!-- 														</div> -->
<!-- 													</td> -->
<!-- 												</tr> -->
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

			<a href="" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>

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
			//dom模型加载完成后自动初始化
			$(function(){
				getTableList(1);
			})
			
			//加载首页表单数据
			function getTableList(parameter){
				 $("#myPaTbody").empty();
				 $.post('patient/getPatientTableList',
						 {
						 	currentPage:parameter
				 		 },
			    	     function(data,status){
						 var dataPageList = data.pageList.data;
						 $.each(dataPageList,function(index ,value){
							 if(value.pa_id){
							 	var pa_id = value.pa_id;
							 }else{
								var pa_id ="";
							 }
							 
							 if(value.pa_name){
								 	var pa_name = value.pa_name;
							 }else{
									var pa_name ="";
							 }
							 
							 if(value.pa_receivable){
								 	var pa_receivable = value.pa_receivable;
							 }else{
									var pa_receivable ="";
							 }
							 
							 if(value.pa_net_receipts){
								 	var pa_net_receipts = value.pa_net_receipts;
							 }else{
									var pa_net_receipts ="";
							 }
							 
							 if(value.pa_phone){
								 	var pa_phone = value.pa_phone;
							 }else{
									var pa_phone ="";
							 }
							 
							 if(value.pa_case_history){
								 	var pa_case_history = value.pa_case_history;
							 }else{
									var pa_case_history ="";
							 }
							 
							 if(value.pa_case_history_num){
								 	var pa_case_history_num = value.pa_case_history_num;
							 }else{
									var pa_case_history_num ="";
							 }
							 
							 if(value.pa_doctor_name){
								 	var pa_doctor_name = value.pa_doctor_name;
							 }else{
									var pa_doctor_name ="";
							 }
							 
							 if(value.pa_clinic_time){
								 	var pa_clinic_time = value.pa_clinic_time;
							 }else{
									var pa_clinic_time ="";
							 }
							 
							 if(value.pa_attendance_status){
								 	var pa_attendance_status = value.pa_attendance_status;
							 }else{
									var pa_attendance_status ="";
							 }
//	 						 if(index<=11){
//	 						 }
//	 							$("#myPaTbody").append('<td class="center"><label><input type="checkbox" class="ace" /><span class="lbl"></span></label></td> ');
							 $("#myPaTbody").append('<tr id=myTr'+index+'>'+'</tr>');
							 $('#myTr'+index).append(
									 '<td>'+pa_name+'</td>'
									 +'<td>'+pa_receivable+'</td>'
									 +'<td>'+pa_receivable+'</td>'
									 +'<td>'+pa_net_receipts+'</td>'
									 +'<td>'+pa_phone+'</td>'
									 +'<td>'+pa_case_history+'</td>'
									 +'<td>'+pa_case_history_num+'</td>'
									 +'<td>'+pa_doctor_name+'</td>'
									 +'<td>'+pa_clinic_time+'</td>'
									 +'<td>'+pa_attendance_status+'</td>'
									 +'<td>'+pa_attendance_status+'</td>'
									 +'<td><div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">'
									 +'<a class="green" href='+'"javascript:updateTableList('+pa_id+')">'
									 +'<i class="icon-pencil bigger-130"></i>'
									 +'</a>'
									 +'&nbsp&nbsp'
									 +'<a class="red" href="'+'javascript:deleteTableList('+pa_id+')">'
									 +'<i class="icon-trash bigger-130"></i>'
									 +'</a>'
									 +'</div></td>'
							)
						 })
						 $("#iStart").empty();
						 $("#iEnd").empty();
						 $("#iTotalPage").empty();
						 $("#iLastPage").empty();
						 $("#icurrentPage").empty();
						 //加载分页信息
						 var pageStrat = (data.pageList.currentPage-1)*data.pageList.pageSize+1;
						 var pageEnd = pageStrat-1+data.pageList.pageSize;
						 var totalCount = data.pageList.totalCount;
						 var lastPage = data.pageList.lastPage;
						 var currentPage = data.pageList.currentPage;
						 $("#iStart").append(pageStrat);
						 $("#iEnd").append(pageEnd);
						 $("#iTotalPage").append(totalCount);
						 $("#iLastPage").append(lastPage);
						 $("#icurrentPage").append(currentPage)
					   });
					
			}
			
			//分页条信息处理
			function goPage(page){
				//加载页面信息
				var parameter = []
				if(page=='1'){
					parameter.currentPage = 1;
				}
				
				if(page=='upPage'){
					if($("#icurrentPage").text()-1<1){
						parameter.currentPage = 1;
					}else{
						parameter.currentPage = $("#icurrentPage").text()-1;
					}
				}
				
				if(page=='nextPage'){
					if(parseInt($("#icurrentPage").text())+1>$("#iLastPage").text()){
						parameter.currentPage = $("#iLastPage").text();
					}else{
						parameter.currentPage =  parseInt($("#icurrentPage").text())+1;
					}
				}
				
				if(page=='lastPage'){
					parameter.currentPage = $("#iLastPage").text();
				}
				
				//判断第一页或最后一页是否被禁用了 , 被禁用了点击就不加载数据 .
				if(parameter.currentPage==1&&$("#firstLi").attr("class")=="disabled"){
					return;
				}
				if(parameter.currentPage==$("#iLastPage").text()&& $("#lastLi").attr("class")=="disabled"){
					return;
				}
				getTableList(parameter.currentPage);
				
				//禁用分页条按钮
				if(parameter.currentPage==1){
					$("#firstLi").attr("class","disabled");
					$("#preLi").attr("class","disabled");
					$("#nextLi").attr("class","");
					$("#lastLi").attr("class","");
					
				}else if(parameter.currentPage==$("#iLastPage").text()){
					$("#firstLi").attr("class","");
					$("#preLi").attr("class","");
					$("#nextLi").attr("class","disabled");
					$("#lastLi").attr("class","disabled");
				}else{
					$("#firstLi").attr("class","");
					$("#preLi").attr("class","");
					$("#nextLi").attr("class","");
					$("#lastLi").attr("class","");
				}
			}
			
			
			
			function updateTableList(id){
				$('#myMainModal').modal('show');
			}
			
			
			function deleteTableList(id){
				layer.confirm('你确定要删除吗?', {
						area: ['350px', '180px'], //宽高
						offset: '100px',
						btn: ['确定','取消'] //按钮
						}, function(){
							//点确认执行的方法
							$.post("patient/deleteTableList",
							  {
								pa_id:id,
							  });
							  //重新加载数据
							  getTableList(1)
							  layer.msg("成功删除一条数据");
						}, function(){
							
						}); 
			}
			
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
