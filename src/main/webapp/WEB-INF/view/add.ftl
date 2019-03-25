<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
<#--<#include "../base/basestyle.ftl"/>-->

    <link href="/static/css/select2.min.css" rel="stylesheet"/>
    <link href="/static/css/daterangepicker.min.css" rel="stylesheet"/>
    <link href="/static/css/dataTables.bootstrap.min.css" rel="stylesheet"/>
    <title>用户成长激励后台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no"/>
</head>
<body class="app header-fixed sidebar-fixed aside-menu-fixed pace-done aside-menu-hidden">
<#--<#include "../base/header.ftl"/>-->
<div class="app-body">
<#--<#include "../base/left.ftl"/>-->
    <!-- Main content -->
<@leftMenu "贡献值流水查询"/>
    <main class="main">
    <#--<#include "../base/breadcrumb.ftl"/>-->
    <@navigation "文档创建"/>
        <div class="container-fluid">
            <div id="ui-view" style="opacity: 1;">
                <div class="animated fadeIn" style="margin-top: 50px;
                                                    margin-left: 30px;
                                                    border-top-width: 20px; ">
                    <#if document ? exists>
                        <form id="form" action="/document/edit/submit" method="get">

                            <#--隐藏域-传递文档ID-->
                                <input type="hidden" name="document_id" value="${document.id}">
                            <div class="form-group row">
                                <label class="col-sm-1 col-form-label h6" style="text-align: right" for="display_name">标题:</label>
                                <div class="col-sm-6" style=" padding-left: 5px;">
                                    <input class="form-control" name="document_title" type="text" value="${document.title}">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-1 col-form-label h6" style="text-align: right" for="display_name">链接:</label>
                                <div class="col-sm-6" style=" padding-left: 5px;">
                                    <input class="form-control" name="document_url" type="text" value="${document.url}">
                                </div>
                            </div>

                                <div class="form-group row">
                                    <label class="col-sm-1 col-form-label h6" style="text-align: right" for="display_name">类别:</label>
                                    <div class="col-md-2" style="margin-left: 0px;border-bottom-width: 20px;padding-left: 5px;margin-bottom: 0px;top: -10;">
                                        <select id="select_document_type" name="document_type" class="form-control" style="border-top-width: 1px;margin-top: 10px;">
                                            <option value="100">其它</option>
                                            <option value="1">等级/贡献值</option>
                                            <option value="2">勋章</option>
                                            <option value="3">新手引导</option>
                                            <option value="4">模板中心</option>
                                        </select>
                                    </div>
                                </div>
                            <div class="row" style="margin-left: 200px; margin-top: 20px;">
                                <button class="btn btn-danger" type="reset" style=" border-right-width: 1px; margin-right: 100px; ">取消</button>
                                <button class="btn btn-info" type="submit">确认修改</button>
                            </div>
                        </form>
                        <#else >
                            <form id="form" action="/document/create/add" method="post">
                                <div class="form-group row">
                                    <label class="col-sm-1 col-form-label h6" style="text-align: right" for="display_name">标题:</label>
                                    <div class="col-sm-6" style=" padding-left: 5px;">
                                        <input class="form-control" name="document_title" type="text" placeholder="title">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-1 col-form-label h6" style="text-align: right" for="display_name">链接:</label>
                                    <div class="col-sm-6" style=" padding-left: 5px;">
                                        <input class="form-control" name="document_url" type="text" placeholder="url">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-1 col-form-label h6" style="text-align: right" for="display_name">类别:</label>
                                    <div class="col-md-2" style="margin-left: 0px;border-bottom-width: 20px;padding-left: 5px;margin-bottom: 0px;top: -10;">
                                        <select name="document_type" class="form-control" style="border-top-width: 1px;margin-top: 10px;">
                                            <option value="100">其它</option>
                                            <option value="1">等级/贡献值</option>
                                            <option value="2">勋章</option>
                                            <option value="3">新手引导</option>
                                            <option value="4">模板中心</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row" style="margin-left: 200px; margin-top: 20px;">
                                    <button class="btn btn-danger" type="reset" style=" border-right-width: 1px; margin-right: 100px; ">取消</button>
                                    <button class="btn btn-info" type="submit">保存</button>
                                </div>
                            </form>

                    </#if>
                </div>

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