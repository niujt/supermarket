var refCode = null;
var refName = null;
var refReasion = null;
var addBtn = null;
var backBtn = null;
var refnumber=null;




$(function(){
	refCode = $("#refCode");
	refName = $("#refName");
	refReasion= $("#refReasion");
	refnumber=$("#refnumber");
	addBtn = $("#add");
	backBtn = $("#back");
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	refCode.next().html("*");
	refName.next().html("*");
	refnumber.next().html("*");
	refReasion.next().html("*");
	
	

	$.ajax({
		type:"GET",
		url:path+"/goods/goodslist",
		dataType:"json",
		success:function(data){//data：返回数据（json对象）
			if(data.goodslist != null){
				refName.html("");
				var options = "<option value=\" \">请选择</option>";
				for(var i = 0; i < data.goodslist.length; i++){
						options += "<option  value=\""+data.goodslist[i].gname+"\" >"+data.goodslist[i].gname+"</option>";
				}
				refName.html(options);
			}
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			validateTip(sname.next(),{"color":"red"},imgNo+" 获取库存列表error",false);
		}
	});
	
	
	
	refCode.on("blur",function(){
		if(refCode.val() != null && refCode.val() != ""){
			validateTip(refCode.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(refCode.next(),{"color":"red"},imgNo+" 编码不能为空，请重新输入",false);
		}
	}).on("focus",function(){
		//显示友情提示
		validateTip(refCode.next(),{"color":"#666666"},"* 请输入退货单编码",false);
	}).focus();
	
	refnumber.on("blur",function(){
		if(refnumber.val() != null && refnumber.val() != ""){
			validateTip(refnumber.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(refnumber.next(),{"color":"red"},imgNo+" 退货数量不能为0，请重新输入",false);
		}
	}).on("focus",function(){
		//显示友情提示
		validateTip(refnumber.next(),{"color":"#666666"},"* 请输入数量",false);
	}).focus();

	refReasion.on("blur",function(){
		if(refReasion.val() != null && refReasion.val() != ""){
			validateTip(refReasion.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(refReasion.next(),{"color":"red"},imgNo+" 退货理由不能为空，请重新输入",false);
		}
	}).on("focus",function(){
		//显示友情提示
		validateTip(refReasion.next(),{"color":"#666666"},"* 请输入退货理由",false);
	}).focus();

	
	
	addBtn.bind("click",function(){
		if(refCode.attr("validateStatus") != "true"){
			refCode.blur();
		}else if(refnumber.attr("validateStatus") != "true"){
			refnumber.blur();
		}else if(refReasion.attr("validateStatus") != "true"){
			refReasion.blur();
		}else{
			if(confirm("是否确认提交数据")){
				$("#refuseForm").submit();
			}
		}
	});

	backBtn.on("click",function(){
		if(referer != undefined 
				&& null != referer 
				&& "" != referer
				&& "null" != referer
				&& referer.length > 4){
			window.location.href = referer;
		}else{
			history.back(-1);
		}
	});
});