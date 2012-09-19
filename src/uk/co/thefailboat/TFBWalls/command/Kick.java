package uk.co.thefailboat.TFBWalls.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.thefailboat.TFBWalls.Statics;


public class Kick implements CommandExecutor{
	private JavaPlugin plugin;
		
	public Kick(JavaPlugin _plugin){
		this.plugin = _plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lavel, String[] args){
		//TODO: Add message parsing.
		
		//Kick command
		if(cmd.getName().toLowerCase() == "kick"){
			if(args.length > 0){
				Player target = plugin.getServer().getPlayer(args[0]);
				
				if (target == null){
					sender.sendMessage("That player does not exist.");
					return true;
				}
				else{
					target.kickPlayer("Kicked by Admin.");
				}				
			}
		}
		
		//Kickall command
		else if(cmd.getName().toLowerCase() == "kickall"){
			for(Player p : plugin.getServer().getOnlinePlayers()){
				p.kickPlayer("Kicked by Admin.");
			}
		}
		
		
		
		return false;
	}
}
