package uk.co.thefailboat.TFBWalls.GameComponents.Events;

import java.util.List;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.*;

import uk.co.thefailboat.TFBWalls.GameComponents.GameEvent;
import uk.co.thefailboat.TFBWalls.GameComponents.MapReferences;
import uk.co.thefailboat.TFBWalls.GameComponents.Team;

public class StartPreGame extends GameEvent {
	private JavaPlugin plugin;
	private List<Team> teams;
	private MapReferences refs;

	public StartPreGame(JavaPlugin _plugin, List<Team> _teams){
		plugin = _plugin;
		teams = _teams;
		refs = new MapReferences(plugin);
	}

	public void run(){
		for(Team t : teams){
			List<Location> spawns = refs.TeamSpawns.get(t.GetNumber());
			List<Player> players = t.GetPlayers();
			for(int i = 0; i < players.size(); i++){
				players.get(i).teleport(spawns.get(i));
			}
		}
		
		//TODO: Trigger some sort of pre-game timer. Call to the GameManager maybe?
	};
}