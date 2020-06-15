package casillano.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	public void deleteFriend(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(id);
	}

	@Override
	public Friend getFriend(int id) {
		Session session = sessionFactory.getCurrentSession();
		Friend friend = session.get(Friend.class, id);
		return friend;
	}

	@Override
	public List<Friend> getFriends() {
		Session session = sessionFactory.getCurrentSession();
		Query<Friend> query = session.createQuery("from Friend order by birthday", Friend.class);
		List<Friend> friends = query.getResultList();
		return friends;
	}

	@Override
	public List<Friend> searchFriends(String search) {
		Session session = sessionFactory.getCurrentSession();
		Query<Friend> query = null;
		if (search != null && search.trim().length() > 0) {
			query= session.createQuery("from Friend where lower(name) like :name", Friend.class);
			query.setParameter("name", "%" + search.toLowerCase() + "%");
		} else {
			query = session.createQuery("from Friend", Friend.class);
		}
		
		List<Friend> customers = query.getResultList();
		return customers;
	}
	
}
