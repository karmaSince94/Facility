package com.nuvizz.facility.util;

import java.util.UUID;

public class TokenGenerator 
{
	public static String createID() 
	{
		String uniqueKey = UUID.randomUUID().toString();
		// System.out.println (uniqueKey);
		return uniqueKey;

	}

}
