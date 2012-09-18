package uk.co.thefailboat.TFBWalls.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.thefailboat.TFBWalls.GameComponents.GameEvent;
import uk.co.thefailboat.TFBWalls.GameComponents.GameTimer;
import uk.co.thefailboat.TFBWalls.GameComponents.Events.InitGameEvent;
import uk.co.thefailboat.TFBWalls.GameComponents.Events.WallsDownEvent;

public class TimerTest implements CommandExecutor{
	private JavaPlugin plugin;
		
	public TimerTest(JavaPlugin _plugin){
		this.plugin = _plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lavel, String[] args){
		GameEvent event_init = new WallsDownEvent(plugin);
		GameEvent event_start = new GameEvent(){
			public void run() {
				plugin.getServer().broadcastMessage("EVENT WORKS!");
			}
		};
		
		GameTimer gt_init = new GameTimer(plugin, "STARTED", "Will end", "ENDED", 5, event_init);	
		//GameTimer gt_start = new GameTimer(plugin, "STARTED", "Will end", "ENDED", 125, event_start);	
		gt_init.Start();
		//gt_start.Start();
		return true;
	}
}
