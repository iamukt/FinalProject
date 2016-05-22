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
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookName = request.getParameter("bookname");
		BooksBean bb = new BooksBean();
		List<Books> bookList = bb.showBooks(bookName);
		if(bookList!=null)
		{
			request.setAttribute("bookList", bookList);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/viewbook.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("message", "No Books To Show");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
			rd.forward(request, response);
		}
	}

}
