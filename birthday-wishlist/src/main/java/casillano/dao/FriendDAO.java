package casillano.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import casillano.entity.Friend;

// The data access object that handles CRUD functionality 
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
		Friend friend = session.get(Friend.class, id);
		session.delete(friend);
	}

	@Override
	public Friend getFriend(int id) {
		Session session = sessionFactory.getCurrentSession();
		Friend friend = session.get(Friend.class, id);
		return friend;
	}
	
	// return all of the friends in the database, ordered by birthday
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
		
		// check if search is contained in a friend's name, and return all
		// friends that match
		
		if (search != null && search.trim().length() > 0) {
			// set all characters to lowercase to make searching case-insensitive
			query= session.createQuery("from Friend where lower(name) like :name", Friend.class);
			query.setParameter("name", "%" + search.toLowerCase() + "%");
		} else {
			query = session.createQuery("from Friend", Friend.class);
		}
		
		List<Friend> customers = query.getResultList();
		return customers;
	}
	
}
