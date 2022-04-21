package aze31130.wynnstats.models;

public class Player {
	public String name;
	public String uuid;
	public String rank;
	public String firstJoin;
	public String lastJoin;
	public int playtime;
	public boolean isOnline;
	public String server;
	public String guildName;
	public String guildRank;
	public int chestsFound;
	public int blocksWalked;
	public int itemsIdentified;
	public int mobsKilled;
	public int combatLevel;
	public int professionLevel;
	public int logins;
	public int deaths;
	public int discoveries;
	public long guildXp;
	
	public Player(String name, String uuid, String rank, String firstJoin,
			String lastJoin, int playTime, boolean isOnline, String server,
			String guildName, String guildRank, int chestsFound, int blocksWalked,
			int itemsIdentified, int mobsKilled, int combatLevel, int professionLevel,
			int logins, int deaths, int discoveries, long guildXp) {
		this.name = name;
		this.uuid = uuid;
		this.rank = rank;
		this.firstJoin = firstJoin;
		this.lastJoin = lastJoin;
		this.playtime = playTime;
		this.isOnline = isOnline;
		this.server = server;
		this.guildName = guildName;
		this.guildRank = guildRank;
		this.chestsFound = chestsFound;
		this.blocksWalked = blocksWalked;
		this.itemsIdentified = itemsIdentified;
		this.mobsKilled = mobsKilled;
		this.combatLevel = combatLevel;
		this.professionLevel = professionLevel;
		this.logins = logins;
		this.deaths = deaths;
		this.discoveries = discoveries;
		this.guildXp = guildXp;
	}
	
	public long getGuildXp() {
		return this.guildXp;
	}
	
	public void display() {
		System.out.println("---Player " + this.name + " / " + this.uuid + "---");
		System.out.println("[RANK] " + this.rank);
		
		if (this.isOnline) {
			System.out.println("ONLINE: " + this.server);
		} else {
			System.out.println("OFFLINE");
		}
		
		if (!this.guildName.isEmpty()) {
			System.out.println("GUILD: " + this.guildName + " (ranked #" + this.guildRank + ")");
		}
		
		System.out.println("Guild xp contribution: " + this.guildXp);
		System.out.println("Chest Found: " + this.chestsFound);
		System.out.println("Blocks Walked: " + this.blocksWalked);
		System.out.println("Item identified: " + this.itemsIdentified);
		System.out.println("Mob killed: " + this.mobsKilled);
		System.out.println("Combat Level: " + this.combatLevel);
		System.out.println("Profession Level: " + this.professionLevel);
		System.out.println("Login amount: " + this.logins);
		System.out.println("Death amount: " + this.deaths);
		System.out.println("Discoveries: " + this.discoveries);
		System.out.println("Joined: " + this.firstJoin);
		System.out.println("Last login: " + this.lastJoin);
		System.out.println("--------------------------");
	}
}
