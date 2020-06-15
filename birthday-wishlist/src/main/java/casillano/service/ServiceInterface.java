package casillano.service;

import java.util.List;

import casillano.entity.Friend;

public interface ServiceInterface {
	public void saveOrUpdateFriend(Friend friend);
	public void deleteFriend(int id);
	public Friend getFriend(int id);
	public List<Friend> getFriends();
	public List<Friend> searchFriends(String search);
}
