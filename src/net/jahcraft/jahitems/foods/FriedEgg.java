package net.jahcraft.jahitems.foods;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class FriedEgg extends ItemStack {

	public FriedEgg() {
		
		super(Material.POTATO);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.RESET + "Fried Egg");
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "This'll put hair on your chest.");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
	}
	
}
