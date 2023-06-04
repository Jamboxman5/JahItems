package net.jahcraft.jahitems.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.jahitems.util.ItemStorage;
import net.md_5.bungee.api.ChatColor;

public class ItemGetter implements CommandExecutor {
	
	public static Inventory menu;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if (label.equalsIgnoreCase("itemgetter")) {
			
			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			if (!p.hasPermission("jahcraft.admin")) {
				p.sendMessage(ChatColor.RED + "You do not have permission to do that!");
				return true;
			}
			
			if (args.length != 1) {
				p.sendMessage(ChatColor.RED + "Usage: /itemgetter <itemname>");
				return true;
			}
			
			String itemName = args[0].toLowerCase();
			
			if (itemName.equals("list")) {
				
				p.openInventory(menu);
				return true;
			}
			
			if (!ItemStorage.itemGetter.containsKey(itemName)) {
				p.sendMessage(ChatColor.RED + "Usage: /itemgetter <itemname>");
				return true;
			}
			
			if (ItemStorage.itemGetter.containsKey(itemName)) {
				
				ItemStack item = ItemStorage.itemGetter.get(itemName);
				String iName = item.getItemMeta().getDisplayName().toString();
				
				if (p.getInventory().firstEmpty() == -1 ) {
					
					// full inventory
					
					Location loc = p.getLocation();
					World world = p.getWorld();
					
					world.dropItemNaturally(loc, item);
					p.sendMessage(ChatColor.of("#49B3FF") + "Inventory full. 1x " + iName + ChatColor.of("#49B3FF") + " dropped at your feet.");
					
					return true;
					
				}
				
				p.getInventory().addItem(item);
				p.sendMessage(ChatColor.of("#49B3FF") + "You received 1x " + iName + ChatColor.of("#49B3FF") + ".");
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public static Inventory createList() {
		
		Inventory inv = Bukkit.createInventory(null, 54, "JahItems List");
		
		for (ItemStack i : ItemStorage.itemGetter.values()) {
			
			inv.addItem(i);
			
		}
		
		return inv;
		
	}

}
