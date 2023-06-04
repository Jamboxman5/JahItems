package net.jahcraft.jahitems.listeners;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class JetPackListener implements Listener {
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			ItemStack item = e.getItem();
			
			if (item != null) {
				Player p = e.getPlayer();
				
				if (item.getItemMeta() != null) {
					

					if (item.getItemMeta().getDisplayName().contains("Jet Pack")) {
						
						
						if (item.getItemMeta().getLore().get(2).contains("Offical Jah Donor Item!")) {
							
							e.setCancelled(true);
							
							boolean heightLimitReached = true;
							
							for (int i = 0; i < 80; i++) {
								if (p.getLocation().subtract(0, i, 0).getBlock().getType() != Material.AIR) {
									heightLimitReached = false;
								}
							}
							
							if (!heightLimitReached) {
								p.setVelocity(p.getLocation().getDirection().multiply(.4).setY(.4));
								p.playSound(p.getLocation(), Sound.ITEM_FIRECHARGE_USE, 1f, 1f);
								p.spawnParticle(Particle.FLAME, p.getLocation(), 10);
							} else {
								p.sendMessage(ChatColor.RED + "Height limit reached!");
							}
							
							
						}
					}
				}
			}
			
			
			
		}
		
	}

}
