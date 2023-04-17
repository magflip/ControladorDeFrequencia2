package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
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
		List<String> userData = new ArrayList();

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
	
	static public int attendanceRecordMenu() {

		Scanner sc = new Scanner(System.in);

		StringBuilder menuAttendanceRecord = new StringBuilder();
		menuAttendanceRecord.append("Informe a opção: ");
		menuAttendanceRecord.append("\n1 - Incluir registro próprio");
		menuAttendanceRecord.append("\n2 - Incluir registro para outro usuário");


		System.out.println(menuAttendanceRecord);

		int opt = sc.nextInt();

//		sc.close();

		return opt;
	}
	
	static public int manageRecordMenu() {

		Scanner sc = new Scanner(System.in);

		StringBuilder menuAttendanceRecord = new StringBuilder();
		menuAttendanceRecord.append("Informe a opção: ");
		menuAttendanceRecord.append("\n1 - Alterar registro");
		menuAttendanceRecord.append("\n2 - Apagar registro");


		System.out.println(menuAttendanceRecord);

		int opt = sc.nextInt();

		return opt;
	}
	
	static public Date informDate() throws ParseException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe a data e hora no formato yyyy-mm-dd :");

		String input = sc.nextLine();
		
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date date = parser.parse(input);
        
        
		return date;
	}
	
	static public int chooseRecordToChangeDelete() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o número do registro que deseja alterar/excluir: ");

		int opt = sc.nextInt();

//		sc.close();

		return opt;
	}
	
	static public String newAttendance() {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o horário do registro no formato HH:mm:ss : ");

		String s = sc.nextLine();
		
		return s;
	}

}