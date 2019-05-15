var peopleName=null;
var peopleAge=null;
var deptid=null;
var salary=null;
var gander=null;
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
	peopleName=$("#peopleName");
	 peopleAge=$("#peopleAge");
	 deptid=$("#deptid");
	 salary=$("#salary");
	 gander=$("#gander");
	saveBtn = $("#save");
	backBtn = $("#back");
	
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	peopleName.next().html("*");
	peopleAge.next().html("*");
	salary.next().html("*");
	
	/*
	 * 验证
	 * 失焦\获焦
	 * jquery的方法传递
	 */
	peopleAge.on("focus",function(){
		validateTip(peopleAge.next(),{"color":"#666666"},"* 请输入年龄",false);
	}).on("blur",function(){
		if(peopleAge.val() != null && peopleAge.val() != ""){
			validateTip(peopleAge.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(peopleAge.next(),{"color":"red"},imgNo+" 年龄不能为空，请重新输入",false);
		}
		
	});
	
	peopleName.on("focus",function(){
		validateTip(peopleName.next(),{"color":"#666666"},"* 请输入姓名",false);
	}).on("blur",function(){
		if(peopleName.val() != null && peopleName.val() != ""){
			validateTip(peopleName.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(peopleName.next(),{"color":"red"},imgNo+" 姓名不能为空，请重新输入",false);
		}
		
	});
	
	salary.on("focus",function(){
		validateTip(salary.next(),{"color":"#666666"},"* 请输入大于0的正自然数，小数点后保留2位",false);
	}).on("keyup",function(){
		this.value = priceReg(this.value);
	}).on("blur",function(){
		this.value = priceReg(this.value);
	});
	
	saveBtn.on("click",function(){
		peopleName.blur();
		peopleAge.blur();
		if(peopleName.attr("validateStatus") == "true" && 
				peopleAge.attr("validateStatus") == "true"){
			if(confirm("是否确认提交数据")){
				$("#peopleForm").submit();
			}
		}
	});
	
	backBtn.on("click",function(){
		//alert("modify: "+referer);
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