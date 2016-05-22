package beans;

import java.util.List;

import javax.servlet.RequestDispatcher;

import dao.ReviewsDao;
import dao.ReviewsDaoImpl;
import dto.Reviews;

public class ReviewsBean
{
	private int isbn;
	private String review;
	
	/**
	 * @return the isbn
	 */
	public int getIsbn()
	{
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(int isbn)
	{
		this.isbn = isbn;
	}
	/**
	 * @return the review
	 */
	public String getReview()
	{
		return review;
	}
	/**
	 * @param review the review to set
	 */
	public void setReview(String review)
	{
		this.review = review;
	}
	
	public List<Reviews> showReviews()
	{
		System.out.println(isbn);
		ReviewsDao rd = new ReviewsDaoImpl();
		List<Reviews> listReveiw = rd.listReviews(isbn);
		return listReveiw;
	}
	
	public String addReview()
	{
		ReviewsDao rd = new ReviewsDaoImpl();
		if(rd.addReview(isbn, review))
			return "success";
		else
			return "fail";
					
	}
	
}
