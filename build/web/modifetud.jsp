<%-- 
    Document   : ajoutetud
    Created on : 5 janv. 2025, 23:07:56
    Author     : 21655
--%>

<%@page import="model.Etudiants"%>
<%@page import="controller.JPAService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   
    Integer id = Integer.parseInt(request.getParameter("id"));
    String nom = (String)request.getParameter("nom");
    String prenom = (String) request.getParameter("prenom");


    String msg = (String ) request.getAttribute("msg");
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <form method="POST" action="modifetud">
        <fieldset>
               <legend>Modifier etudiant</legend>
                <input type="text"  name="id" value="<%=id%>" placeholder="Enter id" />
                <br>
                <input type="text"  name="nom"  value="<%=nom%>" "placeholder="Enter nom" />
                <br>
                <input type="text"  name="prenom"  value="<%=prenom%>" placeholder="Enter prenom" />
                <br>
                <input type="submit" value="Modifier">
        </fieldset>
                <%
                    if(msg!=null){
                    out.println(msg);
                    }
                    %>
      </form>
    </body>
</html>
