package casillano.entity;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="friend")
public class Friend {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="wishlist_id")
	private String wishlistId;
	
	@Column(name="amazon_domain")
	private String amazonDomain;

	public String getAmazonDomain() {
		return amazonDomain;
	}

	public void setAmazonDomain(String amazonDomain) {
		this.amazonDomain = amazonDomain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
	
}
