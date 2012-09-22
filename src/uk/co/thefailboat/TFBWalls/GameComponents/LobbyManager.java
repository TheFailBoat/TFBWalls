package uk.co.thefailboat.TFBWalls.GameComponents;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.thefailboat.TFBWalls.Main;
import uk.co.thefailboat.TFBWalls.Statics;

public class LobbyManager extends Manager{
	private JavaPlugin plugin;
	private GameTimer lobbyTimer;
	private List<Player> lobbyPlayers = new ArrayList<Player>();
	private PlayerMessagePipe messagePipe = new PlayerMessagePipe();
	private Main instance;
	
	/**
	 * Creates a Lobby Manager which handles all players in A lobby area before A game.
	 * 
	 * LobbyManager handles team assignment (manual or auto) and handles the pre-game countdown before sending players into the arena.
	 * When players are sent into the arena, a new GameManager instance will be created. This handles teams and players during the actual game process.
	 * @param _plugin A plugin instance that can be used to reference the server.
	 * @param _instance The instance of Main that we use to reach GameManagers and such.
	 */
	public LobbyManager(JavaPlugin _plugin, Main _instance){
		
		//Initialize a Lobby Manager, which manages team selection in the Lobby
		
		plugin = _plugin;
		instance = _instance;
		lobbyTimer = new GameTimer(plugin, "Starting the count down...", "The game will commence", "The Game has begun!", 120, new GameEvent(){
			public void run() {
				//TODO: Add code to start a game
			}
		});
		//Create four teams.
		for(int i=1;i<=4;i++){
			teams.add(new Team(plugin, i));
		}
	}
	
	/**
	 * Adds the player to the list of Players in the lobby.
	 * @param player The player to attach to the Lobby.
	 */
	public void AttachPlayer(Player player){
		Statics.log.info(Statics.prefix + "Added player " + player.getDisplayName() + "to this lobby.");
		lobbyPlayers.add(player);
		//this.attemptStart();
	}
	/**
	 * Attempts to start the countdown to pre-game. Checks number of players etc.
	 */
	private void attemptStart() {
		if(lobbyPlayers.size() >= Statics.MinGamePlayers){
			//We have enough players, so make sure they are all in teams.
			for(Player p : lobbyPlayers){
				if(GetPlayersTeamNumber(p) == -1){
					autoAssignTeam(p);
					p.sendMessage(ChatColor.GOLD + "You have been automatically assigned to Team " + GetPlayersTeam(p).GetNumber());
				}
			}
		}
	}
	
	/**
	 * Assigns a player to the first team with a space
	 * @param player The player to add
	 */
	private void autoAssignTeam(Player player){
		if(GetPlayersTeamNumber(player) != -1) return; //We do NOT want a player to appear in multiple teams...
		for(Team t : teams){
			if(!t.isFull){
				t.AddPlayer(player);
			}
		}
	}

	/**
	 * Removes the player from the list of Players in the lobby
	 * @param player The player to remove from the Lobby.
	 */
	public void DetatchPlayer(Player player){
		lobbyPlayers.remove(player);
	}
	
	/**
	 * Starts the pre-game Timer that warns players that the game will commence.
	 */
	public void StartTimer(){
		lobbyTimer.Start();
	}
}
