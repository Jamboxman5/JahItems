package net.jahcraft.jahitems.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class BanHammer extends ItemStack {

	public BanHammer() {
		
		super(Material.DIAMOND_AXE);
		
		ItemMeta meta = getItemMeta();
		meta.setCustomModelData(1);
		meta.setDisplayName(ChatColor.of("#FFD700") + "" + ChatColor.BOLD + "The Ban Hammer Mk. II");
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		lore.add(ChatColor.of("#00E8FF") + "Players hit with this hammer");
		lore.add(ChatColor.of("#00E8FF") + "will be instantly banned!");
		lore.add(ChatColor.of("#00E8FF") + "The Ban Hammer Has Spoken!");
		lore.add(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=-=-=-=-=-=-=");
		meta.setLore(lore);
		
		setItemMeta(meta);
		
	}
		
}
