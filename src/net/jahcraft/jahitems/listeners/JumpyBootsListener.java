package net.jahcraft.jahitems.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import net.md_5.bungee.api.ChatColor;

public class JumpyBootsListener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	
	public void onJump(PlayerMoveEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (player.getInventory().getBoots() != null) {
		
			if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Jumpy Boots")) {
			
				if (player.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.of("#FFD700") + "" + ChatColor.BOLD + "Offical Jah Donor Item!")) {
				
					if (!player.isSneaking()) {
						
						double jumpVelocity = (double) 0.42F;
						if (player.hasPotionEffect(PotionEffectType.JUMP)) {
							jumpVelocity += (double) ((float) (player.getPotionEffect(PotionEffectType.JUMP).getAmplifier() + 1) * 0.1F);
						}
						
						if (event.getFrom().getY() < event.getTo().getY() &&
//							player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR &&
							player.getLocation().getBlock().getType() != Material.LADDER &&
							!player.isOnGround()
							&& Double.compare(player.getVelocity().getY(), jumpVelocity) == 0) {
							player.setVelocity(player.getVelocity().add(new Vector(0,.5,0)));
							
						}
					}
					
				}
			}
		}
		
	}
	
	@EventHandler
	
	public void onFall(EntityDamageEvent event) {
	
		if (event.getEntity() instanceof Player) {
		
			Player player = (Player) event.getEntity();
			
			if (event.getCause() == DamageCause.FALL) {
			
				if (player.getInventory().getBoots() != null)
				
					if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Jumpy Boots"))
					
						if (player.getInventory().getBoots().getItemMeta().getLore().get(2).contains("Offical Jah Donor Item!")) {
							event.setCancelled(true);
							
				}
				
			}
			
		}
		
	}

}
