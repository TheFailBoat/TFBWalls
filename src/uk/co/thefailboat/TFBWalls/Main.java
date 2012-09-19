package uk.co.thefailboat.TFBWalls;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.thefailboat.TFBWalls.GameComponents.GameManager;
import uk.co.thefailboat.TFBWalls.GameComponents.LobbyManager;
import uk.co.thefailboat.TFBWalls.command.*;

public class Main extends JavaPlugin{
	//LISTENERS
    private final WallsPlayerListener playerListener = new WallsPlayerListener(this, this);
    private final WallsEntityListener entityListener = new WallsEntityListener(this, this);
    //COMPONENTS
    public LobbyManager Lobby;
    public GameManager Game;
    public Location SpawnLocation;
	
    //enable and disable
	public void onEnable(){
		SpawnLocation = new Location(this.getServer().getWorld("world"), 236, 149, -793, -269, 3); //This has to go here, how else can we refer to the world?
		//Register listeners
		getServer().getPluginManager().registerEvents(entityListener, this);
		getServer().getPluginManager().registerEvents(playerListener, this);
		
		//Register commands
		getCommand("TimerTest").setExecutor(new TimerTest(this));
		getCommand("Getpos").setExecutor(new Getpos(this));
		getCommand("ToggleFreeze").setExecutor(new ToggleFreeze(this));
		getCommand("Kick").setExecutor(new Kick(this));
		getCommand("KickAll").setExecutor(new Kick(this));
		
		Lobby = new LobbyManager(this, this);
		Game = new GameManager(this, this);
		
		Statics.log.info(Statics.prefix+"Plugin has finished loading.");
	}
	
	public void onDisable(){
		Statics.log.info(Statics.prefix+"Plugin version "+Statics.Version+" has been disabled.");
	}
}
