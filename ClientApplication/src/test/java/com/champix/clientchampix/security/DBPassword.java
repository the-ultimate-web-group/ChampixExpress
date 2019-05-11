package com.champix.clientchampix.security;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DBPassword {
	
	@Test
	public void encryptAllPasswords() {
		String allPasswords = "francoise\n" +
				"colette\n" +
				"xavier\n" +
				"georges\n" +
				"solange\n" +
				"janine\n" +
				"gerard\n" +
				"jean louis\n" +
				"gisele\n" +
				"genevieve\n" +
				"guy\n" +
				"auguste\n" +
				"pierre\n" +
				"bernard\n" +
				"jean\n" +
				"nadine\n" +
				"michel\n" +
				"gerard\n" +
				"jack\n" +
				"j georges\n" +
				"yvette\n" +
				"jean\n" +
				"jean pierre\n" +
				"annette\n" +
				"sophie\n" +
				"roger\n" +
				"huguette\n" +
				"bernadette\n" +
				"genevieve\n" +
				"janine\n" +
				"francoise\n" +
				"marie therese\n" +
				"jeanne\n" +
				"claudine\n" +
				"claude\n" +
				"francois\n" +
				"jean\n" +
				"remy\n" +
				"daniel\n" +
				"maurice\n" +
				"jeanne\n" +
				"marie louise\n" +
				"bernard\n" +
				"guy\n" +
				"jean charles\n" +
				"madeleine\n" +
				"claude\n" +
				"yves\n" +
				"paulette\n" +
				"christian\n" +
				"daniel\n" +
				"alain\n" +
				"michel\n" +
				"alphonsine\n" +
				"maurice\n" +
				"raymonde\n" +
				"roland\n" +
				"louise\n" +
				"pascal\n" +
				"bernard\n" +
				"therese\n" +
				"francoise\n" +
				"patricia\n" +
				"bernard\n" +
				"eliane\n" +
				"henri\n" +
				"claude\n" +
				"marie madeleine\n" +
				"paul\n" +
				"josette\n" +
				"marcel\n" +
				"gerard\n" +
				"marcelline\n" +
				"marie claude\n" +
				"yolande\n" +
				"michel\n" +
				"madeleine\n" +
				"nicole\n" +
				"daniel\n" +
				"simone\n" +
				"armelle\n" +
				"patricia\n" +
				"juliette\n" +
				"mauricette\n" +
				"charles\n" +
				"odette\n" +
				"fernand\n" +
				"serge\n" +
				"xavier\n" +
				"simonne\n" +
				"irene\n" +
				"bernard\n" +
				"jean claude\n" +
				"helene\n" +
				"marthe\n" +
				"irene\n" +
				"cecile\n" +
				"georgette\n" +
				"marceline\n" +
				"jean-luc";
		ArrayList<String> passwords = new ArrayList<>(Arrays.asList(allPasswords.split("\\n")));
		
		for (String p : passwords)
			System.out.println(MD5.hash(p));
	}
}
