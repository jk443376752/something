<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="utf-8" />
		<title>注册账号</title>
		<!-- basic styles -->
		<link href="/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="/resources/assets/css/font-awesome.min.css" />
		<!-- fonts -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
		<!-- ace styles -->
		<link rel="stylesheet" href="/resources/assets/css/ace.min.css" />
		<link rel="stylesheet" href="/resources/assets/css/ace-rtl.min.css" />
		
		<link rel="stylesheet" href="/resources/layer/skin/default/layer.css">
		<!-- js -->
		<script src="/resources/jquery/jquery-1.11.1.js"></script>
		<script src="/resources/bootstrap3.3.7/js/bootstrap.min.js"></script>
	</head>

	<div style="margin-top:130px">
	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">用户注册页面</span>
								</h1>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												请输入您的信息
											</h4>

											<div class="space-6"></div>

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="username" id="registerusername" class="form-control" placeholder="请输入用户名" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password" id="registerpassword" class="form-control" placeholder="请输入密码" />
															<i class="icon-lock"></i>
														</span>
													</label>
													
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password" id="registerrepassword" class="form-control" placeholder="请再次输入密码" />
															<i class="icon-lock"></i>
														</span>
													</label>
													
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="radio"  value="男" name="sex">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="radio"  value="女" name="sex">女
															<i class="icon-lock"></i>
														</span>
													</label>
													
													
													<div class="toolbar clearfix">
														<div>
															<a href="javascript:registerGoBack()"  class="forgot-password-link">
																<i class="icon-arrow-left"></i>
																返回
															</a>
														</div>
			
														<div>
															<a href="javascript:registerUser()" class="user-signup-link">
																注册
																<i class="icon-arrow-right"></i>
															</a>
														</div>
													</div>
													
													
												<div class="space-4"></div>
												</fieldset>
											</form>

										</div><!-- /widget-main -->

									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
			
			
			<!-- bootstrap模态框开始 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" data-dismiss="modal" 
			                        aria-hidden="true">×
			                </button>
			                <h4 class="modal-title" id="myModalLabel">
			                   		<b>温馨提示:</b> 
			                </h4>
			            </div>
			            <div class="modal-body" id="myContent">
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
</div>
		<script src="/resources/layer/layer.js"></script>
		<script>
			
		function registerUser(){
			
			var username = $("#registerusername").val();
			var password = $("#registerpassword").val();
			var repassword = $("#registerrepassword").val();
			var sex = $("input[name='sex']:checked").val();
			
			if(username.length<=0||password.length<=0||repassword<=0||sex==null){
				layer.alert('所有选项不能为空!',{
					title:'温馨提示',
					//大小
					area: ['350px', '180px'],
					//坐标
					offset: '100px'
				});
				
				return;
			}
			
			var registerParameter = 
				JSON.stringify(
				[    
                   {username:username},
                   {password:password},
                   {repassword:repassword},
                   {sex:sex},
			     ]); 

			$.ajax({    
	            type:"post",   
	            url:"/register/checkRegister",
	            data:registerParameter,    
	            contentType:"application/json; charset=utf-8",    
	            dataType: "json",
	            success: function (data,message) {
	            	var reminder =data.remark;
					layer.alert(reminder,{
						title:'温馨提示',
						//大小
						area: ['350px', '180px'],
						//坐标
					    offset: '100px',
					    
					    //点击确认回调
					    yes: function(index, layero){
			    	       if(data.is_abnormal==1){
			    	    	   layer.close(index);
				    	    	window.location.href="/login"; 
				      	      	return;
				    	   }else{
				    		   layer.close(index);
				    	   }
					    },
					    //点击关闭回调
					    cancel: function(index, layero){ 
				    	   if(data.is_abnormal==1){
				    	    	window.location.href="/login"; 
				      	      	return;
				    	   }
					    }
					});
	    	        return;
	            }   
	       	 })     
			
			}
		
			function registerGoBack(){
				history.go(-1);
			}
		</script>
</html>