var peopleObj;

function deletePeople(obj){
	$.ajax({
		type:"GET",
		url:path+"/people/deletepeople/"+obj.attr("peoid"),
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//删除失败
				changeDLGContent("对不起，删除员工【"+obj.attr("peoname")+"】失败");
			}else if(data.delResult == "notexist"){
				changeDLGContent("对不起，员工【"+obj.attr("poename")+"】不存在");
			}
		},
		error:function(data){
			changeDLGContent("对不起，删除失败");
		}
	});
}
function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeProv').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeProv').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}
var querydeptid = $("#querydeptid");
$(function(){
	//查询所有的职位信息
	$.ajax({
		type:"GET",
		url:path+"/dept/deptlist",
		dataType:"json",
		success:function(data){//data：返回数据（json对象）
			if(data.deptlist!= null){
				querydeptid.html("");
				var options = "<option value=\"0\">请选择</option>";
				for(var i = 0; i < data.deptlist.length; i++){
						options += "<option  value=\""+data.deptlist[i].id+"\" >"+data.deptlist[i].dname+"</option>";
				}
				querydeptid.html(options);
			}
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			validateTip(querydeptid.next(),{"color":"red"},imgNo+" 获取职位列表error",false);
		}
	
		
	});	
	/**查看员工信息*/
	$(".viewPeople").on("click",function(){
		var obj=$(this);
		window.location.href=path+"/people/view/"+ obj.attr("peoid");
	});
	/**修改员工信息*/
	$(".modifyPeople").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/people/updatepeople/"+ obj.attr("peoid");
	});
	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deletePeople(peopleObj);
	});
	/**删除该员工*/
	$(".deletePeople").on("click",function(){
		peopleObj = $(this);
		changeDLGContent("你确定要删除该员工【"+peopleObj.attr("peoname")+"】吗？");
		openYesOrNoDLG();
	});
	
});



	

