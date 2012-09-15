package uk.co.thefailboat.TFBWalls.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.thefailboat.TFBWalls.GameComponents.GameEvent;
import uk.co.thefailboat.TFBWalls.GameComponents.GameTimer;

public class TimerTest implements CommandExecutor{
	private JavaPlugin plugin;
		
	public TimerTest(JavaPlugin _plugin){
		this.plugin = _plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lavel, String[] args){
		GameEvent event = new GameEvent(){
			public void run() {
				plugin.getServer().broadcastMessage("EVENT WORKS!");
			}
		};
		GameTimer gt = new GameTimer(plugin, "STARTED", "Will end", "ENDED", 120, event);	
		gt.Start();
		return true;
	}
}
