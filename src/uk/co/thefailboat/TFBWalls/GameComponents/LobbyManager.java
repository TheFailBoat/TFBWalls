package uk.co.thefailboat.TFBWalls.GameComponents;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.thefailboat.TFBWalls.Main;
import uk.co.thefailboat.TFBWalls.Statics;

public class LobbyManager {
	private JavaPlugin plugin;
	private GameTimer lobbyTimer;
	private List<Team> teams = new ArrayList<Team>();
	private List<Player> lobbyPlayers = new ArrayList<Player>();
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
