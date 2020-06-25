package casillano.entity;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

// The friend entity used for ORM.

@Entity
@Table(name="friend")
public class Friend {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	// all fields below are set using a form, so there
	// must be checks to ensure the input is not null
	
	@Column(name="name")
	@NotNull(message="is required")
	private String name;
	
	@NotNull(message="is required")
	@Column(name="birthday")
	private Date birthday;
	
	// add a regex pattern to ensure the input matches the format
	// of a valid wishlist id
	@NotNull(message="is required")
	@Pattern(regexp="^[A-Z0-9]{13}", message="invalid wishlist id")
	@Column(name="wishlist_id")
	private String wishlistId;
	
	@Column(name="amazon_domain")
	@NotNull(message="is required")
	private String amazonDomain;
	
	
	public Friend() {}
	
	
	public Friend(@NotNull(message = "is required") String name, @NotNull(message = "is required") Date birthday,
			@NotNull(message = "is required") @Pattern(regexp = "^[A-Z0-9]{13}", message = "invalid wishlist id") String wishlistId,
			@NotNull(message = "is required") String amazonDomain) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.wishlistId = wishlistId;
		this.amazonDomain = amazonDomain;
	}

	// getters and setters, as well as a toString() 
	
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
		return "Friend [id=" + id + ", name=" + name + ", birthday=" + birthday + ", wishlistId=" + wishlistId + ", amazonDomain=" + amazonDomain + "]";
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
