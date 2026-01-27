<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>SQL Tutorials</title>
    <style>
        .tree-nav { width: 250px; float: left; }
        .content-area { margin-left: 270px; padding: 20px; border: 1px solid #ccc; min-height: 400px; }
        li { margin: 5px 0; }
        a { text-decoration: none; color: #2c3e50; }
        a:hover { color: #e74c3c; }
    </style>
</head>
<body>

    <!-- Tree Navigation -->
    <div class="tree-nav">
        <ul>
            <li>
                <span id="icon-sql4" class="toggle" onclick="toggleNode('sql4')">+</span>
                <span class="topic">UPDATE Statement <span class="badge">Advanced</span></span>
                <ul id="children-sql4" class="hidden">
                    <li><a href="/sqlData/basicUpdate.html" target="contentFrame">Basic UPDATE</a></li>
                    <li><a href="/sqlData/updateWithWhere.html" target="contentFrame">UPDATE with WHERE</a></li>
                </ul>
            </li>
        </ul>
    </div>

    <!-- Content Area -->
    <div class="content-area">
        <iframe name="contentFrame" width="100%" height="500px" frameborder="0"></iframe>
    </div>

    <script>
        function toggleNode(id) {
            const node = document.getElementById(id);
            node.classList.toggle("hidden");
        }
    </script>

</body>
</html>
