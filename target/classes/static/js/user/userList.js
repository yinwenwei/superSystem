layui.config({
    base:"../static/"
}).use(['layer','element','table','jquery'],function () {
    var layer = layui.layer,
        element = layui.element,
        table = layui.table,
        $ = layui.jquery;

    table.render({
        elem:'#ytable'
        ,height:'full-100'
        ,url:ctxPath+'user/pageList.do'
        ,page:true
        ,toolbar:true
        ,defaultToolbar:['filter']
        ,cols:[[
            {type:'checkbox'}
            ,{type:'numbers', title: '序号'}
            ,{field: 'name', title: '姓名'}
            ,{field: 'personType', title: '用户类型',templet:function(d){
                    var str = d.personType == 2?'超级管理员':d.personType == 1?'管理员':'普通用户';
                    return str;
                }}
            ,{field: 'orgName', title: '所属部门'}
            ,{field: 'phone', title: '手机号码'}
            ,{field: 'position', title: '职位'}
        ]]
    })


});