package controller;

import view.Login;
import view.Menus;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.DAOentries;
import model.Entry;
import model.Users;
import model.Users.PermissionType;
import model.manageentries.CreateEntry;
import model.manageentries.DeleteEntry;
import model.manageentries.UpdateEntry;
import model.manageusers.ConsultUser;
import model.manageusers.CreateUser;
import model.manageusers.DeleteUser;
import model.manageusers.UpdateUser;

public class ChooseMenuItem {

	@SuppressWarnings("deprecation")
	public ChooseMenuItem() throws IOException, ParseException {

//		System.out.println("1 - Gerenciar usuários");
//		System.out.println("2 - Registrar marcação");
//		System.out.println("3 - Gerenciar marcações");
//		System.out.println("4 - Emitir relatórios");

//		public enum PermissionType{
//			ADMIN,
//			MANAGER,
//			USER
//		}
		List<Integer> options = new ArrayList<>();
		options.add(1);
		options.add(2);
		options.add(3);
		options.add(4);

		int pickedOption = Menus.mainMenu();

		if (!options.contains(pickedOption)) {
			System.out.println("Opção inválida");
			return;
		}
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

					CreateEntry nEntry = new CreateEntry(u, Instant.now());

					System.out.println("Marcação efetuada com sucesso!");
				}

				if (option == 2) { // registrar marcação para outro usuario

					if (u.getPermission().equals(PermissionType.USER)) {
						System.out.println("O usuário não possui permissão para incluir marcações para terceiros.");
						return;
					} else {
						String nameOrId = Menus.readUserby();
						ConsultUser readUser = new ConsultUser();

						try {

							long id = Long.parseLong(nameOrId);
							Users returnedUser = readUser.ConsultUserByID(id);
							if (returnedUser != null) {
								CreateEntry nEntry = new CreateEntry(returnedUser, Instant.now());
								System.out.println("Marcação efetuada com sucesso!");
							} else
								System.out.println("Usuário não encontrado");
						} catch (Exception e) {
							Users returnedUser = readUser.ConsultUserByName(nameOrId);
							if (returnedUser != null) {
								CreateEntry nEntry = new CreateEntry(returnedUser, Instant.now());
								System.out.println("Marcação efetuada com sucesso!");
							} else
								System.out.println("Usuário não encontrado");

						}
					}
				}

			}

			else {
				System.out.println("O usuário não possui permissão para acessar essa funcionalidade.");
				return;
			}

		}

		case 3: { // gerenciar marcações
			if (u.getPermission().equals(PermissionType.MANAGER)) {

				String nameOrId = Menus.readUserby();
				ConsultUser readUser = new ConsultUser();
				Users returnedUser;
				try {

					long id = Long.parseLong(nameOrId);
					returnedUser = readUser.ConsultUserByID(id);
					if (returnedUser == null) {
						System.out.println("Usuário não encontrado");
						return;
					}
				} catch (Exception e) {
					returnedUser = readUser.ConsultUserByName(nameOrId);
					if (returnedUser == null) {
						System.out.println("Usuário não encontrado");
						return;
					}

				}

				int option = Menus.manageRecordMenu();

				Date date = Menus.informDate();

				Long id = returnedUser.getId();

				DateFormat df = new SimpleDateFormat("dd/MM/YYY hh:mm:ss a");
//		        DateFormat time = new SimpleDateFormat("hh:mm:ss a");
//		        System.out.println("Date: " + d.format(date));
//		        System.out.println("Time: " + time.format(date));

				if (option == 1) { // alterar registro
					DAOentries consultEntry = new DAOentries();
					List<Entry> e = consultEntry.consultEntries(id, date);
					System.out.println("Os registros encontrados para esse dia são:");
					for (int i = 0; i < e.size(); i++) {
						System.out.printf("%d - %s %n", i + 1, df.format(Date.from(e.get(i).getNewRegistry())));
//						System.out.printf("%d - %s %n", i+1 , );

					}
					int valueToChange = Menus.chooseRecordToChangeDelete();

					Entry reg = e.get(valueToChange - 1);
					String nAttendance = Menus.newAttendance();
					Date time = Date.from(reg.getNewRegistry());
					String nHour = nAttendance.charAt(0) + "" + nAttendance.charAt(1);
					String nMinute = nAttendance.charAt(3) + "" + nAttendance.charAt(4);
					String nSeconds = nAttendance.charAt(6) + "" + nAttendance.charAt(7);
					time.setHours(Integer.parseInt(nHour));
					time.setMinutes(Integer.parseInt(nMinute));
					time.setSeconds(Integer.parseInt(nSeconds));
					reg.setNewRegistry(time.toInstant());

					new UpdateEntry(reg);
					System.out.println("Registro alterado com sucesso");

				}

				if (option == 2) { // apagar registro
					DAOentries consultEntry = new DAOentries();
					List<Entry> e = consultEntry.consultEntries(id, date);
					System.out.println("Os registros encontrados para esse dia são:");
					for (int i = 0; i < e.size(); i++) {
						System.out.printf("%d - %s %n", i + 1, df.format(Date.from(e.get(i).getNewRegistry())));
//						System.out.printf("%d - %s %n", i+1 , );

					}
					int valueToChange = Menus.chooseRecordToChangeDelete();

					Entry reg = e.get(valueToChange - 1);
					new DeleteEntry(reg);
					System.out.println("Registro apagado com sucesso");

					

				}

			}

			else {
				System.out.println("O usuário não possui permissão para acessar essa funcionalidade.");
				return;
			}
		}

		case 4: { // emitir relatórios

		}
		default: {
			System.out.println("Opção inválida");
			return;
		}

		}

	}
}
