var SaleObj;
function deleteSale(obj){
	$.ajax({
		type:"GET",
		url:path+"/sale/deletesalebyid/"+obj.attr("saleid"),
		dataType:"json",
		success:function(data){
			//alert(data.delResult);
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//删除失败
	
				changeDLGContent("对不起，删除订单失败");
			}else if(data.delResult == "notexist"){
				changeDLGContent("对不起，订单不存在");
			}
		},
		error:function(data){
			alert("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeBi').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeBi').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}
		
    //显示订单信息
	$(".viewSale").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		window.location.href=path+"/sale/view/"+ obj.attr("saleid");
	});
	
	$(".modifySale").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/sale/updatesale/"+ obj.attr("saleid");
	});
	
	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteSale(SaleObj);
	});

	$(".deleteSale").on("click",function(){
		SaleObj = $(this);
		changeDLGContent("你确定要删除吗？");
		openYesOrNoDLG();
	});
