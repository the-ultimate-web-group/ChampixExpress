package com.champix.clientchampix.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.MalformedJwtException;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JWTManagerTest {
	
	static String id;
	static String issuer;
	static String subject;
	static long expiredAfterMillis;
	static Claims claims;
	
	static long nowMillis;
	static String jwt;
	
	@BeforeClass
	public static void setup() {
		id = "123";
		issuer = "test";
		subject = "This is a test";
		expiredAfterMillis = 31556952000L;
		claims = null;
	}
	
	@Test
	public void test1_create() {
		nowMillis = System.currentTimeMillis();
		jwt = JWTManager.create(id, issuer, subject, expiredAfterMillis);
		System.out.println("jwt = " + jwt);
		assertNotEquals("", jwt);
	}
	
	@Test
	public void test2_decode() {
		claims = JWTManager.decode(jwt);
		System.out.println("claims type = " + claims.getClass().getSimpleName());
		System.out.println("claims.id = " + claims.getId());
		System.out.println("claims.issuer = " + claims.getIssuer());
		System.out.println("claims.subject = " + claims.getSubject());
		System.out.println("claims.expiration = " + claims.getExpiration());
		System.out.println("claims.issuedAt = " + claims.getIssuedAt());
		
		assertEquals(id, claims.getId());
		assertEquals(issuer, claims.getIssuer());
		assertEquals(subject, claims.getSubject());
		assertTrue(claims.getIssuedAt().getTime() - 5 < nowMillis || nowMillis < claims.getIssuedAt().getTime() + 5);
		Date exp = new Date(nowMillis + expiredAfterMillis);
		assertTrue(claims.getExpiration().getTime() - 5 < exp.getTime() || exp.getTime() < claims.getExpiration().getTime() + 5);
		
		try {
			Claims failClaim = JWTManager.decode("123");
			fail("Should have failed by now...");
		} catch (MalformedJwtException e) {
			// Pass the test
		}
	}
	
	@Test
	public void test3_verify() {
		assertTrue(JWTManager.verify(jwt));
		assertFalse(JWTManager.verify("123"));
	}
	
	@Test
	public void test4_getJWTSecretKey() {
		assertTrue(JWTManager.getJWTSecretKey().length() >= 5);
	}
}