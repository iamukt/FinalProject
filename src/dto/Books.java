package dto;

/**
 * @author umesht
 *
 */
public class Books
{
	private String bookName;
	private int isbn;
	private String author;
	private String location;
	
	public Books()
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param bookName
	 * @param isbn
	 * @param author
	 * @param location
	 */
	public Books(String bookName, int isbn, String author, String location)
	{
		super();
		this.bookName = bookName;
		this.isbn = isbn;
		this.author = author;
		this.location = location;
	}
	
	/**
	 * @return the bookName
	 */
	public String getBookName()
	{
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName)
	{
		this.bookName = bookName;
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
	 * @return the author
	 */
	public String getAuthor()
	{
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}
	/**
	 * @return the location
	 */
	public String getLocation()
	{
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location)
	{
		this.location = location;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Books [bookName=" + bookName + ", isbn=" + isbn + ", author="
				+ author + ", location=" + location + "]";
	}
}
