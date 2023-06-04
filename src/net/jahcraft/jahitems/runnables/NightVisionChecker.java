package net.jahcraft.jahitems.runnables;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.jahcraft.jahitems.main.Main;

public class NightVisionChecker implements Runnable {
	
	@Override
	public void run() {

		while (Main.checkNVHelmet) {
			
			for (Player p : Bukkit.getOnlinePlayers()) {
				
				if (wearingHelmet(p)) {
					retainEffect(p);
				} else {
					checkEffect(p);
				}
				
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private void retainEffect(Player p) {
		Bukkit.getScheduler().runTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 1, false, false, false));
			}
			
		});
		
	}
	
	private void removeEffect(Player p) {
		Bukkit.getScheduler().runTask(Main.plugin, new Runnable() {

			@Override
			public void run() {
				p.removePotionEffect(PotionEffectType.NIGHT_VISION);
			}
			
		});
		
	}

	private void checkEffect(Player p) {
		if (!p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) return;
		if (p.getPotionEffect(PotionEffectType.NIGHT_VISION).getDuration() > 100000) {
			removeEffect(p);
		}
	}

	private boolean wearingHelmet(Player p) {
		
		ItemStack helm = p.getInventory().getHelmet();
		
		if (helm == null) return false;
		if (helm.getType() != Material.NETHERITE_HELMET) return false;
		
		ItemMeta meta = helm.getItemMeta();
		
		if (!meta.hasCustomModelData()) return false;
		
		int modelData = 0;
		
		try {
			modelData = meta.getCustomModelData();
		} catch (Exception e) {
			
		}
		
		if (modelData != 1) return false;
		
		return true;
	}

}
