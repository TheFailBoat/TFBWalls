package uk.co.thefailboat.TFBWalls.GameComponents;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class GameManager {
	private GameTimer wallsTimer;
	private List<Team> teams = new ArrayList<Team>();
	private JavaPlugin plugin;
	private boolean inProgress = false;
	
	public GameManager(JavaPlugin _plugin, ArrayList<Team> _teams){
		plugin = _plugin;
		teams = _teams;
	}
	
	public boolean GameInProgress(){
		return inProgress;
	}
	
	public void HaltGame(){
		//TODO: Teleport players up to lobby.
		
	}
}
