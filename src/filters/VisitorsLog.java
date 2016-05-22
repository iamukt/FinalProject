package filters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UsersBean;




/**
 * Servlet Filter implementation class VisitorsLog
 */
@WebFilter("/Home")
public class VisitorsLog implements Filter {

    /**
     * Default constructor. 
     */
    public VisitorsLog() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		UsersBean ub = new UsersBean();
		ub.setUsername(request.getParameter("username"));
		ub.setPassword(request.getParameter("password"));
		try
		{
			if(ub.authenticateUser().equals("success"))
			{
				PrintWriter pw = new PrintWriter
						(new FileOutputStream(new File("log.txt"),true));
				pw.println("");
				pw.print(request.getParameter("username"));
				pw.print(" logged at ");
				pw.print(new Date().toString());
				pw.flush();
				chain.doFilter(request, response);
			}
			else
			{
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpRequest.setAttribute("message", "UserName or Password is wrong please try again");
				RequestDispatcher rd = httpRequest.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);	
			}
		}catch(Exception e)
		{
		
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
