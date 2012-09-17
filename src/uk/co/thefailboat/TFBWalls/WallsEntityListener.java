package uk.co.thefailboat.TFBWalls;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class WallsEntityListener implements Listener {
	
	JavaPlugin plugin;
	Main instance;

	public WallsEntityListener(Main _instance, JavaPlugin _plugin) {
		plugin = _plugin;
		instance = _instance;
	}

}
