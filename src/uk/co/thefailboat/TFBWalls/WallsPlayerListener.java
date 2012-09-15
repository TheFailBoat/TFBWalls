package uk.co.thefailboat.TFBWalls;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WallsPlayerListener implements Listener {

	public WallsPlayerListener(TFBWalls instance, JavaPlugin plugin) {
		// TODO Auto-generated constructor stub
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		player.sendMessage(ChatColor.GOLD + "Welcome!");
	}

}
