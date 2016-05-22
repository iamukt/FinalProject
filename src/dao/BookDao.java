package dao;

import java.util.List;

import dto.Books;

public interface BookDao
{
	public boolean addBook(String bookName,String author,String location);
	public List<Books> showBook(String bookName);
	public boolean delBook(int isbn);
}
