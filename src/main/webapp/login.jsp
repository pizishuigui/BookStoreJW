<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


    <title>bookStore列表</title>
    <%--导入css --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css"/>
    <script src="js/angular.min.js"></script>
    <!--导入jquery-->
    <script src="js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            $("#submit").click(function () {

                //2.发送ajax请求，提交表单数据
                $.post("userServlet/login",$("#loginForm").serialize(),function (data) {
                    //data : {flag:false,errorMsg:''}
                    if(data.flag){
                        //登录成功
                        location.href="${pageContext.request.contextPath }/product_list.jsp";
                    }else{
                        //登录失败
                        $("#errorMsg").innerHTML(data.errorMsg)

                    }
                });
            });
        });

    </script>
</head>

<body class="main">

<jsp:include page="head.jsp"/>
<jsp:include page="menu_search.jsp"/>

<div id="divpagecontent">
    <div width="100%" border="0" cellspacing="0">
        <div>

            <div>
                <div style="text-align:right; margin:5px 10px 5px 0px">
                    <a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
                </div>

            </div>
        </div>
        <div style="background-color: #5CA5D6">
        <table border="1px" width="50%">
            <div id="errorMsg" class="alert alert-danger" ></div>
            <form id="loginForm" action="" method="post" accept-charset="utf-8">
                <tr align="center">
                    <td style="border-color: #5CA5D6;height: 40px"><label style="font-weight:bold;" >用户名:</label></td>
                    <td><input type="text" name="username" ><br></td>
                </tr>
                <tr align="center">
                    <td style="border-color: #5CA5D6"><label style="font-weight:bold;" >密码</label></td>
                    <td> <input type="password" name="password"></td>
                </tr>
               <tr>
                   <td colspan="2"><input type="submit" value="提交查询" id="submit"></td>
               </tr>



            </form>
        </table>
    </div>
    </div>

</div>


</body>
</html>
