<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title>Vulnerable JSP</title>
        <script type="text/javascript">
            function logCall(value) {
                console.log(value);
            }
        </script>
    </head>
    <body>
        <p>This is a test JSP that contains one or more vulnerabilities.</p>
        <p>Don't <a href="#" onclick="logCall('${e:forJavaScript(param.value)}');">click this link</a>.</p>
    </body>
</html>
