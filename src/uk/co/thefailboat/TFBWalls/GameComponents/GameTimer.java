package uk.co.thefailboat.TFBWalls.GameComponents;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.Note.Tone;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GameTimer {
	
	private String countDownMessage;
	private String countOverMessage;
	private String countStartMessage;
	private int secsLeft;
	private int seconds;
	private Timer timer = new Timer();
	private boolean running;
	private Map<Integer, String> timerMessages = new HashMap<Integer, String>();
	private JavaPlugin plugin;
	private GameEvent event;
	
	public GameTimer(JavaPlugin _plugin, String _countStartMessage, String _countDownMessage, String _countOverMessage, int _seconds, GameEvent _event){
		countStartMessage = _countStartMessage;
		countOverMessage = _countOverMessage;
		countDownMessage = _countDownMessage;
		plugin = _plugin;
		seconds = _seconds; //store the original seconds, so we can restart the timer with its defaults.
		secsLeft = seconds + 1; //when we tick for the first time, this will enable a message to appear if specified.
		event = _event; //will execute when time is up.
		timerMessages.put(900, ChatColor.GOLD + "in 15 Minutes.");
		timerMessages.put(840, ChatColor.GOLD + "in 14 Minutes.");
		timerMessages.put(780, ChatColor.GOLD + "in 13 Minutes.");
		timerMessages.put(720, ChatColor.GOLD + "in 12 Minutes.");
		timerMessages.put(660, ChatColor.GOLD + "in 11 Minutes.");
		timerMessages.put(600, ChatColor.GOLD + "in 10 Minutes.");
		timerMessages.put(540, ChatColor.GOLD + "in 9 Minutes.");
		timerMessages.put(480, ChatColor.GOLD + "in 8 Minutes.");
		timerMessages.put(420, ChatColor.GOLD + "in 7 Minutes.");
		timerMessages.put(360, ChatColor.GOLD + "in 6 Minutes.");
		timerMessages.put(300, ChatColor.GOLD + "in 5 Minutes.");
		timerMessages.put(240, ChatColor.GOLD + "in 4 Minutes.");
		timerMessages.put(180, ChatColor.GOLD + "in 3 Minutes.");
		timerMessages.put(120, ChatColor.GOLD + "in 2 Minutes.");
		timerMessages.put(60, ChatColor.RED + "in 1 Minute!");
		timerMessages.put(30, ChatColor.RED + "in 30 Seconds!");
		timerMessages.put(20, ChatColor.RED + "in 20 Seconds!");
		timerMessages.put(10, ChatColor.RED + "in 10 Seconds!");
		timerMessages.put(9, ChatColor.RED + "in 9 Seconds!");
		timerMessages.put(8, ChatColor.RED + "in 8 Seconds!");
		timerMessages.put(7, ChatColor.RED + "in 7 Seconds!");
		timerMessages.put(6, ChatColor.RED + "in 6 Seconds!");
		timerMessages.put(5, ChatColor.RED + "in 5 Seconds!");
		timerMessages.put(4, ChatColor.RED + "in 4 Seconds!");
		timerMessages.put(3, ChatColor.RED + "in 3 Seconds!");
		timerMessages.put(2, ChatColor.RED + "in 2 Seconds!");
		timerMessages.put(1, ChatColor.RED + "in 1 Second!");
	}
	
	public boolean Running(){
		return running ? true : false;
	}
	
	public void Restart(){
		secsLeft = seconds + 1;
		this.Start();
	}
	
	public void Start(){
		running = true;
		plugin.getServer().broadcastMessage(ChatColor.AQUA + countStartMessage);
		tick();
	}
	
	public void Stop(){
		running = false;
	}
	
	private void tick(){
		secsLeft--;
		if(!running) return; //if we stop running, don't tick.
		if(secsLeft == 0){
			plugin.getServer().broadcastMessage(ChatColor.RED + countOverMessage);
			event.run();
			return; //don't want to tick again!
		}
		else if(timerMessages.containsKey(secsLeft)){
			//Print the message to every player
			plugin.getServer().broadcastMessage(ChatColor.AQUA + countDownMessage + " " + timerMessages.get(secsLeft));
			for(Player p : plugin.getServer().getOnlinePlayers()){
				p.playNote(p.getLocation(), Instrument.BASS_GUITAR, Note.natural(1, Tone.C));
			}
		}
		
		timer.schedule(new TimerTask(){
			public void run() {
				tick();
				
			}
		}, 1000);
	}
	
}
