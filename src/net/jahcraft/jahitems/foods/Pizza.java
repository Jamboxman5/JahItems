package net.jahcraft.jahitems.foods;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Pizza extends ItemStack {

	public Pizza() {
		
		super(Material.PUMPKIN_PIE);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.RESET + "Pepperoni Pizza");
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Better Ingredients. Better Pizza.");
		lore.add(ChatColor.GRAY + "~~ Papa Jah's ~~");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
	}
	
}
