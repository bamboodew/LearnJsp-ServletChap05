<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post"> <!-- 第4步：action——引导至xml的login。并执行LoginServlet的dopost方法。 -->
		<table>
			<tr>
				<th colspan="2">用户登录</th>  <!-- 标题 -->
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" id="userName" name="userName" value="${userName }"/></td>  <!-- 从文本框输入 -->
				<!-- 第1步：登陆界面输入用户名 -->
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id="password" name="password" value="${password }"/></td>
				<!-- 第2步：登陆界面输入密码 -->
			</tr>
			<tr>
				<td><input type="submit" value="登录" /></td>
				<!-- 第3步：点击登录 -->
				<td><font color="red">${error }</font></td>
				<!-- 第22步：响应结果——显示error对应的对象object。——完结！ -->
			</tr>
		</table>
	</form>
</body>
</html>