package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionUtil;

public class UsersDaoImpl implements UsersDao
{
	PreparedStatement pst1,pst2;
	public UsersDaoImpl() {
		try
		{
			pst1 = ConnectionUtil.getConn().prepareStatement("select * from users where username like ? and password like ?");
			pst2 = ConnectionUtil.getConn().prepareStatement("select role from users where username like ?");
		}
		catch(Exception e)
		{
			
		}
		
	}
	@Override
	public boolean authenticateUser(String username, String password) 
	{
		try 
		{
			pst1.setString(1, username);
			pst1.setString(2, password);
			ResultSet rst = pst1.executeQuery();
			if(rst.isBeforeFirst())
			{
				
				return true;
			}
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public String roleOfUser(String username) {	
		try 
		{
			pst2.setString(1, username);
			ResultSet rst = pst2.executeQuery();
			if(rst.isBeforeFirst())
			{
				rst.next();
				return rst.getString(1);
			}
			else
				return "nothing";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "nothing";
	}
}
