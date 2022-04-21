package aze31130.wynnstats.commands;

public abstract class Command {
	public String name;
	public abstract void execute(String[] args);
}
