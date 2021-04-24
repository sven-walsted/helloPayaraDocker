<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ page isErrorPage="true"%>

<html lang="en">

<head>
<meta charset="utf-8">
<title>HTTP Status 500</title>
</head>

<body>

  <div class="ui-widget">

    <div id="content" class="ui-widget-content ui-corner-all">
      <p>HTTP Status 500 - An error inside the HTTP server which
        prevented it from fulfilling the request.</p>

      <p><%=exception.getMessage()%>
        <%=((exception.getCause() != null) ? ": "
                    + exception.getCause().getMessage() : "")%></p>
    </div>

  </div>

</body>
</html>