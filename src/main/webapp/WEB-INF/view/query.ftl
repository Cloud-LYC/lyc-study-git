<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
<#--<#include "../base/basestyle.ftl"/>-->

    <link href="/static/css/select2.min.css" rel="stylesheet"/>
    <link href="/static/css/daterangepicker.min.css" rel="stylesheet"/>
    <link href="/static/css/dataTables.bootstrap.min.css" rel="stylesheet"/>
<#--<link href="/static/css/bootstrap.min.css" rel="stylesheet"/>-->

    <title>用户成长激励后台</title>
</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed pace-done aside-menu-hidden">
<#--<#include "../base/header.ftl"/>-->
<div class="app-body">
<#--<#include "../base/left.ftl"/>-->
    <!-- Main content -->
<@leftMenu "贡献值流水查询"/>
    <main class="main">
    <#--<#include "../base/breadcrumb.ftl"/>-->
    <@navigation "帮助文档"/>
        <div class="container-fluid">
            <div id="ui-view" style="opacity: 1;">
                <div class="animated fadeIn">
                    <fieldset class="button">
                        <div class="col-lg-3 pull-left" style="margin-top: 10px;margin-bottom: 20px;">
                            <form id="form" action="/document/find/title" method="get">
                                <div class="input-group">
                                    <input class="form-control" name="document_title" type="text" placeholder="文档标题关键字">
                                    <span class="input-group-btn">
                                        <button class="btn btn-info" type="submit" >查询</button>
                                    </span>
                                </div>
                            </form>
                        </div>

                        <form id="form_type" action="/document/find/type" method="get">
                            <div class="form-group row">
                                <div class="col-md-3" style="margin-left: 30px;padding-right: 1px;">
                                    <select name="document_type" class="form-control" style="border-top-width: 1px;margin-top: 10px;">
                                        <option value="0">全部</option>
                                        <option value="1">等级/贡献值</option>
                                        <option value="2">勋章</option>
                                        <option value="3">新手引导</option>
                                        <option value="4">模板中心</option>
                                        <option value="100">其它</option>
                                    </select>
                                </div>

                                <button class="btn btn-info" type="submit" style="margin-top: 10px;margin-bottom: 18px;">查询</button>

                                <div class="col-lg-2 " style="margin-top: 10px; margin-bottom: 20px;">
                                    <div class="pull-right">
                                        <span class="input-group-btn">
                                            <a href="/document/create">
                                                <button type="button" class="btn btn-info">添加新文档
                                                </button>
                                            </a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </form>

                    </fieldset>
                    <fieldset class="form-group">
                        <table id="document-trans" class="table table-striped table-bordered hover" cellspacing="0" width="100%">
                            <thead>
                            <tr><th><div class="row">
                                        <div class="col-lg-1 center-block">ID</div><div class="col-lg-3 center-block">标题</div><div class="col-lg-1 center-block">作者</div><div class="col-lg-2 center-block">更新时间</div><div class="col-lg-2 center-block">类别</div><div class="col-lg-3 center-block">操作</div>
                                    </div></th>
                            </tr>
                            </thead>
                            <tbody>

                            <#if documents ? exists>
                                <#list documents as item>
                                    <tr><td><div class="row"><div class="col-lg-1"> ${item.id} </div><div class="col-lg-3"><span class="span-hover">${item.title}</span></div> <div class="col-lg-1">${item.author}</div> <div class="col-lg-2">${item.updateTime ? string('yyyy-MM-dd HH:mm:ss')} </div><div class="col-lg-2">
                                   <#if item.type == 1>
                                       <span>等级/贡献值</span>
                                    <#elseif item.type == 2>
                                        <span>勋章</span>
                                    <#elseif item.type == 3>
                                       <span>新手引导</span>
                                   <#elseif item.type == 4>
                                       <span>模板中心</span>
                                   <#elseif item.type == 100>
                                       <span>其他</span>
                                   </#if>
                                    </div>
                                    <div class="col-lg-">
                                       <a href="${item.url}">
                                           <button class="btn btn-outline-info" data-toggle="modal" data-target="#myModal${item.id}1">查看</button>
                                       </a>
                                    </div>

                                    <div class="col-lg-1" style=" right: -5; left: 7px;">
                                        <a href="/document/edit?document_id=${item.id}&&author=${item.author}">
                                            <button class="btn btn-outline-warning">编辑</button>
                                        </a>
                                    </div>

                                    <div class="col-lg-1" style="left: -10;">
                                        <button class="btn btn-outline-danger" data-toggle="modal" data-target="#myModal${item.id}3">删除</button>
                                        <!-- 模态框（Modal） -->
                                        <div class="modal fade" id="myModal${item.id}3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-body">文档标题：${item.title}</div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                        <a href="/document/updateStatus?id=${item.id}&&status=0&&author=${item.author}">
                                                            <button type="button" class="btn btn-outline-danger">确认删除</button></a>
                                                    </div>
                                                </div><!-- /.modal-content -->
                                            </div><!-- /.modal -->
                                        </div>

                                    </div>
                                </div></td></tr>
                                </#list>
                            </#if>
                            </tbody>
                        </table>
                    </fieldset>
                </div>
            </div>
        </div>
    </main>
<#--<#include "../base/right.ftl"/>-->

</div>

<#--<#include "../base/foot.ftl"/>-->
<script src="/static/js/moment.min.js"></script>
<script src="/static/js/select2.min.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>

</body>
</html>