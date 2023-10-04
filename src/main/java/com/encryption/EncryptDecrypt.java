package com.encryption;

import java.util.Base64;

public class EncryptDecrypt {
	
	public String encryptPass(String password) {
		
		byte[] encrypt = Base64.getEncoder().encode(password.getBytes());
		
		return new String(encrypt);
	}
	
	public String decryptPass(String password) {
		
		byte[] decrypt = Base64.getDecoder().decode(password.getBytes());
		
		return new String(decrypt);
	}

	public EncryptDecrypt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
