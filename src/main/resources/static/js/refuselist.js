var RefuseObj;

function deleteRefuse(obj){
	$.ajax({
		type:"GET",
		url:path+"/refuse/deleterefusebyid/"+obj.attr("refid"),
		dataType:"json",
		success:function(data){
			//alert(data.delResult);
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}
		},
		error:function(data){
			alert("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeRef').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeRef').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}
		
    //显示订单信息
	$(".viewRefuse").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		window.location.href=path+"/refuse/view/"+ obj.attr("refid");
	});
	
	$(".modifyRefuse").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/refuse/updaterefuse/"+ obj.attr("refid");
	});
	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteRefuse(RefuseObj);
	});

	$(".deleteRefuse").on("click",function(){
		RefuseObj = $(this);
		changeDLGContent("你确定要删除退货单【"+RefuseObj.attr("refName")+"】吗？");
		openYesOrNoDLG();
	});

