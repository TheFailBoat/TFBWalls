package uk.co.thefailboat.TFBWalls.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.thefailboat.TFBWalls.Statics;


public class Getpos implements CommandExecutor{
	private JavaPlugin plugin;
		
	public Getpos(JavaPlugin _plugin){
		this.plugin = _plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lavel, String[] args){
		if(sender instanceof Player){
			Player p = (Player)sender;
			Location l = p.getLocation();
			p.sendMessage("You are at: (" + l.getX() + ", " + l.getY() + "," + l.getZ() + ") with pitch " + l.getPitch() + " and yaw " + l.getYaw());
			Statics.log.info(Statics.prefix + "Player " + p.getDisplayName() + " is at: (" + l.getX() + ", " + l.getY() + "," + l.getZ() + ") with pitch " + l.getPitch() + " and yaw " + l.getYaw());
		}
		return true;
	}
}
