package uk.co.thefailboat.TFBWalls;

import org.bukkit.plugin.java.JavaPlugin;

import uk.co.thefailboat.TFBWalls.command.*;

public class TFBWalls extends JavaPlugin{
	//LISTENERS
    private final WallsPlayerListener playerListener = new WallsPlayerListener(this, this);
    private final WallsEntityListener entityListener = new WallsEntityListener(this, this);
    
    //enable and disable
	public void onEnable(){
		//Register listeners
		getServer().getPluginManager().registerEvents(entityListener, this);
		getServer().getPluginManager().registerEvents(playerListener, this);
		
		//Register commands
		getCommand("TimerTest").setExecutor(new TimerTest(this));
		
		Statics.log.info(Statics.prefix+"Plugin has finished loading.");
	}
	
	public void onDisable(){
		Statics.log.info(Statics.prefix+"Plugin version "+Statics.Version+" has been disabled.");
	}
}
