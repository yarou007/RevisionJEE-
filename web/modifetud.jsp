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
   
    Integer id = Integer.parseInt(request.getParameter("id")); /// liste etudiant a la premeire fois 
    
    String nom = (String)request.getParameter("nom"); // null 
    String prenom = (String) request.getParameter("prenom"); // null 


    String msg = (String ) request.getAttribute("msg"); // Modif avec suucés
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
