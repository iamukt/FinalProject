package dto;

public class Reviews
{
	private int isbn;
	private String review;
	
	public Reviews()
	{
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param isbn
	 * @param review
	 */
	public Reviews(int isbn, String review)
	{
		super();
		this.isbn = isbn;
		this.review = review;
	}
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
	
	
}
