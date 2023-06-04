package net.jahcraft.jahitems.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class JetPack extends ItemStack {

	public JetPack() {
		
		super(Material.FIREWORK_STAR);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(1);
		meta.setUnbreakable(true);
		meta.setDisplayName(ChatColor.of("#FFD700") + "Jet Pack");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		lore.add(ChatColor.of("#FFD700") + "" + ChatColor.BOLD + "Offical Jah Donor Item!");
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		lore.add("");
		lore.add(ChatColor.of("#779AD8") + "The ultimate vehicle for");
		lore.add(ChatColor.of("#779AD8") + "having a good time!");
		lore.add("");
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		lore.add("");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
		
		
	}
	
}
