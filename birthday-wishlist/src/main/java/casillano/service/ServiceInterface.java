package casillano.service;

import casillano.entity.Friend;

public interface ServiceInterface {
	public void saveOrUpdateFriend(Friend friend);
	public void deleteFriend(Friend friend);
	public Friend getFriend(int id);
}
