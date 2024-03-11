

<%@page import="interriorDetails.InteriorDetailsDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            double totalMoney = 0;
            List<InteriorDetailsDTO> list = (List<InteriorDetailsDTO>) request.getAttribute("INTERIOR_BY_PROJECTID");
            if (list != null && !list.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Interior Name</th>
                    <th>Image</th>
                    <th>Description</th>
                    <th>Create At</th>
                    <th>Update At</th>
                    <th>Material Name</th>
                    <th>Size</th>
                    <th>Mass</th>
                    <th>Unit</th>
                    <th>Unit Price</th>
                    <th>Money</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (InteriorDetailsDTO dto : list) {
                %>
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <%= dto.getInteriorName()%>
                    </td>
                    <td>
                        <img src="<%= dto.getImage()%>">
                    </td>
                    <td>
                        <%= dto.getDescription()%>
                    </td>
                    <td>
                        <%= dto.getCreateAt()%>
                    </td>
                    <td>
                        <%= dto.getUpdateAt()%>
                    </td>
                    <td>
                        <%= dto.getMaterialName()%>
                    </td>
                    <td>
                        <%= dto.getSize()%>
                    </td>
                    <td>
                        <%= dto.getMass()%>
                    </td>
                    <td>
                        <%= dto.getUnit()%>
                    </td>
                    <td>
                        <%= dto.getUnitPrice()%>
                    </td>
                    <td>
                        <%
                            double unit = dto.getUnit();
                            double unitprice = dto.getUnitPrice();
                            double money = dto.getUnit() * dto.getUnitPrice();
                            totalMoney += money;
                        %>
                        <%= money%>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <h2>Total: <%= totalMoney%></h2>

<!--        <div class="col-12 text-center">
            <a class="btn btn-primary py-3 px-5" href="">Browse More Property</a>
        </div>-->

        <%
        } else {
        %>
        <h1>this project did not have interior yet!</h1>
        <%
                }
        %>
    </body>
</html>
