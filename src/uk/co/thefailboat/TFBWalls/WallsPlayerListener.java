package uk.co.thefailboat.TFBWalls;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
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
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		if(Statics.FrozenPlayers.contains(player)){
			//Get the location the player was frozen on
			Location location = event.getFrom();
			//Allow the player to look around
			location.setPitch(event.getTo().getPitch());
			location.setYaw(event.getTo().getYaw());
			
			player.teleport(location);
		}
	}

}
