package net.jahcraft.jahitems.foods;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class HotDog extends ItemStack {

	public HotDog() {
		
		super(Material.COOKED_PORKCHOP);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.RESET + "Hot Dog");
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "A footlong weenie.");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
	}
	
}
