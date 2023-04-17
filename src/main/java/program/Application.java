package program;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import controller.ChooseMenuItem;

public class Application {

	public static void main(String[] args) throws IOException, ParseException {

		Scanner sc = new Scanner(System.in);
		Boolean c = true;
		while (c) {
			new ChooseMenuItem();

			System.out.println("Pressione 'C' para continuar ou 'E' para sair:");
			String in = sc.nextLine();
			if (in.equals("C")) {
				new ChooseMenuItem();
			} else if (in.equals("E")) {
				c = false;
			}
		}
	}

}