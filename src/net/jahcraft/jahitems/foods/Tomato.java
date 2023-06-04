package net.jahcraft.jahitems.foods;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Tomato extends ItemStack {

	public Tomato() {
		
		super(Material.APPLE);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(7);
		meta.setDisplayName(ChatColor.RESET + "Tomato");
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "\"I hope it's an heirloom!\"");
		lore.add(ChatColor.GRAY + "-SlickNick73, 2021");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
	}
	
}
