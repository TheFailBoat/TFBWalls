package uk.co.thefailboat.TFBWalls.GameComponents;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import uk.co.thefailboat.TFBWalls.Main;

public class GameManager {
	private GameTimer wallsTimer;
	private List<Team> teams = new ArrayList<Team>();
	private JavaPlugin plugin;
	private boolean inProgress = false;
	private Main instance;
	
	public GameManager(JavaPlugin _plugin, Main _instance){
		plugin = _plugin;
		instance = _instance;
	}
	
	public void setTeams(ArrayList<Team> t){
		teams = t;
	}
	
	public boolean GameInProgress(){
		return inProgress;
	}
	
	public void HaltGame(){
		//TODO: Teleport players up to lobby.
		
	}
}
