package controllers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UsersBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/Home")
public class ValidateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd;
		UsersBean ub = new UsersBean();
		ub.setUsername(request.getParameter("username"));
		ub.setPassword(request.getParameter("password"));
		HttpSession sess = request.getSession();
		sess.setAttribute("user", request.getParameter("username"));
		if (ub.roleOfUser().equals("admin"))
		{
			sess.setAttribute("role", "admin");
			rd = request.getRequestDispatcher("/WEB-INF/views/admin.jsp");
			rd.forward(request, response);
		} else
		{
			sess.setAttribute("role", "user");
			rd = request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
			rd.forward(request, response);
		}
	}
}
