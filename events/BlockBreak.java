package tm.drop.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import io.netty.util.internal.ThreadLocalRandom;
import tm.drop.object.DropChance;

public class BlockBreak implements Listener {
	
	DropChance[] drops = {
			new DropChance(Material.DIAMOND, 15),
			new DropChance(Material.GOLD_INGOT, 35),
			new DropChance(Material.EMERALD, 25),
			new DropChance(Material.STICK, 70)
	};
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(e.getBlock().getType() != Material.STONE) return;
		
		Player p = e.getPlayer();
		
		int random = ThreadLocalRandom.current().nextInt(1, 100);
		
		for(DropChance drop : drops) {
			if(drop.getChance() >= random) { p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(drop.getMaterial())); }
		}
	}
	
	

}
