package aze31130.wynnstats.commands;

import org.json.JSONArray;
import org.json.JSONObject;

import aze31130.wynnstats.models.Guild;
import aze31130.wynnstats.utils.JsonDownloader;

public class GuildInfo extends Command {
	
	public GuildInfo(String commandName) {
		this.name = commandName;
	}
	
	public static Guild getGuildByName(String guildName) {
		try {
			String guildUrl = "https://api.wynncraft.com/public_api.php?action=guildStats&command=" + guildName;
			// Url encoding for potential spaces in name
			guildUrl = guildUrl.replace(" ", "%20");
			
			JSONObject json = JsonDownloader.getJson(guildUrl);
			System.out.println("Downloading guild " + guildName);
			Guild g = new Guild(
					json.getString("name"),
					json.getString("prefix"),
					json.getInt("level"),
					json.getInt("xp"),
					json.getString("createdFriendly"),
					json.getInt("territories")
					);
			
			JSONArray guildMembers = json.getJSONArray("members");
			for (int i = 0; i < guildMembers.length(); i++) {
				g.addPlayer(guildMembers.getJSONObject(i).getString("name"),
						guildMembers.getJSONObject(i).getLong("contributed"));
			}
			
			return g;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void execute(String[] args) {
		if (args.length < 2) {
			System.err.println("You must provide a guild name !");
			return;
		}
		String guildName = args[1];
		
		/*
		 * If the given guild has space in its name
		 */
		for (int i = 3; i < args.length; i++)
			guildName += args[i];
		Guild g = getGuildByName(guildName);
		g.display();
	}
}
