package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Books;
import util.ConnectionUtil;

public class BookDaoImpl implements BookDao
{
	PreparedStatement pst1, pst2,pst3,pst4;
	public BookDaoImpl()
	{
		try
		{
			pst1 = ConnectionUtil.getConn().prepareStatement(
					"insert into books (bookname,author,location) values (?,?,?)");
			pst2 = ConnectionUtil.getConn().prepareStatement(
					"select * from books where bookname like ?");
			pst3 = ConnectionUtil.getConn().prepareStatement("delete from books where isbn=?");
			pst4 = ConnectionUtil.getConn().prepareStatement("delete from reviews where isbn=?");
		
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Override
	public boolean addBook(String bookName, String author, String location)
	{

		try
		{
			pst1.setString(1, bookName);
			pst1.setString(2, author);
			pst1.setString(3, location);
			if (pst1.executeUpdate() == 1)
				return true;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Books> showBook(String bookName)
	{
		List<Books> bookList = new ArrayList<>();
		try
		{
			pst2.setString(1, "%"+bookName+"%");
			ResultSet rst = pst2.executeQuery();
			if (rst.isBeforeFirst())
			{
				while (rst.next())
				{
					bookList.add(new Books(rst.getString(1), rst.getInt(2),
							rst.getString(3), rst.getString(4)));
				}
				return bookList;
			} else
				return null;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean delBook(int isbn)
	{
		System.out.println("Book Dao Isbn: "+isbn);
		try
		{
			pst3.setInt(1, isbn);
			pst4.setInt(1,isbn);
			pst4.executeUpdate();
			pst3.executeUpdate();
			return true;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
