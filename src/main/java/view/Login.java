package view;

import java.util.Scanner;
import model.Users;

public class Login {
	
	static String uName;
	static String uPsw;
	
	public Login() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o nome do usuário:");
		uName = sc.next();
		
		System.out.println("Informe a senha do usuário:");
		uPsw = sc.next();
		
//		sc.close();
		
		
	}

	public static String getuName() {
		return uName;
	}

	public static String getuPsw() {
		return uPsw;
	}


}
