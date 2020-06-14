package casillano.service;

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

	@Override
	@Transactional
	public void saveOrUpdateFriend(Friend friend) {
		DAO.saveOrUpdateFriend(friend);

	}

	@Override
	@Transactional
	public void deleteFriend(Friend friend) {
		DAO.deleteFriend(friend);

	}

	@Override
	@Transactional
	public Friend getFriend(int id) {
		return DAO.getFriend(id);
	}

}
