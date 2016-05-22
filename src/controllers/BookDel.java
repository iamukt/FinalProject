package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BooksBean;
import dto.Books;

/**
 * Servlet implementation class BookDel
 */
@WebServlet("/BookDel")
public class BookDel extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookDel()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		BooksBean bb = new BooksBean();
		List<Books> bookList = bb.showBooks(request.getParameter("bookname"));
		if (bookList != null)
		{
			request.setAttribute("booklist", bookList);
			RequestDispatcher rd = request
					.getRequestDispatcher("/WEB-INF/views/confirmdelete.jsp");
			rd.forward(request, response);
		} else
		{
			request.setAttribute("message", "No Book Found with such name");
			RequestDispatcher rd = request
					.getRequestDispatcher("/WEB-INF/views/delete.jsp");
			rd.forward(request, response);
		}
	}
}
