<%@page import="models.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerlogin" class="controllers.ControllerLogin" scope="request"/>

<%
controllerlogin.setSession(session);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Doctor doc = (Doctor)session.getAttribute("DOCTOR");
        %>
        <h1>Bienvenido</h1>
        <h2 style="color:green">
            Doctor: <%=doc.getApellido()%>, <%=doc.getEspecialidad()%>
        </h2>
        <img src="../images/ok2.jpg" alt="" style="width:400px; height: 250px;"/>
        <a class="btn btn-outline-danger" href="usuariodoctor.jsp?cerrar=1">Cerrar sesión</a>
        <%
        String cerrar = request.getParameter("cerrar");
        if (cerrar != null){
            controllerlogin.cerrarSesion();
            response.sendRedirect("../index.jsp");
        }
        %>

    </body>
    
</html>
