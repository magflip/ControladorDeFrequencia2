package controller;

import view.Login;
import view.Menu;

import java.util.Scanner;

import model.Users;
import model.Users.PermissionType;
import model.manageusers.ConsultUser;
import model.manageusers.CreateUser;

public class ChooseMenuItem {

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

					System.out.println("Usuário criado com sucesso!");
				}

				if (option == 2) {

					System.out.println("1 - Consultar por nome\n2 - Consultar por ID");
					int nameOrId = sc.nextInt();

					if (nameOrId == 1) {

						System.out.println("Informe o nome do usuário a ser consultado:");
						String uName = sc.next();

						ConsultUser readUser = new ConsultUser();
						try {
							Users returnedUser = readUser.ConsultUserByName(uName);
							System.out.println("Os dados do usuário consultado são:\n" + returnedUser.toString());

						} catch (Exception e) {
							System.out.println("Usuário não encontrado!");

						}

					}

					if (nameOrId == 2) {

						System.out.println("Informe o ID do usuário a ser consultado:");
						long uID = sc.nextLong();

						ConsultUser readUser = new ConsultUser();
						try {
							Users returnedUser = readUser.ConsultUserByID(uID);
							System.out.println("Os dados do usuário consultado são:\n" + returnedUser.toString());

						} catch (Exception e) {
							System.out.println("Usuário não encontrado!");
						}

					}
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
