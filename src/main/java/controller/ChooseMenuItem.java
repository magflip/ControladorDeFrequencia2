package controller;

import view.Login;
import view.Menus;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.Users;
import model.Users.PermissionType;
import model.manageusers.ConsultUser;
import model.manageusers.CreateUser;
import model.manageusers.DeleteUser;
import model.manageusers.UpdateUser;

public class ChooseMenuItem {

	public ChooseMenuItem() throws IOException {

		final String ESC = "\033[";

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

				if (option == 3) { // alterar usuario

					String nameOrId = Menus.readUserby();
					ConsultUser readUser = new ConsultUser();
					Users updatedUser = Menus.updateUserInputs();

					try {

						long id = Long.parseLong(nameOrId);
						Users returnedUser = readUser.ConsultUserByID(id);
						new UpdateUser(returnedUser, updatedUser);
						System.out.println("Usuário alterado com sucesso!");

					} catch (Exception e) {
						Users returnedUser = readUser.ConsultUserByName(nameOrId);
						new UpdateUser(returnedUser, updatedUser);
						System.out.println("Usuário alterado com sucesso!");

					}

				}

				if (option == 4) { // deletar usuario

					String nameOrId = Menus.readUserby();
					ConsultUser readUser = new ConsultUser();

					try {

						long id = Long.parseLong(nameOrId);
						Users returnedUser = readUser.ConsultUserByID(id);
						new DeleteUser(id);
						System.out.println("Usuário apagado com sucesso!");

					} catch (Exception e) {
						Users returnedUser = readUser.ConsultUserByName(nameOrId);
						new DeleteUser(returnedUser.getId());
						System.out.println("Usuário apagado com sucesso!");

					}

				}

			}

			else {
				System.out.println("O usuário não possui permissão para acessar essa funcionalidade.");
				return;
			}

		}

		case 2: {
			if (u.getPermission().equals(PermissionType.MANAGER) || u.getPermission().equals(PermissionType.USER)) {
				int option = Menus.attendanceRecordMenu();

				if (option == 1) { // registrar própria marcação

					List<String> userData = Menus.createUserInputs();

					new CreateUser(userData.get(0), userData.get(1), userData.get(2));

					System.out.println("Usuário criado com sucesso!");
				}

				if (option == 2) { // registrar marcação para outro usuario

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

		}

	}

}
