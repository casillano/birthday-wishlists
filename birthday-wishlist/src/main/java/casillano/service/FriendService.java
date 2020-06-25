package casillano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import casillano.dao.DAOInterface;
import casillano.entity.Friend;

/* Delegates all calls to the DAO. Calls to different DAO's
 * can be made here.
 */

@Service
public class FriendService implements ServiceInterface {

	@Autowired
	private DAOInterface DAO;

	// the methods below wrap the DAO functions using
	// @Transactional so that session transactions are
	// handled by Spring. 
	
	@Override
	@Transactional
	public void saveOrUpdateFriend(Friend friend) {
		DAO.saveOrUpdateFriend(friend);

	}

	@Override
	@Transactional
	public void deleteFriend(int id) {
		DAO.deleteFriend(id);

	}

	@Override
	@Transactional
	public Friend getFriend(int id) {
		return DAO.getFriend(id);
	}

	@Override
	@Transactional
	public List<Friend> getFriends() {
		return DAO.getFriends();
	}

	@Override
	@Transactional
	public List<Friend> searchFriends(String search) {
		return DAO.searchFriends(search);
	}

}
