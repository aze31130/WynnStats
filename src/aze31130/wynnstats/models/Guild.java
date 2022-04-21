package aze31130.wynnstats.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import aze31130.wynnstats.commands.PlayerInfo;

public class Guild {
	public String name;
	public String prefix;
	public List<Player> members;
	public int level;
	public int xp;
	public String created;
	public int territories;
	
	public Guild(String name, String prefix, int level, int xp, String created, int territories) {
		this.name = name;
		this.prefix = prefix;
		this.members = new ArrayList<Player>();
		this.level = level;
		this.xp = xp;
		this.created = created;
		this.territories = territories;
	}
	
	public void addPlayer(String playerName, long guildXp) {
		Player p = PlayerInfo.getPlayerByName(playerName, guildXp);
		if (p != null)
			this.members.add(p);
	}
	
	public void display() {
		System.out.println("---Guild " + this.name + " / " + this.prefix + "---");
		System.out.println("LEVEL: " + this.level);
		System.out.println("XP: " + this.xp);
		System.out.println("Created: " + this.created);
		System.out.println("Territories: " + this.territories);
		
		System.out.println("Members:" + this.members.size());
		this.members.sort(Comparator.comparingLong(Player::getGuildXp).reversed());
		for (Player p : this.members) {
			if (p != null)
				p.display();
		}
		
		System.out.println("---ONLINE MEMBERS---");
		int i = 0;
		for (Player p : this.members) {
			if (p != null && p.isOnline)
				i++;
		}
		System.out.println(i + "/" + this.members.size());
	}
}
