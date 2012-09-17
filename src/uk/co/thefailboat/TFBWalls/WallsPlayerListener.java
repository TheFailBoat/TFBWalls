package uk.co.thefailboat.TFBWalls;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WallsPlayerListener implements Listener {
	
	JavaPlugin plugin;
	Main instance;

	public WallsPlayerListener(Main _instance, JavaPlugin _plugin) {
		plugin = _plugin;
		instance = _instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		player.teleport(instance.SpawnLocation);
		instance.Lobby.AttachPlayer(player);
	}
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event){
		Player player = event.getPlayer();
		player.teleport(instance.SpawnLocation);
		instance.Lobby.AttachPlayer(player);
	}

}
