package uk.co.thefailboat.TFBWalls.GameComponents;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
/**
 * Provides locations for spawns and other map objects that managers and events need.
 * @author James
 *
 */
public class MapReferences {
	private JavaPlugin plugin;
	/**
	 * A list of Team Spawns (Integer represents Team Number)
	 */
	public HashMap<Integer, ArrayList<Location>> TeamSpawns = new HashMap<Integer, ArrayList<Location>>();
	private World wallsWorld;

	public MapReferences(JavaPlugin _plugin){
		plugin = _plugin;
		wallsWorld = plugin.getServer().getWorld("world");
		
		ArrayList<Location> team1Spawns = new ArrayList<Location>();
		team1Spawns.add(new Location(wallsWorld, 0, 0, 0, 0, 0));
		team1Spawns.add(new Location(wallsWorld, 0, 0, 0, 0, 0));
		
		ArrayList<Location> team2Spawns = new ArrayList<Location>();
		team2Spawns.add(new Location(wallsWorld, 0, 0, 0, 0, 0));
		team2Spawns.add(new Location(wallsWorld, 0, 0, 0, 0, 0));
		
		ArrayList<Location> team3Spawns = new ArrayList<Location>();
		team3Spawns.add(new Location(wallsWorld, 0, 0, 0, 0, 0));
		team3Spawns.add(new Location(wallsWorld, 0, 0, 0, 0, 0));
		
		ArrayList<Location> team4Spawns = new ArrayList<Location>();
		team4Spawns.add(new Location(wallsWorld, 0, 0, 0, 0, 0));
		team4Spawns.add(new Location(wallsWorld, 0, 0, 0, 0, 0));
		
		
		TeamSpawns.put(1, team1Spawns);
		TeamSpawns.put(2, team2Spawns);
		TeamSpawns.put(3, team3Spawns);
		TeamSpawns.put(4, team4Spawns);
	}
}
