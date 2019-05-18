<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<script type="text/javascript">
    function addHtml(url) {
        layer.open({
            type: 2,
            title: '添加页面',
            closeBtn: 0,
            area: ['800px', '600px'],
            content: [url, 'yes'],
            btn: ['取消'],
            yes: function (index) {
                //事件
                layer.close(index);
            }
        });
    }
</script>
