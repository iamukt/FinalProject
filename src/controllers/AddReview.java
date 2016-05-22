package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ReviewsBean;

/**
 * Servlet implementation class AddReview
 */
@WebServlet("/AddReview")
public class AddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		try
		{
			
			ReviewsBean rb = new ReviewsBean();
			if(request.getParameter("review").equals(""))
			{
				request.setAttribute("message", "Review Cannot be blank");	
				rd=request.getRequestDispatcher("/WEB-INF/views/addreview.jsp");
				rd.forward(request, response);
			}
			rb.setIsbn(Integer.valueOf(request.getParameter("isbn")));
			rb.setReview(request.getParameter("review"));
			if(rb.addReview().equals("success"))
			{
				request.setAttribute("message", "Review Added Successfully");	
				rd=request.getRequestDispatcher("/WEB-INF/views/addreview.jsp");
				rd.forward(request, response);
			}
		else
		{
			request.setAttribute("message", "Some Error Occured While Adding");	
			rd=request.getRequestDispatcher("/WEB-INF/views/addreview.jsp");
			rd.forward(request, response);
		}
		}catch(Exception e)
		{
			request.setAttribute("message", "Some Error Occured While Adding");	
			rd=request.getRequestDispatcher("/WEB-INF/views/viewbook.jsp");
			rd.forward(request, response);
		}
	}

}
