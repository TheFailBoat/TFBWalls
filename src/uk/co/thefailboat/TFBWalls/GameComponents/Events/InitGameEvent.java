package uk.co.thefailboat.TFBWalls.GameComponents.Events;

import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.plugin.java.*;

import uk.co.thefailboat.TFBWalls.Statics;
import uk.co.thefailboat.TFBWalls.GameComponents.GameEvent;

public class InitGameEvent extends GameEvent {
	private JavaPlugin plugin;

	public InitGameEvent(JavaPlugin _plugin){
		plugin = _plugin;
	}

	public void run(){
		World world = plugin.getServer().getWorld("world");
		
		int x = 0; int y = 0; int z = 0;
		
		z = Statics.mapz + (Statics.mapdz / 2);
		for(x = Statics.mapx; x < Statics.mapx + Statics.mapdx; x++)
		{
			for(y = 0; y < world.getMaxHeight(); y++)
			{
				Location l = new Location(world, x, y, z);
				Block b = world.getBlockAt(l);
				b.setTypeId(7);
			}
		}
		
		x = Statics.mapx + (Statics.mapdx / 2);
		for(z = Statics.mapz; z < Statics.mapz + Statics.mapdz; z++)
		{
			for(y = 0; y < world.getMaxHeight(); y++)
			{
				Location l = new Location(world, x, y, z);
				Block b = world.getBlockAt(l);
				b.setTypeId(7);
			}
		}
	};
}