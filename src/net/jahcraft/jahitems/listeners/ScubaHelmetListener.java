package net.jahcraft.jahitems.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ScubaHelmetListener implements Listener {

	@EventHandler
	public void onJump(PlayerMoveEvent event) {
		
		Player player = (Player) event.getPlayer();
		ItemStack helm = player.getInventory().getHelmet();
		
		if (isScubaHelmet(helm)) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 1));

		} else if (player.getPotionEffect(PotionEffectType.WATER_BREATHING) != null &&
				   player.getPotionEffect(PotionEffectType.WATER_BREATHING).getDuration() > 99999) {
			
			player.removePotionEffect(PotionEffectType.WATER_BREATHING);

		}
		
	}
	
	private boolean isScubaHelmet(ItemStack i) {
		return (i != null && i.getType() == Material.GLASS && i.hasItemMeta() && i.getItemMeta().isUnbreakable());
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent event) {
		
		Player player = (Player) event.getPlayer();
		ItemStack helm = player.getInventory().getHelmet();
		
		if (isScubaHelmet(helm)) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 1));

		} else if (player.getPotionEffect(PotionEffectType.WATER_BREATHING) != null &&
				   player.getPotionEffect(PotionEffectType.WATER_BREATHING).getDuration() > 99999) {
			
			player.removePotionEffect(PotionEffectType.WATER_BREATHING);

		}
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		ItemStack item = e.getCursor();
		ItemStack oldHelm = p.getEquipment().getHelmet();
		
		if (isScubaHelmet(item)) {
			if (e.getSlotType() == SlotType.ARMOR) {
				
				e.setCancelled(true);
				e.getWhoClicked().setItemOnCursor(oldHelm);
				p.getEquipment().setHelmet(item);
				
			}
		}		
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		ItemStack item = e.getItemInHand();
		
		if (isScubaHelmet(item)) e.setCancelled(true);
		
	}
	
	@EventHandler
	public void onAirClick(PlayerInteractEvent e) {
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			Player p = (Player) e.getPlayer();
			ItemStack item = p.getInventory().getItemInMainHand();
			ItemStack oldHelm = p.getEquipment().getHelmet();
			
			if (isScubaHelmet(item)) {
				p.getEquipment().setHelmet(item);
				p.getInventory().setItemInMainHand(oldHelm);
			}
			
		}
		
	}
	
	@EventHandler
	public void onShiftClick(InventoryClickEvent e) {
		
		if (e.isShiftClick()) {
			Player p = (Player) e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			ItemStack oldHelm = p.getEquipment().getHelmet();
			
			if (isScubaHelmet(item) && !isScubaHelmet(oldHelm)) {
				p.getEquipment().setHelmet(item);
				p.getInventory().setItem(e.getSlot(), oldHelm);
			}
			
		}
		
	}
	
}
