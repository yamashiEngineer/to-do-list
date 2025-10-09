<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList, java.util.List" %>
<html>
<head>
  <title>Todoリスト</title>

</head>
<body>
  <h1>Todoリスト</h1>

  <form action="add" method="post">
    <input type="text" name="task" required>
    <button type="submit">追加</button>
  </form>

  <h2>Todoリストの表示</h2>
  <ul>
    <%
      List<String> todos = (List<String>)session.getAttribute("todos");
      if(todos == null){
        todos = new ArrayList<>();
        session.setAttribute("todos", todos);
      }
      for(String task: todos){
    %>

    <li><%= task %> <a href="delete?task=<%= task %>">削除</a></li>
    <%
      }
    %>
  </ul>
</body>  
</html>