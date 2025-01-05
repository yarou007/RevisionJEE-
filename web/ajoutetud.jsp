<%-- 
    Document   : ajoutetud
    Created on : 5 janv. 2025, 23:07:56
    Author     : 21655
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String msg = (String) request.getAttribute("msg");
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (msg!=null){
          %>
          <%=msg%>
             <%
            } else {
        %>
           <% out.println("Saisie les informations "); %>
           
        <%
            }
            %>
      <form method="POST" action="ajoutetud">
        <fieldset>
               <legend>Ajouter etudiant</legend>
                <input type="text"  name="id"  placeholder="Enter id" />
                <br>
                <input type="text"  name="nom"  placeholder="Enter nom" />
                <br>
                <input type="text"  name="prenom"  placeholder="Enter prenom" />
                <br>
                <input type="submit" value="Connexion">
        </fieldset>
          
          
    </body>
</html>
