package com.todo;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Servlet implementation class TodoAdd
 */
@WebServlet("/add")
public class TodoAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String task = request.getParameter("task");

		  List<String> todos = (List<String>)request.getSession().getAttribute("todos");
		  if(todos == null){
		    todos = new ArrayList<>();
		  }

		  todos.add(task);
		  request.getSession().setAttribute("todos", todos);

		  response.sendRedirect("index.jsp");
		}

}
