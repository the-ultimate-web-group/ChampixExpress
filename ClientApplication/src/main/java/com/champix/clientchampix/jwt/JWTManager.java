package com.champix.clientchampix.jwt;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.security.Key;
import java.util.Date;

/**
 * Class containing static methods to manage JSON Web Tokens for the application.
 *
 * Source code inspired from https://github.com/oktadeveloper/okta-java-jwt-example/blob/master/src/main/java/com/okta/createverifytokens/JWTDemo.java
 */
public class JWTManager {
	
	/**
	 * Generate a JSON Web Token.
	 * @param id The user's id
	 * @param issuer The issuer
	 * @param subject The subject
	 * @param expiredAfterMillis How many seconds until the JWT expire? If you do not want it to expire, put a negative
	 *                           value.
	 * @return Return a JSON Web Token.
	 */
	public static String create(String id, String issuer, String subject, long expiredAfterMillis) {
		// Signature for JWT
		SignatureAlgorithm signature = SignatureAlgorithm.HS256;
		
		final long nowMillis = System.currentTimeMillis();
		final Date now = new Date(nowMillis);
		
		byte[] key = DatatypeConverter.parseBase64Binary(getJWTSecretKey());
		Key signingKey = new SecretKeySpec(key, signature.getJcaName());
		
		JwtBuilder builder = Jwts.builder()
				.setId(id)
				.setIssuedAt(now)
				.setSubject(subject)
				.setIssuer(issuer)
				.signWith(signingKey);
		
		if (expiredAfterMillis >= 0) {
			long expMillis = nowMillis + expiredAfterMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		
		return builder.compact();
	}
	/**
	 * Generate a JSON Web Token.
	 * @param id The user's id
	 * @param issuer The issuer
	 * @param subject The subject
	 * @return Return a JSON Web Token.
	 */
	public static String create(String id, String issuer, String subject) {
		return create(id, issuer, subject, -1);
	}
	/**
	 * Generate a JSON Web Token.
	 * @param id The user's id
	 * @param issuer The issuer
	 * @param subject The subject
	 * @param expiredAfterMillis How many seconds until the JWT expire? If you do not want it to expire, put a negative
	 *                           value.
	 * @return Return a JSON Web Token.
	 */
	public static String create(Integer id, String issuer, String subject, long expiredAfterMillis) {
		return create(id.toString(), issuer, subject, expiredAfterMillis);
	}
	/**
	 * Generate a JSON Web Token.
	 * @param id The user's id
	 * @param issuer The issuer
	 * @param subject The subject
	 * @return Return a JSON Web Token.
	 */
	public static String create(Integer id, String issuer, String subject) {
		return create(id, issuer, subject, -1);
	}
	
	/**
	 * Decode a JSON Web Token.
	 * @param jwt The JSON Web Token.
	 * @return A claims containing all information about the JSON Web Token.
	 */
	public static Claims decode(String jwt) {
		return Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary(getJWTSecretKey()))
				.parseClaimsJws(jwt)
				.getBody();
	}
	
	/**
	 * Verify if the JSON Web Token is valid.
	 * @param jwt The JSON Web Token.
	 * @return Return {@code true} if the JSON Web Token is valid, {@code false} otherwise.
	 */
	public static boolean verify(String jwt) {
		// TODO: Implement the verify function
		Claims claims;
		try {
			claims = decode(jwt);
		} catch (MalformedJwtException ignored) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Get the static secret key for the applciation, used to generate and decode JSON Web Tokens.
	 * @return Return the key as a string.
	 */
	public static String getJWTSecretKey() {
		// TODO: Get it from a file: it's more secure
		return "une-clef-en-beton-de-la-mort-que-personne-ne-pourra-deviner-parcequ-elle-est-trop-verbeuse-et-en-plus" +
				"-de-ca-elle-en-ecrite-en-francais-omg";
	}
}
