package uk.co.thefailboat.TFBWalls.command;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.thefailboat.TFBWalls.Main;
import uk.co.thefailboat.TFBWalls.Statics;

/**
 * Executes the /team command in-game
 * @author James
 *
 */
public class Team implements CommandExecutor{
	private Main instance;
		
	public Team(Main _instance){
		this.instance = _instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lavel, String[] args){
		//Not from console please.
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
			return true;
		}
		//We need args...
		if(args.length == 0){
			sender.sendMessage(ChatColor.RED + "You must provide a team number (1-4) or the \"leave\" command!");
			return false;
		}
		
		Player player = (Player)sender;
		int teamNum;
			
		//Asking to leave?
		if(args[0].toLowerCase().equals("leave")){
			if(instance.Lobby.GetPlayersTeamNumber(player) == -1){
				sender.sendMessage(ChatColor.RED+ "You are not in a team!");
				return true;
			}
			instance.Lobby.RemovePlayerFromAllTeams(player);
			sender.sendMessage(ChatColor.GREEN + "You have been removed from all teams.");
			return true;
		}
		
		//Already in a team?
		if(instance.Lobby.GetPlayersTeamNumber(player) != -1){
			sender.sendMessage(ChatColor.RED + "You are already in a team! To leave it, type /team leave");
			return true;
		}
		
		//Attempt to convert arg[0] to an int.
		try{
			teamNum = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException e){
			sender.sendMessage(ChatColor.RED + args[0] + " is not a valid team number. Specify a valid team number (1-4)");
			return false;
		}
		
		
		uk.co.thefailboat.TFBWalls.GameComponents.Team t = instance.Lobby.GetTeamByNumber(teamNum);
		
		//Does such a team exist?
		if(t == null){
			sender.sendMessage(ChatColor.RED + args[0] + " is not a valid team number. Specify a valid team number (1-4)");
			return false;
		}
		//Is the team already full (2 players)?
		if(t.isFull){
			sender.sendMessage(ChatColor.RED + args[0] + " Team " + t.GetNumber() + " is already full.");
			return true;
		}
		//Passed all checks, add the player to the team
		else{
			t.AddPlayer(player);
			player.sendMessage(ChatColor.GREEN + "You are now in Team " + t.GetNumber());
			return true;
		}
	}
}
