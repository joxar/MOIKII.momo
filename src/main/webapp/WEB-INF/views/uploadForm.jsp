<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form
  action="${pageContext.request.contextPath}/article/upload" method="post"
  modelAttribute="fileUploadForm" enctype="multipart/form-data"> <!-- (1) (2) -->
  <table>
    <tr>
      <th width="35%">File to upload</th>
      <td width="65%">
        <form:input type="file" path="file" /> <!-- (3) -->
        <form:errors path="file" />
      </td>
    </tr>
    <tr>
      <th width="35%">Description</th>
      <td width="65%">
        <form:input path="description" />
        <form:errors  path="description" />
      </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><form:button>Upload</form:button></td>
    </tr>
  </table>
</form:form>
</body>
</html>