package controller;

import view.Login;
import view.Menus;

import java.util.List;
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

		int pickedOption = Menus.mainMenu();

		new Login();
		CheckUserNPsw checklogin = new CheckUserNPsw();
		Users u = checklogin.testkUserNPsw();

		switch (pickedOption) {
		case 1: {
			if (u.getPermission().equals(PermissionType.ADMIN)) {
				int option = Menus.userManagerMenu();

				if (option == 1) { // criar usuário

					List<String> userData = Menus.createUserInputs();

					new CreateUser(userData.get(0), userData.get(1), userData.get(2));

					System.out.println("Usuário criado com sucesso!");
				}

				if (option == 2) { // consultar usuário

					String nameOrId = Menus.readUserby();
					ConsultUser readUser = new ConsultUser();

					try {

						long id = Long.parseLong(nameOrId);
						Users returnedUser = readUser.ConsultUserByID(id);
						System.out.println("Os dados do usuário consultado são:\n" + returnedUser.toString());
					} catch (Exception e) {
						Users returnedUser = readUser.ConsultUserByName(nameOrId);
						System.out.println("Os dados do usuário consultado são:\n" + returnedUser.toString());

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
