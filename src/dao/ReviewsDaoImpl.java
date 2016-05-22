package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dto.Reviews;
import util.ConnectionUtil;

public class ReviewsDaoImpl implements ReviewsDao
{
	PreparedStatement pst1,pst2;
	public ReviewsDaoImpl()
	{
		try
		{
			pst1 = ConnectionUtil.getConn().prepareStatement("select * from reviews where isbn = ?");
			pst2 = ConnectionUtil.getConn().prepareStatement("insert into reviews values(?,?)");
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Reviews> listReviews(int isbn)
	{
		List<Reviews> reveiwList = new ArrayList<>();
		try
		{
			pst1.setInt(1, isbn);
			ResultSet rst = pst1.executeQuery();
			if (rst.isBeforeFirst())
			{
				while (rst.next())
				{
					reveiwList.add(new Reviews(rst.getInt(1), rst.getString(2)));
				}
				return reveiwList;
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
	public boolean addReview(int isbn,String review)
	{
		try
		{
			pst2.setInt(1,isbn);
			pst2.setString(2, review);
			if(pst2.executeUpdate()==1)
				return true;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return false;
	}
	
	
}

