package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BooksBean;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BooksBean bb = new BooksBean();
		String bookName = request.getParameter("bookname");
		String author = request.getParameter("author");
		String location = request.getParameter("location");
		bb.setBookName(bookName);
		bb.setAuthor(author);
		bb.setLocation(location);
		request.setAttribute("bookDetails", bb);
		request.setAttribute("message", " Added");
		if(bb.getAddBooks().equals("success"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/add.jsp");
			rd.forward(request,response);
		}
		else
		{
			request.setAttribute("message", "Book already Exist ");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/add.jsp");
			rd.forward(request,response);
			
		}
	}

}
