<!DOCTYPE html>
<html>
<#assign cortex=JspTaglibs["http://www.dianping.com/neocortex"]>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>后台</title>
<@cortex.css resource="css/base.css"  decorate="true" module="app-cip-platform" />
</head>

<!-- BEGIN BODY -->

<body class="page-404-full-page">

    <div class="row-fluid">
        <div class="span12 page-404">
            <div class="number">404</div>

            <div class="details">

                <h3>No Privilege</h3>
                <p>
                    You do not have this privilege! <br/>
                </p>

            </div>

        </div>
    </div>

<@cortex.jsFramework inline=true />
<@cortex.facadesPlaceHolder />
</body>
<!-- END BODY -->

</html>
