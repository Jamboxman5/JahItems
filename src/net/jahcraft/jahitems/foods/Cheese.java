package net.jahcraft.jahitems.foods;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Cheese extends ItemStack {

	public Cheese() {
		
		super(Material.POTATO);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(2);
		meta.setDisplayName(ChatColor.RESET + "Cheese");
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "It ain't easy bein' cheesy.");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
	}
	
}
