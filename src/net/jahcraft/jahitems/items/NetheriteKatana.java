package net.jahcraft.jahitems.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class NetheriteKatana extends ItemStack { 
	
	public NetheriteKatana() {
		
		super(Material.NETHERITE_SWORD);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(1);
		meta.setUnbreakable(true);
		meta.setDisplayName(ChatColor.of("#FFD700") + "Katana");
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		lore.add(ChatColor.of("#FFD700") + "" + ChatColor.BOLD + "Offical Jah Donor Item!");
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		lore.add("");
		lore.add(ChatColor.of("#779AD8") + "Authentic samurai weapon.");
		lore.add(ChatColor.of("#779AD8") + "Use with care.");
		lore.add("");
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		lore.add("");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
		
	}

}
