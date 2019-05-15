var dcode=null;
var dname=null;
var dnumber=null;
var creationDate=null;
$(function(){
	dcode=$("#dcode");
	dname=$("#dname");
	dnumber=$("#dnumber");
	creationDate=$("#creationDate");
	$.ajax({
		type:"GET",
		url:path+"/dept/finddeptbyname/"+dname.attr("dname"),
		dataType:"json",
		success:function(data){
			dcode.val(date.dept.dcode);
			dcode.val(date.dept.dname);   
			dcode.val(date.dept.dnumber);   
			dcode.val(date.dept.creationDate);   
		},
		error:function(data){
			alert("服务正忙");
		}
	})
})