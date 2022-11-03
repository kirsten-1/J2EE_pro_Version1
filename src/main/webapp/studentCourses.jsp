<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>学生选课系统</title>
</head>
<body bgcolor="#D9DFAA">
	<table width="400" border=1>
	<caption>Your Course Information：</caption>
		<tr>
			<th>Course ID</th><th>Course Name</th><th>Semester</th><th>Student Num</th><th>Credit</th><th>Operation</th>
		</tr>
		<s:iterator value="#request.courses" var="course">
		<tr>
			<td align="center"><s:property value="#course.cid"/></td>
			<td align="center"><s:property value="#course.name"/></td>
			<td align="center"><s:property value="#course.semester"/></td>
			<td align="center"><s:property value="#course.stunum"/></td>
			<td align="center"><s:property value="#course.credit"/></td>
			<td align="center">
				<!--退选该课程，这里用 JavaScript 来确定是否退选-->
				<a href="deleteCourse.action?course.cid=<s:property value="#course.cid"/>"
				onClick="if(!confirm('Confirm deletion？'))return false;else return true;">
				quit</a>
			</td>
		</tr>
		</s:iterator>
	</table>
</body>
</html>