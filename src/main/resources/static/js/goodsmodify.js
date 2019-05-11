var gcode = null;
var gname = null;
var gnumber = null;
var pprice = null;
var saveBtn = null;
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
	gcode = $("#gcode");
	gname = $("#gname");
	gnumber = $("#gnumber");
	pprice = $("#pprice");
	saveBtn = $("#save");
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

	gname.on("focus",function(){
		validateTip(gname.next(),{"color":"#666666"},"* 请输入要存入商品名称",false);
	}).on("blur",function(){
		if(gname.val() != null && gname.val() != ""){
			validateTip(gname.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(gname.next(),{"color":"red"},imgNo+" 名称不能为空，请重新输入",false);
		}

	});

	gnumber.on("focus",function(){
		validateTip(gnumber.next(),{"color":"#666666"},"* 请输入数量",false);
	}).on("blur",function(){
		if(gnumber.val() != null && gnumber.val() != "" && gnumber.val() != 0){
			validateTip(gnumber.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(gnumber.next(),{"color":"red"},imgNo+" 数量不能为0或者不填",false);
		}

	});
	pprice.on("focus",function(){
		validateTip(pprice.next(),{"color":"#666666"},"* 请输入大于0的正自然数，小数点后保留2位",false);
	}).on("keyup",function(){
		this.value = priceReg(this.value);
	}).on("blur",function(){
		this.value = priceReg(this.value);
	});

	saveBtn.on("click",function(){
		gname.blur();
		gnumber.blur();
		if(gname.attr("validateStatus") == "true" 
			&& gnumber.attr("validateStatus") == "true"){
			if(confirm("是否确认提交数据")){
				$("#goodsForm").submit();
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