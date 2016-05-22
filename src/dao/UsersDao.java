package dao;

public interface UsersDao
{
	public boolean authenticateUser(String username,String password);
	public String roleOfUser(String username);
}
