package beans;

import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import dao.BookDaoImpl;
import dto.Books;

public class BooksBean
{
	private String bookName;
	private int isbn;
	private String author;
	private String location;
	private String addBooks;
	/**
	 * @return the bookName
	 */

	
	public String getBookName()
	{
		return bookName;
	}
	/**
	 * @param bookName
	 *            the bookName to set
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
	 * @param isbn
	 *            the isbn to set
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
	 * @param author
	 *            the author to set
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
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location)
	{
		this.location = location;
	}
	/**
	 * @return the addBooks
	 */
	public String getAddBooks()
	{

		BookDao bd = new BookDaoImpl();
		if (bd.addBook(bookName, author, location))
			return "success";
		return "error";
	}

	public List<Books> showBooks(String bookName)
	{
		BookDao bd = new BookDaoImpl();
		List<Books> l1 = new ArrayList<>();
		if ((l1=bd.showBook(bookName)) != null)
			return l1;
		return l1;
	}
	
	public String delBook()
	{
		if(new BookDaoImpl().delBook(isbn))
			return "success";
		else
			return "fail";
	}
}
