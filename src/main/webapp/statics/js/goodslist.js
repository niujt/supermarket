var goodsObj;
function deletegoods(obj){
	$.ajax({
		type:"GET",
		url:path+"/goods/deletegoodsbyid/"+obj.attr("gid"),
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//删除失败
				changeDLGContent("对不起，删除商品失败");
			}else if(data.delResult == "notexist"){
				changeDLGContent("对不起，商品不存在");
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

		
    //显示库存信息
	$(".viewGoods").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		window.location.href=path+"/goods/view/"+ obj.attr("gid");
	});
	
	$(".modifyGoods").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/goods/updategoods/"+ obj.attr("gid");
	});
	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deletegoods(goodsObj);
	});

	$(".deleteGoods").on("click",function(){
		goodsObj = $(this);
		changeDLGContent("确定要删除该信息么");
		openYesOrNoDLG();
	});
