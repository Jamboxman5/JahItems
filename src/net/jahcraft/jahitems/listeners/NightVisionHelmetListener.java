package net.jahcraft.jahitems.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVisionHelmetListener implements Listener {
	
	@EventHandler
	public void onJump(PlayerMoveEvent event) {
		
		Player player = (Player) event.getPlayer();
		ItemStack helm = player.getInventory().getHelmet();
		
		if (isNightVisionHelmet(helm)) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 1));

		} else if (player.getPotionEffect(PotionEffectType.NIGHT_VISION) != null &&
				   player.getPotionEffect(PotionEffectType.NIGHT_VISION).getDuration() > 99999) {
			
			player.removePotionEffect(PotionEffectType.NIGHT_VISION);

		}
		
	}
	
	private boolean isNightVisionHelmet(ItemStack i) {
		return (i != null && i.getType() == Material.NETHERITE_HELMET && i.hasItemMeta() && i.getItemMeta().getCustomModelData() == 1);
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent event) {
		
		Player player = (Player) event.getPlayer();
		ItemStack helm = player.getInventory().getHelmet();
		
		if (isNightVisionHelmet(helm)) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 1));

		} else if (player.getPotionEffect(PotionEffectType.NIGHT_VISION) != null &&
				   player.getPotionEffect(PotionEffectType.NIGHT_VISION).getDuration() > 99999) {
			
			player.removePotionEffect(PotionEffectType.NIGHT_VISION);

		}
		
	}

}
