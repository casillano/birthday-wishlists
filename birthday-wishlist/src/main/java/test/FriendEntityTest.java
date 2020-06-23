package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;
import casillano.entity.Friend;

public class FriendEntityTest {
	
	 private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	    
	@Test
	public void testFriendFields() throws Throwable {
		Friend friend = new Friend();
		friend.setName("Amy");
		assertEquals("Amy", friend.getName());
		friend.setAmazonDomain("ca");
		assertEquals("ca", friend.getAmazonDomain());
		friend.setWishlistId("L3SM4632HDKAL");
		assertEquals("L3SM4632HDKAL", friend.getWishlistId());
	}
	
	@Test
	public void testUpdateField() throws Throwable {
		Friend friend = new Friend();
		friend.setName("Dom");
		assertEquals("Dom", friend.getName());
		friend.setName("Dominic");
		assertEquals("Dominic", friend.getName());
	}
	
	@Test
	public void testFieldValidationAllNull() {
		Friend friend = new Friend();
		Set<ConstraintViolation<Friend>> violations = validator.validate(friend);
		assertFalse(violations.isEmpty());
	}
	
	@Test
	public void testNameValidation() {
		Friend friend = new Friend();
		Set<ConstraintViolation<Friend>> violations = validator.validate(friend);
		// all four fields are null (not including id), so there should be 4 violations 
		assertEquals(4, violations.size());
		friend.setName("Dom");
		violations = validator.validate(friend);
		assertEquals(3, violations.size());
	}
	
	@Test
	public void testWishlistIdValidation() {
		Friend friend = new Friend();
		// wrong length
		friend.setWishlistId("AMAZON");
		Set<ConstraintViolation<Friend>> violations = validator.validate(friend);
		assertEquals(4, violations.size());
		// invalid characters
		friend.setWishlistId("ABA#$%$43LAKS");
		violations = validator.validate(friend);
		assertEquals(4, violations.size());
		// valid wishlist id according to pattern
		friend.setWishlistId("1H4NZDNEB37IN");
		violations = validator.validate(friend);
		assertEquals(3, violations.size());
	}
	
}
