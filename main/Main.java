package themlody.tutorial2.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable() {
		getLogger().info("Plugin siê wl¹cza...");
		
		getServer().getPluginManager().registerEvents(this, this);
	
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(e.getBlock().getType() == (Material.DIAMOND_ORE)) {;
			getLogger().info("Gracz " + p.getName() + " Wykopa³ rude diamentu" );
			for(Player players : Bukkit.getOnlinePlayers()) {
				if(players.isOp()) {
					p.sendMessage(ChatColor.GRAY + "Gracz" + ChatColor.AQUA + p.getName() + ChatColor.GRAY + "Wykopa³ rude diamentu.");
				}
			}
		}
		
	}

}
