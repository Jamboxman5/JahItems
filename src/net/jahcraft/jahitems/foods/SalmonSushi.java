package net.jahcraft.jahitems.foods;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class SalmonSushi extends ItemStack {

	public SalmonSushi() {
		
		super(Material.COOKED_SALMON);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.RESET + "Salmon Sushi Roll");
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Zero risk of salmonella.");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
	}
	
}
