package com.shnlng.frog.util;

import java.util.UUID;

public class IdGen {
	public static String id32(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
