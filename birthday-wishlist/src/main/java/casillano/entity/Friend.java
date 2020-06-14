package casillano.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person_birthday")
public class Friend {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private int name;
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="wishlistId")
	private String wishlistId;

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(String wishlistId) {
		this.wishlistId = wishlistId;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", birthday=" + birthday + ", wishlistId=" + wishlistId + "]";
	}
	
	
}
