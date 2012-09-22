package uk.co.thefailboat.TFBWalls.GameComponents;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

/**
 * Provides common functions for LobbyManagers, GameManagers and the like. Should not be initialized on its own, but extended.
 * @author James
 *
 */
public class Manager {
	protected List<Team> teams = new ArrayList<Team>();  
	
	/**
	 * Get the team number of the player in question.
	 * @param player The player to search for
	 * @return Team number, or -1 for no team.
	 */
	public int GetPlayersTeamNumber(Player player){
		for(Team t : teams){
			if(t.ContainsPlayer(player)) return t.GetNumber();
		}
		return -1;
	}
	
	public Team GetPlayersTeam(Player player){
		for(Team t : teams){
			if(t.ContainsPlayer(player)) return t;
		}
		return null;
	}
	
	/**
	 * Get the list of teams in the manager.
	 * @return List of Teams.
	 */
	public List<Team> GetTeams(){
		return teams;
	}
	
	/**
	 * Get a team by its number.
	 * @param number The number of the team to get
	 * @return The team specified, or null if no team under that number.
	 */
	public Team GetTeamByNumber(int number){
		for (Team t : teams){
			if(t.GetNumber() == number) return t;
		}
		return null;
	}
	/**
	 * Remove the player from all teams, although they should only be in one at any time!
	 * @param player The player to remove from all teams.
	 */
	public void RemovePlayerFromAllTeams(Player player){
		for(Team t : teams){
			t.RemovePlayer(player);
		}
	}
}
