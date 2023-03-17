package controller;

import view.Login;
import view.Menu;

import java.util.Scanner;

import controller.CheckUserNPsw;
import model.Users;
import model.Users.PermissionType;
import model.manageusers.CreateUser;

public class ChooseMenuItem {

	@SuppressWarnings("unlikely-arg-type")
	public ChooseMenuItem() {

//		System.out.println("1 - Gerenciar usuários");
//		System.out.println("2 - Registrar marcação");
//		System.out.println("3 - Gerenciar marcações");
//		System.out.println("4 - Emitir relatórios");

//		public enum PermissionType{
//			ADMIN,
//			MANAGER,
//			USER
//		}

		int pickedOption = Menu.PrintMenu();

		new Login();
		CheckUserNPsw checklogin = new CheckUserNPsw();
		Users u = checklogin.testkUserNPsw();

		switch (pickedOption) {
		case 1: {
			if (u.getPermission().equals(PermissionType.ADMIN)) {
				StringBuilder menuUserManager = new StringBuilder();
				menuUserManager.append("Informe a opção: ");
				menuUserManager.append("\n1 - Criar usuário");
				menuUserManager.append("\n2 - Consultar usuário(s) ");
				menuUserManager.append("\n3 - Alterar usuário");
				menuUserManager.append("\n4 - Apagar usuário");

				System.out.println(menuUserManager);

				Scanner sc = new Scanner(System.in);
				int option = sc.nextInt();
//				sc.next();

				if (option == 1) {

					System.out.println("Informe o nome do usuário:");
					String uName = sc.next();

					System.out.println("Informe a senha do usuário:");
					String uPsw = sc.next();

					System.out.println("Informe a permissão do usuário:");
					String uPerm = sc.next();

					new CreateUser(uName, uPsw, uPerm);
				}

			}

			else {
				System.out.println("O usuário não possui permissão para acessar essa funcionalidade.");
				return;
			}

		}

		case 2: {

		}

		}

	}

}
