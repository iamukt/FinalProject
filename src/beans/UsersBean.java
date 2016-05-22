package beans;

import javax.servlet.http.HttpSession;

import dao.UsersDao;
import dao.UsersDaoImpl;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class UsersBean
{
	private String name;
	private String username;
	private String password;
	private String role;
	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	/**
	 * @return the role
	 */
	public String getRole()
	{
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role)
	{
		this.role = role;
	}

	public String authenticateUser()
	{
		UsersDao ud = new UsersDaoImpl();
		if(ud.authenticateUser(username, password))
			return "success";
		else
			return "fail";
	}
	
	public String roleOfUser()
	{
		UsersDao ud = new UsersDaoImpl();
		return ud.roleOfUser(username);
	}
}
