package aze31130.wynnstats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import aze31130.wynnstats.commands.Command;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to Wynnstats 1.0, type help for help");
		WynnLog log = new WynnLog();
		
		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print('>');
			String userInput = "";
			try {
				userInput = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] table = userInput.split("\\s+");
			boolean found = false;
			
			for (Command c : log.commands) {
				if (table[0].equalsIgnoreCase(c.name)) {
					c.execute(table);
					found = true;
					break;
				}
			}
			
			if (!found)
				System.out.println("Unknown command type help for help !");
		}
	}
}
