<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMPLAINT FORM</title>
</head>
<body>
 <form action="ComplaintServlet" method="post">
	complaintID : <input type="text" name="CID"/><br/>
	poleID: <input type="text" name="PID"/><br/>
	Comment: <input type="text" name="comment"/><br/>
	userName: <input type="text" name="uname" value=<%= request.getParameter("usern")%> readonly="readonly">
<input type="submit" />
</form>

</body>
</html>