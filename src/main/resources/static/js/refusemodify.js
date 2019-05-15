var refName = null;
var refCode = null;
var refReasion = null;
var refnumber;
var saveBtn = null;
var backBtn = null;

$(function(){
	refName = $("#refName");
	refCode = $("#refCode");
	refReasion = $("#refReasion");
	refnumber=$("#refnumber");
	saveBtn = $("#save");
	backBtn = $("#back");
	refName.next().html("*");
	refnumber.next().html("*");
	refReasion.next().html("*");
	refCode.next().html("*");
	
	
	refName.on("blur",function(){
		if(refName.val() != null && refName.val()!=""){
			validateTip(refName.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(refName.next(),{"color":"red"},imgNo+" 请重新输入退货商品名称",false);
		}
		
	});
	
	
	refReasion.on("blur",function(){
		if(refReasion.val() != null && refReasion.val() != ""){
			validateTip(refReasion.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(refReasion.next(),{"color":"red"},imgNo + " 请重新输入退货理由",false);
		}
	});
	
	

	refnumber.on("blur",function(){
		if(refnumber.val() != null && refnumber.val() != ""){
			validateTip(refnumber.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(refnumber.next(),{"color":"red"},imgNo + " 请重新输入退货数量",false);
		}
	});
	
	saveBtn.on("click",function(){
		if(refName.attr("validateStatus") == "true" 
			&& refReasion.attr("validateStatus") == "true"&&refnumber.attr("validateStatus")=="true"){
			if(confirm("是否确认要提交数据？")){
				$("#refuseForm").submit();
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