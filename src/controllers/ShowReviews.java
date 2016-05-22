package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ReviewsBean;
import dto.Reviews;

/**
 * Servlet implementation class ShowReviews
 */
@WebServlet("/ShowReviews")
public class ShowReviews extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowReviews()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		ReviewsBean rb = new ReviewsBean();
		try
		{
		
		rb.setIsbn(Integer.valueOf(request.getParameter("isbn")));
		if(request.getParameter("submit").equals("Click to View Reviews"))
		{
			rb.setIsbn(Integer.valueOf(request.getParameter("isbn")));
			List<Reviews> listReviews = rb.showReviews();
			if(listReviews != null)
			{
				request.setAttribute("bookName", request.getParameter("bookName"));
				request.setAttribute("listReviews", listReviews);
				rd = request.getRequestDispatcher("/WEB-INF/views/showreviews.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("message", "No Reviews Found");
				rd = request.getRequestDispatcher("/WEB-INF/views/viewbook.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			request.setAttribute("isbn", request.getParameter("isbn"));
			rd = request.getRequestDispatcher("/WEB-INF/views/addreview.jsp");
			rd.forward(request, response);
		}
		}catch (Exception e)
		{
			request.setAttribute("message", "Please Select a Book");
			rd = request.getRequestDispatcher("/WEB-INF/views/viewbook.jsp");
			rd.forward(request, response);
		}

		
	}
}

