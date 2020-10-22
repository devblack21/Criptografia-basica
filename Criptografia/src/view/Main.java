package view;

import java.util.Scanner;
import controller.Criptografia;
import controller.LeitorArquivo;
import model.CriptyEnum;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		/*
		LeitorArquivo la = new LeitorArquivo("caminho do arquivo");
		String a = null;
		StringBuffer sbBuffer = new StringBuffer();
		while ((a = la.proximaLinha()) != null) {
			sbBuffer.append(a);
		}
		*/
		
		Criptografia criptografia = new Criptografia(CriptyEnum.SHA1);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Texto a ser Codificado:");
		String valorString = scanner.next();
		
		System.out.println(criptografia.criptografar(valorString));
		
		
		System.out.println();
		System.out.println("Hash");
		scanner = new Scanner(System.in);
		String valorDescripty = scanner.next();
		System.out.println();
		System.out.println("Texto:");
		scanner = new Scanner(System.in);
		String valorStringSenha = scanner.next();
		
		System.out.println(criptografia.descriptografia(valorStringSenha,valorDescripty));
		
	}

}
