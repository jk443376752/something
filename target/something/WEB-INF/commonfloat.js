
	jQuery(document).ready(function (){
		
		//先拿到tbody , 其中myfpbxhhzqzyjk是配置的id
		var tbody = $("#myqzyjk").parent().parent().parent().parent();
		//在table上面创建一个需要浮动的div,并取一个id名字
		tbody.prepend("<div id='myFloatDiv'> </div>");
		//把需要浮动的数据找出来追加到浮动的div里面取
		$("#myFloatDiv").append(tbody.find("tr:eq(1)"));
		$("#myFloatDiv").append(tbody.find("tr:eq(2)"));
		$("#myFloatDiv").append(tbody.find("tr:eq(3)"));
		$("#myFloatDiv").append(tbody.find("tr:eq(4)"));
		$("#myFloatDiv").append(tbody.find("tr:eq(5)"));
		
		//动态的获取table的宽度
		var taWidth = $("#myFloatDiv").parent().css("width")
		//设置div浮动
		$("#myFloatDiv").css({ 
		  "position":"fixed", 
		  "top":"0px", 
		  "width":taWidth,
		  "background-color":"#FFF",
		  "z-index":"500"
		});
		
		//取浮动div中的tr高度和
		var divTotalTemp = $("#myFloatDiv").css("height");
		//把像素截取成数字
		var divTotal = parseInt(divTotalTemp.substr(0,divTotalTemp.length-2))+parseInt(26)+"px";
		//alert(divTotal)
		
		//清除table的class样式
		$("#myFloatDiv").parent().attr("class","");
		//拿到table的jquery对象,设置距离表单的浮动div的距离
		$("#myFloatDiv").parent().css({
			"padding-top":divTotal,
		});
		
	});
