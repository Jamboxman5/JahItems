package net.jahcraft.jahitems.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisionHelmetListener implements Listener {
	
	@EventHandler
	public void onJump(PlayerMoveEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (player.getInventory().getHelmet() != null && player.getInventory().getHelmet().hasItemMeta()) {
		
			if (player.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Night Vision Helmet")) {
			
				if (player.getInventory().getHelmet().getItemMeta().getLore().get(2).contains("Offical Jah Donor Item!")) {
				
					player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 1));
						
					
				} else {
					
					if (player.getPotionEffect(PotionEffectType.NIGHT_VISION) != null ) {
						if (player.getPotionEffect(PotionEffectType.NIGHT_VISION).getDuration() > 99999) {
							player.removePotionEffect(PotionEffectType.NIGHT_VISION);
						}
					}
					
				}
			}else {
				
				if (player.getPotionEffect(PotionEffectType.NIGHT_VISION) != null ) {
					if (player.getPotionEffect(PotionEffectType.NIGHT_VISION).getDuration() > 99999) {
						player.removePotionEffect(PotionEffectType.NIGHT_VISION);
					}
				}
			}
		}else {
			
			if (player.getPotionEffect(PotionEffectType.NIGHT_VISION) != null ) {
				if (player.getPotionEffect(PotionEffectType.NIGHT_VISION).getDuration() > 99999) {
					player.removePotionEffect(PotionEffectType.NIGHT_VISION);
				}
			}
			
		}
		
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (player.getInventory().getHelmet() != null && player.getInventory().getHelmet().hasItemMeta()) {
		
			if (player.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Night Vision Helmet")) {
			
				if (player.getInventory().getHelmet().getItemMeta().getLore().get(2).contains("Offical Jah Donor Item!")) {
				
					player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 1));
						
					
				} else {
					
					if (player.getPotionEffect(PotionEffectType.NIGHT_VISION) != null ) {
						if (player.getPotionEffect(PotionEffectType.NIGHT_VISION).getDuration() > 99999) {
							player.removePotionEffect(PotionEffectType.NIGHT_VISION);
						}
					}
					
				}
			}else {
				
				if (player.getPotionEffect(PotionEffectType.NIGHT_VISION) != null ) {
					if (player.getPotionEffect(PotionEffectType.NIGHT_VISION).getDuration() > 99999) {
						player.removePotionEffect(PotionEffectType.NIGHT_VISION);
					}
				}
			}
		}else {
			
			if (player.getPotionEffect(PotionEffectType.NIGHT_VISION) != null ) {
				if (player.getPotionEffect(PotionEffectType.NIGHT_VISION).getDuration() > 99999) {
					player.removePotionEffect(PotionEffectType.NIGHT_VISION);
				}
			}
			
		}
		
	}

}
