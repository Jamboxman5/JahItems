package net.jahcraft.jahitems.foods;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class PepperoniStick extends ItemStack {

	public PepperoniStick() {
		
		super(Material.BEEF);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(3);
		meta.setDisplayName(ChatColor.RESET + "Pepperoni Stick");
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "The quintessential pizza topping.");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
	}
	
}
