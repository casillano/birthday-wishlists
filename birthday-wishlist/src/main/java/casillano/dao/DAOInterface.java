package casillano.dao;

import casillano.entity.Friend;

public interface DAOInterface {
	
	public void saveOrUpdateFriend(Friend friend);
	public void deleteFriend(Friend friend);
	public Friend getFriend(int id);
}
