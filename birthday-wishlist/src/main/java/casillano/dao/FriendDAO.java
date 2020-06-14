package casillano.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import casillano.entity.Friend;

@Repository
public class FriendDAO implements DAOInterface {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveOrUpdateFriend(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(friend);
	}

	@Override
	public void deleteFriend(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(friend);
	}

	@Override
	public Friend getFriend(int id) {
		Session session = sessionFactory.getCurrentSession();
		Friend friend = session.get(Friend.class, id);
		return friend;
	}
	
}
