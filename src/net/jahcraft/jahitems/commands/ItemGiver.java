package net.jahcraft.jahitems.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.jahitems.util.ItemStorage;
import net.md_5.bungee.api.ChatColor;

public class ItemGiver implements CommandExecutor {

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if (label.equalsIgnoreCase("itemgiver")) {
			
			if (!sender.hasPermission("jahcraft.admin")) {
				sender.sendMessage(ChatColor.RED + "You do not have permission to do that!");
				return true;
			}
			
			if (args.length != 2 || Bukkit.getServer().getPlayer(args[1]) == null) {
				sender.sendMessage(ChatColor.RED + "Usage: /itemgiver <itemname> <playername>");
				return true;
			}
			
			String itemName = args[0].toLowerCase();
			
			if (!ItemStorage.itemGetter.containsKey(itemName)) {
				sender.sendMessage(ChatColor.RED + "Usage: /itemgiver <itemname> <playername>");
				return true;
			}
			
							
			ItemStack item = ItemStorage.itemGetter.get(itemName);
			String iName = item.getItemMeta().getDisplayName().toString();
			Player target = Bukkit.getServer().getPlayer(args[1]);
			
			if (target.getInventory().firstEmpty() == -1 ) {
					
				// full inventory
					
				Location loc = target.getLocation();
				World world = target.getWorld();
					
				world.dropItemNaturally(loc, item);
				target.sendMessage(ChatColor.AQUA + "Inventory full. 1x " + iName + ChatColor.AQUA + " dropped at your feet.");
				sender.sendMessage(ChatColor.AQUA + "Inventory full. 1x " + iName + ChatColor.AQUA + " dropped at their  feet.");
					
				return true;
					
			}
				
			target.getInventory().addItem(item);
			target.sendMessage(ChatColor.AQUA + "You received 1x " + iName + ChatColor.AQUA + ".");
			sender.sendMessage(ChatColor.AQUA + "They received 1x " + iName + ChatColor.AQUA + ".");
				
			return true;
				
		}
		
		return false;
		
	}
	
}
