package view;

import java.util.Scanner;

public class Menu {
	
	static public int PrintMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Selecione uma das opções do menu:");
		System.out.println("--------------------------------------");
		System.out.println("1 - Gerenciar usuários");
		System.out.println("2 - Registrar marcação");
		System.out.println("3 - Gerenciar marcações");
		System.out.println("4 - Emitir relatórios");
		System.out.println("--------------------------------------");
		
		int opt = sc.nextInt();
		
//		sc.close();
		
		return opt;
		
	}
	
	
	

}
