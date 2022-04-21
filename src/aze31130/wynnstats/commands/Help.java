package aze31130.wynnstats.commands;

public class Help extends Command {
	public Help(String commandName) {
		this.name = commandName;
	}

	@Override
	public void execute(String[] args) {
		System.out.println("---Help Page---");
		System.out.println("p <player name>");
		System.out.println("g <guild name>");
		System.out.println("---------------");
	}
}
