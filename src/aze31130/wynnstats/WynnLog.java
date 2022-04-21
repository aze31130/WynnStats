package aze31130.wynnstats;

import java.util.ArrayList;
import java.util.List;

import aze31130.wynnstats.commands.Command;
import aze31130.wynnstats.commands.GuildInfo;
import aze31130.wynnstats.commands.Help;
import aze31130.wynnstats.commands.PlayerInfo;

public class WynnLog {
	public List<Command> commands;
	
	public WynnLog() {
		this.commands = new ArrayList<Command>();
		this.commands.add(new GuildInfo("g"));
		this.commands.add(new PlayerInfo("p"));
		this.commands.add(new Help("help"));
	}
}
