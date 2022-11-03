<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>学生选课系统</title>
</head>
<body bgcolor="#D9DFAA">
	<table width="400">
		<s:set value="#request.stu" var="stu"/>
		<tr>
			<td>学号：</td>
			<td><s:property value="#stu.sid"/></td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td><s:property value="#stu.name"/></td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>
				<s:if test="#stu.gender==1">Female</s:if>
				<s:else>Male</s:else>
			</td>
		</tr>
		<tr>
			<td>专业：</td>
			<td><s:property value="#stu.major.majorname"/></td>
		</tr>
		<tr>
			<td>出生时间：</td>
			<td><s:property value="#stu.birthday"/></td>
		</tr>
		<tr>
			<td>总学分：</td>
			<td><s:property value="#stu.credit"/></td>
		</tr>
		<tr>
			<td>备注：</td>
			<td><s:property value="#stu.remarks"/></td>
		</tr>
	</table>
</body>
</html>