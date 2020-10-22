package controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import model.CriptyEnum;

public class Criptografia {

	private CriptyEnum modoCriptyEnum;

	public Criptografia(CriptyEnum moCriptyEnum) {

		this.modoCriptyEnum = moCriptyEnum;

	}

	public String criptografar(String value) {

		String retornoString = "";

		switch (modoCriptyEnum) {
		
		case MD5:

			break;

		case SHA1:

			try {
				retornoString = criptSha1(value);

			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		default:
			break;
		}

		return retornoString;

	}

	

	private String criptSha1(String value) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest algorithm = MessageDigest.getInstance("SHA1");
		byte messageDigest[] = algorithm.digest(value.getBytes("UTF-8"));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senhahex = hexString.toString();

		// System.out.println(senhahex);//

		return senhahex;
	}

	private String verificacaoSha1(String value, String hash) throws NoSuchAlgorithmException, UnsupportedEncodingException  {

	
		return criptSha1(value).equals(hash) ? "íntegro" :"Falha de integridade";
	}

	public String descriptografia(String value, String hash) {
		String retornoString = "";

		switch (modoCriptyEnum) {

	
		case MD5:

			break;

		case SHA1:

	
			try {
				retornoString = verificacaoSha1(value, hash);
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

			break;

		default:
			break;
		}

		return retornoString;
	}
}
