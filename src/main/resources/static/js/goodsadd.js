var gcode = null;
var gname = null;
var gnumber = null;
var pprice = null;
var addBtn=null;
var backBtn=null;
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
	gcode = $("#gcode");
	gname = $("#gname");
	gnumber = $("#gnumber");
	pprice = $("#pprice");
	addBtn = $("#add");
	backBtn = $("#back");
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	gcode.next().html("*");
	gname.next().html("*");
	gnumber.next().html("*");
	pprice.next().html("*");
	/*
	 * 验证
	 * 失焦\获焦
	 * jquery的方法传递
	 */
	gcode.on("blur",function(){
		if(gcode.val() != null && gcode.val() != ""){
			validateTip(gcode.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(gcode.next(),{"color":"red"},imgNo+" 编码不能为空，请重新输入",false);
		}
	}).on("focus",function(){
		//显示友情提示
		validateTip(gcode.next(),{"color":"#666666"},"* 请输入订单编码",false);
	}).focus();
	
	gname.on("blur",function(){
		if(gname.val() != null && gname.val() != ""){
			validateTip(gname.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(gname.next(),{"color":"red"},imgNo+" 商品名称不能为空，请重新输入",false);
		}
	}).on("focus",function(){
		//显示友情提示
		validateTip(gname.next(),{"color":"#666666"},"* 请输入商品名称",false);
	}).focus();
	
	gnumber.on("blur",function(){
		if(gnumber.val() != null && gnumber.val() != ""){
			validateTip(gnumber.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(gnumber.next(),{"color":"red"},imgNo+"数量不能为空，请重新输入",false);
		}
	}).on("focus",function(){
		//显示友情提示
		validateTip(gnumber.next(),{"color":"#666666"},"* 请输入商品数量",false);
	}).focus();
	
	
	
	pprice.on("focus",function(){
		validateTip(pprice.next(),{"color":"#666666"},"* 请输入大于0的正自然数，小数点后保留2位",false);
	}).on("keyup",function(){
		this.value = priceReg(this.value);
	}).on("blur",function(){
		this.value = priceReg(this.value);
	});
	
	addBtn.on("click",function(){
		if(gcode.attr("validateStatus") != "true"){
			gcode.blur();
		}else if(gname.attr("validateStatus") != "true"){
			gname.blur();
		}else if(gnumber.attr("validateStatus") != "true"){
			gnumber.blur();
		}else{
			if(confirm("是否确认提交数据")){
				$("#goodsForm").submit();
			}
		}
	});
	
	backBtn.on("click",function(){
		history.go(-1);
	});
});