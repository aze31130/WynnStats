package aze31130.wynnstats.commands;

import org.json.JSONObject;

import aze31130.wynnstats.models.Player;
import aze31130.wynnstats.utils.JsonDownloader;

public class PlayerInfo extends Command {
	
	public PlayerInfo(String commandName) {
		this.name = commandName;
	}
	
	public static Player getPlayerByName(String username, long guildXp) {
		try {
			String playerUrl = "https://api.wynncraft.com/v2/player/" + username + "/stats";
			playerUrl = playerUrl.replace(" ", "%20");
			JSONObject json = JsonDownloader.getJson(playerUrl);
			
			JSONObject player = json.getJSONArray("data").getJSONObject(0);
			JSONObject playerMeta = player.getJSONObject("meta");
			JSONObject playerLocation = playerMeta.getJSONObject("location");
			JSONObject playerGuild = player.getJSONObject("guild");
			JSONObject playerGlobal = player.getJSONObject("global");
			JSONObject playerTotalLevel = playerGlobal.getJSONObject("totalLevel");
			
			
			String server = "";
			if (playerLocation.getBoolean("online"))
				server = playerLocation.getString("server");
			
			String guildName = "";
			String guildRank = "";
			if (!playerGuild.isNull("name")) {
				guildName = playerGuild.getString("name");
				guildRank = playerGuild.getString("rank");
			}
			
			return new Player(
					player.getString("username"),
					player.getString("uuid"),
					player.getString("rank"),
					playerMeta.getString("firstJoin"),
					playerMeta.getString("lastJoin"),
					playerMeta.getInt("playtime"),
					playerLocation.getBoolean("online"),
					server,
					guildName,
					guildRank,
					playerGlobal.getInt("chestsFound"),
					playerGlobal.getInt("blocksWalked"),
					playerGlobal.getInt("itemsIdentified"),
					playerGlobal.getInt("mobsKilled"),
					playerTotalLevel.getInt("combat"),
					playerTotalLevel.getInt("profession"),
					playerGlobal.getInt("logins"),
					playerGlobal.getInt("deaths"),
					playerGlobal.getInt("discoveries"),
					guildXp
					);
			
		} catch(Exception e) {
			System.err.println("[ERROR] Cannot retrive stats of player " + username);
		}
		return null;
	}
	
	@Override
	public void execute(String[] args) {
		if (args.length < 2) {
			System.err.println("You must provide a player name !");
			return;
		}
		Player p = getPlayerByName(args[1], 0);
		p.display();
	}
}
