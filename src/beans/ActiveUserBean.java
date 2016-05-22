package beans;

import listeners.SessionListener;

public class ActiveUserBean
{
	private int activeUsers;

	/**
	 * @return the activeUsers
	 */
	public int getActiveUsers()
	{
		return SessionListener.getActiveUsers();
	}
	
}
