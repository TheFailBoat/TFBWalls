package uk.co.thefailboat.TFBWalls.GameComponents;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

/**
 * 
 * Allows things like timers and managers to easily target specific players in a broadcast message.
 */
public class PlayerMessagePipe {
	private List<Player> players = new ArrayList<Player>();
	
	public boolean AddPlayer(Player player){
		if(players.contains(player)) return false;
		players.add(player);
		return true;
	}
	
	public boolean RemovePlayer(Player player){
		if(!players.contains(player)) return false;
		players.remove(player);
		return true;
	}
	
	public boolean ClearPlayers(){
		players = new ArrayList<Player>();
		return true;
	}
	
	public int GetPlayerCount(){
		return players.size();
	}
	
	public List<Player> GetPlayers(){
		return players;
	}
	
	public void SendMessage(String message){
		for(Player p : players){
			p.sendMessage(message);
		}
	}
	
}
