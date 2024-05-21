<%-- 
    Document   : ManageStudent
    Created on : May 10, 2024, 8:32:07 PM
    Author     : TNO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="MainController" method="GET">
            <select name="searchOption">
                <option value="1"> search By Name</option>
                <option value="2">search By BirthDate</option>


            </select>
            <input type="text" name="inputSearch" value="" />



            <input type="submit" name="action" value="search" /> 

        </form>
        <form action="MainController" method="POST">
            <table border="">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th><input type="text" name="name" value="${student.name}" /></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>BirtDate</td>
                        <td><input type="date" name="dob" value="${student.dob}" /></td>
                    </tr>
                    <tr>
                        <td>Adrress:</td>
                        <td><input type="text" name="address" value="${student.adress}" /></td>
                    </tr>
                    <tr>
                        <td>Course:</td>
                        <td>
                            <input type="checkbox" name="course1" value="Office" />Office
                            <input type="checkbox" name="course2" value="Web design" /> Web design
                            <input type="checkbox" name="course3" value="Java" />Java
                            <input style="display: none" type="text" name="numOfCourse" value="3" />

                        </td>
                    </tr>
                    <tr>
                        <td>Teching qualaty:</td>
                        <td>
                            <input type="radio" ${student.teachingQuality eq 'Very good' ? 'checked' : ""} name="teachingQualaty" value="Very good"/> Very good
                            <input type="radio" ${student.teachingQuality eq 'Good' ? 'checked' : ""} name="teachingQualaty" value="Good" />Good
                            <input type="radio"  ${student.teachingQuality eq 'Medium' ? 'checked' : ""} name="teachingQualaty" value="Medium" />Medium
                            <input type="radio" ${student.teachingQuality eq 'Not good' ? 'checked' : ""} name="teachingQualaty" value="Not good" /> Not good
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input style="display: none" type="text" name="action" value="add" /></td>
                <input type="submit" value="SEND" /></td>
                <td>
                    <input type="reset" value="RESET" />
                </td>
                </tr>                        
                </tbody>
            </table>
        </form>

        <div>Information:</div>
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Birddate</th>
                    <th>Address</th>
                    <th>Course</th>
                    <th>Teaching qualaty</th>
                    <th>Action</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${list}" var="list">  
                <form action="MainController" method="POST">
                    <tr>

                        <td><input type="text" name="name" value="${list.name}" /></td>
                        <td><input type="text" name="dob" value="${list.dob}" /></td>
                        <td><input type="text" name="address" value="${list.adress}" /></td>
                        <td>${list.course}</td>
                        <td><input type="text" name="teachingQuality" value="${list.teachingQuality}" /></td> 
                        <td>
                            <a href="MainController?action=delete&id=${list.id}" >Delete</a>
                            <input style="display: none "type="text" name="action" value="update" />
                            <input style="display: none "type="text" name="idUser" value="${list.id}" />
                            <input type="submit" value="UPDATE" />
                            <a href="MainController?action=fillInfor&id=${list.id}" >Fill infor</a>
                        </td> 
                    </tr>
                </form>
            </c:forEach>
        </tbody>

    </table>

</body>
</html>
