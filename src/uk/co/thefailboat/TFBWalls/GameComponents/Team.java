package uk.co.thefailboat.TFBWalls.GameComponents;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Team {
	private int number;
	public boolean isFull;
	
	private JavaPlugin plugin;
	private List<Player> players = new ArrayList<Player>();
	
	public Team(JavaPlugin _plugin, int _number){
		number = _number;
		plugin = _plugin;
	}
	
	/**
	 * Gets the list of Players in the team.
	 * @return The list of players.
	 */
	public List<Player> GetPlayers(){
		return players;
	}
	
	/**
	 * Send a message to all Players in the Team
	 * @param message The message to send.
	 */
	public void MessagePlayers(String message){
		for(Player p : players){
			p.sendMessage(message);
		}
	}
	/**
	 * Adds a player to the team.
	 * @param player The player to add.
	 * @return False if the team is already full
	 */
	public boolean AddPlayer(Player player){
		if(isFull) return false;
		
		players.add(player);
		isFull = players.size() == 2 ? true : false;
		//TODO: Logging should be global
		//parent.log.info("Added " + player.getDisplayName() + " to Team " + Number);
		return false;
	}
	/**
	 * Removes a player from the team.
	 * @param player The player to remove.
	 * @return False if the player is not in the team.
	 */
	public boolean RemovePlayer(Player player){
		if(players.contains(player)){
			players.remove(player);
			//TODO: Logging should be global
			//parent.log.info("Removed " + player.getDisplayName() + " from Team " + Number);
			return true;
		}
		return false;
	}
	/**
	 * Get the team number
	 * @return An integer that is the team number
	 */
	public int GetNumber(){
		return number;
	}
}