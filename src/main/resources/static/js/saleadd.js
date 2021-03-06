var scode = null;
var sname = null;
var snumber = null;
var sprice = null;
var addBtn = null;
var backBtn = null;
function priceReg (value){
	value = value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符
		value = value.replace(/^\./g,"");  //验证第一个字符是数字而不是.
    value = value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的.
    value = value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");//去掉特殊符号￥
	if(value.indexOf(".")>0){
		value = value.substring(0,value.indexOf(".")+3);
	}
	return value;
}
$(function(){
	scode = $("#scode");
	sname = $("#sname");
	snumber = $("#snumber");
	sprice = $("#sprice");
	addBtn = $("#add");
	backBtn = $("#back");
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	scode.next().html("*");
	snumber.next().html("*");
	sprice.next().html("*");

	$.ajax({
		type:"GET",
		url:path+"/goods/goodslist",
		dataType:"json",
		success:function(data){//data：返回数据（json对象）
			if(data.goodslist != null){
				sname.html("");
				var options = "<option value=\" \">请选择</option>";
				for(var i = 0; i < data.goodslist.length; i++){
						options += "<option  value=\""+data.goodslist[i].gname+"\" >"+data.goodslist[i].gname+"</option>";
				}
				sname.html(options);
			}
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			validateTip(sname.next(),{"color":"red"},imgNo+" 获取库存列表error",false);
		}
	});
	
	 
	scode.on("blur",function(){
		if(scode.val() != null && scode.val() != ""){
			validateTip(scode.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(scode.next(),{"color":"red"},imgNo+" 编码不能为空，请重新输入",false);
		}
	}).on("focus",function(){
		//显示友情提示
		validateTip(scode.next(),{"color":"#666666"},"* 请输入销售单编码",false);
	}).focus();
	
	sname.on("focus",function(){
		validateTip(sname.next(),{"color":"#666666"},"* 请输入售货名称",false);
	}).on("blur",function(){
		if(sname.val() != null && sname.val() != ""){
			validateTip(sname.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(sname.next(),{"color":"red"},imgNo+" 名称不能为空，请重新输入",false);
		}
		
	});
	
	snumber.on("focus",function(){
		validateTip(snumber.next(),{"color":"#666666"},"* 请输入数量",false);
	}).on("blur",function(){
		if(snumber.val() != null && snumber.val() != ""){
			validateTip(snumber.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(snumber.next(),{"color":"red"},imgNo+" 数量不能为空，请重新输入",false);
		}
		
	});
	
	sprice.on("focus",function(){
		validateTip(sprice.next(),{"color":"#666666"},"* 请输入大于0的正自然数，小数点后保留2位",false);
	}).on("keyup",function(){
		this.value = priceReg(this.value);
	}).on("blur",function(){
		this.value = priceReg(this.value);
	});
	
addBtn.on("click",function(){
		if(scode.attr("validateStatus") != "true"){
			scode.blur();
		}else if(sname.attr("validateStatus") != "true"){
			sname.blur();
		}else if(snumber.attr("validateStatus") != "true"){
			snumber.blur();
		}else{
			if(confirm("是否确认提交数据")){
				$("#saleForm").submit();
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