package view;

import java.util.List;
import java.util.Scanner;

import model.Users;

public class Menus {

	static public int mainMenu() {

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

	static public int userManagerMenu() {

		Scanner sc = new Scanner(System.in);

		StringBuilder menuUserManager = new StringBuilder();
		menuUserManager.append("Informe a opção: ");
		menuUserManager.append("\n1 - Criar usuário");
		menuUserManager.append("\n2 - Consultar usuário(s) ");
		menuUserManager.append("\n3 - Alterar usuário");
		menuUserManager.append("\n4 - Apagar usuário");

		System.out.println(menuUserManager);

		int opt = sc.nextInt();

//		sc.close();

		return opt;
	}

	static public List<String> createUserInputs() {

		Scanner sc = new Scanner(System.in);
		List<String> userData = null;

		System.out.println("Informe o nome do usuário:");
		userData.add(sc.next());

		System.out.println("Informe a senha do usuário:");
		userData.add(sc.next());

		System.out.println("Informe a permissão do usuário:");
		userData.add(sc.next());

		return userData;

	}

	static public String readUserby() {
		Scanner sc = new Scanner(System.in);

		String byName = "Informe o nome do usuário:";
		String byID = "Informe o ID do usuário:";

		System.out.println("1 - Por nome\n2 - Por ID");

		String opt = sc.nextLine();
//		if (sc.hasNextLine()) {
//			sc.next();
//		} 

		if (opt.equals("1")) {
			System.out.println(byName);
			String name = sc.nextLine();
			return name;
		}
		if (opt.equals("2")) {
			System.out.println(byID);
			String id = sc.next();
			return id;
		} else {
			System.out.println("Opção inválida");

		}
		return null;

	}

	static public Users updateUserInputs() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o novo nome do usuário: (pressione \"enter\" para manter o atual)");
		String nName = sc.nextLine();

		System.out.println("Informe a nova senha do usuário: (pressione \"enter\" para manter a atual)");
		String nPsw = sc.nextLine();

		System.out.println("Informe a nova permissão do usuário: (pressione \"enter\" para manter a atual)");

		String nPermission;
		if (sc.hasNextLine()) {
			nPermission = sc.nextLine();
		} else {
			nPermission = "";

		}

		Users updatedUser = new Users(nName, nPsw);
		try {
			updatedUser.convertStringToPermission(nPermission);
			return updatedUser;

		} catch (Exception e) {
			System.out.println("A permissão informada não existe.");
			return null;
		}

	}

}