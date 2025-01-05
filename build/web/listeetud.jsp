<%-- 
    Document   : listeetud
    Created on : 5 janv. 2025, 14:17:47
    Author     : 21655
--%>

<%@page import="java.util.*"%>
<%@page import="model.Etudiants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
    
        List<Etudiants> list =  (Vector<Etudiants>) request.getAttribute("list");
    //String msg = (String)  request.getAttribute("msg");
        String msg = (String)  request.getAttribute("msg");
  String msg_supp = (String)  request.getAttribute("msg_supp");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Liste etudiants</h1>
        <a href="ajoutetud.jsp" >Ajout d'un nouvel etudiant</a>
        <% 
            if  (list != null){
            %>
        <table border="1">
            <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Modif/Supp</th>

            </tr>
            
            
            <% for (Etudiants e : list){ %> 
               
            <tr>
                <td><%=e.getId()%></td>
                <td><%=e.getNom()%></td>
                <td><%=e.getPrenom()%></td>
                <td><a href="modifetud.jsp?id=<%= e.getId() %>" >Modif</a> / <a href="suppetud?id=<%= e.getId() %>">Suppr</a></td>

            </tr>
            <%  } %>
           </table>
            <%
            } else if (msg!=null) {
            %> 
                 <h2><% out.println(msg); %></h2>
            
            <%
            }
            %>
            
            
            <%
                if (msg_supp!=null && msg==null) out.println(msg_supp);
                %>

    
    </body>
</html>
