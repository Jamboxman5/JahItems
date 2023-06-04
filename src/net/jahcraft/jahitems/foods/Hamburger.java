package net.jahcraft.jahitems.foods;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Hamburger extends ItemStack {

	public Hamburger() {
		
		super(Material.BREAD);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.RESET + "Hamburger");
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Pure artery clogging deliciousness");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
	}
	
}
