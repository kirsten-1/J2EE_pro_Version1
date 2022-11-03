<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>简易留言板</title>
</head>
<body bgcolor="#E3E3E3">
<s:form action="main" method="post">
<table>
	<caption>用户登录</caption>
	<tr>
		<td>
			用户名：<s:textfield name="user.username" size="20"/>
		</td>
	</tr>
	<tr>
		<td>
			密&nbsp;&nbsp;码：<s:password name="user.password" size="21"/>
		</td>
	</tr>
	<tr>
		<td>
			<s:submit value="登录"/>
			<s:reset value="重置"/>
		</td>
	</tr>
</table>
</s:form>
如果没注册单击<a href="">这里</a>注册！
</body>
</html>
