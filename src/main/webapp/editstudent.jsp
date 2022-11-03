<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
	<title>CourseManagementSystem</title>
</head>
<body bgcolor="#D9DFAA">
	<s:set var="student" value="#request.stu"></s:set>
	<!--上传文件时要加入黑体部分-->
	<s:form action="updateStudent" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>ID:</td>
			<td>
				<input type="text" name="student.sid" value="<s:property value="#student.sid"/>" readOnly/>
			</td>
		</tr>
		<tr>
			<td>Name:</td>
			<td>
				<input type="text" name="student.name" value="<s:property value="#student.name"/>" />
			</td>
		</tr>
		<tr>
			<s:radio list="#{1:'female',0:'male'}" value="#student.gender" label="Gender" name="student.gender"></s:radio>
		</tr>
		<tr>
			<td>Major:</td>
			<td>
				<!--遍历出专业的信息-->
				<select name="major.mid">
					<s:iterator var="major1" value="#request.majors">
						<option value="<s:property value="#major1.mid"/>">
							<s:property value="#major1.majorname"/>
						</option>
					</s:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<td>Birthday:</td>
			<td>
				<input type="text" name="student.birthday" value="<s:property value="#student.birthday"/>"/>
			</td>
		</tr>
		<tr>
			<td>Remarks:</td>
			<td>
				<input type="text" name="student.remarks" value="<s:property value="#student.remarks"/>" />
			</td>
		</tr>
		<tr>
			<td>Credit:</td>
			<td>
				<input type="text" name="student.credit" value="<s:property value="#student.credit"/>" />
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="Edit"/></td>
		</tr>
	</table>
	</s:form>
</body>
</html>