package uk.co.thefailboat.TFBWalls.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.thefailboat.TFBWalls.Statics;


public class ToggleFreeze implements CommandExecutor{
	private JavaPlugin plugin;
		
	public ToggleFreeze(JavaPlugin _plugin){
		this.plugin = _plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lavel, String[] args){
		Player target = null;
		if(args.length == 0 && !(sender instanceof Player)){
			sender.sendMessage("You must target a player from the console.");
			return false;
		}
		if(args.length == 0 && sender instanceof Player) target = (Player)sender;
		else if(args.length > 0) target = plugin.getServer().getPlayer(args[0]);
		
		if(target == null){
			sender.sendMessage(ChatColor.RED + "No target could be found.");
			return true;
		}
		
		if(Statics.FrozenPlayers.contains(target)){
			Statics.FrozenPlayers.remove(target);
			sender.sendMessage(ChatColor.AQUA + target.getDisplayName() + " has been unfrozen.");
			Statics.log.info(target.getDisplayName() + " has been unfrozen by " + sender.getName() + "!");
		}else{
			Statics.FrozenPlayers.add(target);
			sender.sendMessage(ChatColor.AQUA + target.getDisplayName() + " has been frozen.");
			Statics.log.info(target.getDisplayName() + " has been frozen by " + sender.getName() + "!");
		}
		return true;
	}
}
