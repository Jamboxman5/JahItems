package net.jahcraft.jahitems.listeners;

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
		
		if (player.getInventory().getHelmet() != null) {
		
			if (player.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Scuba Helmet")) {
			
				if (player.getInventory().getHelmet().getItemMeta().getLore().get(2).contains("Offical Jah Donor Item!")) {
				
					player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 1));
						
					
				} else {
					
					if (player.getPotionEffect(PotionEffectType.WATER_BREATHING) != null ) {
						if (player.getPotionEffect(PotionEffectType.WATER_BREATHING).getDuration() > 1000) {
							player.removePotionEffect(PotionEffectType.WATER_BREATHING);
						}
					}
					
				}
			}else {
				
				if (player.getPotionEffect(PotionEffectType.WATER_BREATHING) != null ) {
					if (player.getPotionEffect(PotionEffectType.WATER_BREATHING).getDuration() > 1000) {
						player.removePotionEffect(PotionEffectType.WATER_BREATHING);
					}
				}
			}
		}else {
			
			if (player.getPotionEffect(PotionEffectType.WATER_BREATHING) != null ) {
				if (player.getPotionEffect(PotionEffectType.WATER_BREATHING).getDuration() > 1000) {
					player.removePotionEffect(PotionEffectType.WATER_BREATHING);
				}
			}
			
		}
		
	}
	
	@EventHandler
	public void onClose(InventoryCloseEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (player.getInventory().getHelmet() != null) {
		
			if (player.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Scuba Helmet")) {
			
				if (player.getInventory().getHelmet().getItemMeta().getLore().get(2).contains("Offical Jah Donor Item!")) {
				
					player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 1));
						
					
				} else {
					
					if (player.getPotionEffect(PotionEffectType.WATER_BREATHING) != null ) {
						if (player.getPotionEffect(PotionEffectType.WATER_BREATHING).getDuration() > 1000) {
							player.removePotionEffect(PotionEffectType.WATER_BREATHING);
						}
					}
					
				}
			}else {
				
				if (player.getPotionEffect(PotionEffectType.WATER_BREATHING) != null ) {
					if (player.getPotionEffect(PotionEffectType.WATER_BREATHING).getDuration() > 1000) {
						player.removePotionEffect(PotionEffectType.WATER_BREATHING);
					}
				}
			}
		}else {
			
			if (player.getPotionEffect(PotionEffectType.WATER_BREATHING) != null ) {
				if (player.getPotionEffect(PotionEffectType.WATER_BREATHING).getDuration() > 1000) {
					player.removePotionEffect(PotionEffectType.WATER_BREATHING);
				}
			}
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		Player p = (Player) e.getWhoClicked();
		ItemStack item = e.getCursor();
		ItemStack oldHelm = p.getEquipment().getHelmet();
		
		if (item.getItemMeta() != null) {
						

			if (item.getItemMeta().getDisplayName().contains("Scuba Helmet")) {
				
				
				if (item.getItemMeta().getLore().get(2).contains("Offical Jah Donor Item!")) {
					
					
					if (e.getSlotType() == SlotType.ARMOR) {
						
						e.setCancelled(true);
						e.setCursor(oldHelm);
						p.getEquipment().setHelmet(item);
						
					}
					
				}
				
			}
			
		}

		
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		ItemStack item = e.getItemInHand();
		
		if (item.getItemMeta() != null) {
			

			if (item.getItemMeta().getDisplayName().contains("Scuba Helmet")) {
				
				
				if (item.getItemMeta().getLore().get(2).contains("Offical Jah Donor Item!")) {
					
					e.setCancelled(true);
					
				}
			}
		}
	}
	
	@EventHandler
	public void onAirClick(PlayerInteractEvent e) {
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			Player p = (Player) e.getPlayer();
			ItemStack item = p.getInventory().getItemInMainHand();
			ItemStack oldHelm = p.getEquipment().getHelmet();
			
			if (item.getItemMeta() != null) {
				if (oldHelm == null) {
					if (item.getItemMeta().getDisplayName().contains("Scuba Helmet")) {
						if (item.getItemMeta().getLore().get(2).contains("Offical Jah Donor Item!")) {
							p.getEquipment().setHelmet(item);
							p.getInventory().setItemInMainHand(null);
						}
					}
				}
			}
			
		}
		
	}
	
	@EventHandler
	public void onShiftClick(InventoryClickEvent e) {
		
		if (e.isShiftClick()) {
			Player p = (Player) e.getWhoClicked();
			ItemStack item = e.getCurrentItem();
			ItemStack oldHelm = p.getEquipment().getHelmet();
			
			if (item != null) {
				if (item.getItemMeta() != null) {
					if (oldHelm == null) {
						if (item.getItemMeta().getDisplayName().contains("Scuba Helmet")) {
							if (item.getItemMeta().getLore().get(2).contains("Offical Jah Donor Item!")) {
								p.getEquipment().setHelmet(item);
								p.getInventory().setItem(e.getSlot(), null);
							}
						}
					}
				}
			}
			
		}
		
	}
	
}
