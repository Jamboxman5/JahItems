package net.jahcraft.jahitems.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.jahcraft.jahitems.items.Ticket;
import net.md_5.bungee.api.ChatColor;

public class TicketGiver implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("ticketgiver")) {
			
			
			//CONSOLE
			if (!(sender instanceof Player)) {
				if (args.length < 3) {
					sender.sendMessage(ChatColor.RED + "Usage: /ticketgiver {player} {package_name} {amount}");
					return true;
				}
				
				String targetName = args[0];
				int amount = Integer.parseInt(args[1]);
				
				if (Bukkit.getServer().getPlayer(targetName) == null) {
					
					sender.sendMessage(ChatColor.RED + "Player not found!");
					return true;
					
				}
				
				StringBuilder type = new StringBuilder("");
				for (int i = 2; i < args.length; i++) {
					type.append(args[i]);
					type.append(" ");
				}
				
				Player target = Bukkit.getServer().getPlayer(targetName);
				
				if (target.getInventory().firstEmpty() == -1 ) {
					
					// full inventory
					
					Location loc = target.getLocation();
					World world = target.getWorld();
					
					world.dropItemNaturally(loc, new Ticket(type.toString(), amount));
					target.sendMessage(ChatColor.AQUA + "Inventory full. " + amount + "x Ticket dropped at your feet.");
					
					return true;
					
				}
				
				target.getInventory().addItem(new Ticket(type.toString(), amount));
				target.sendMessage(ChatColor.AQUA + "You received " + amount + "x Ticket.");
				
				return true;
			}
			
			
			//PLAYER
			Player p = (Player) sender;
			
			if (!p.hasPermission("jahcraft.admin")) {
				p.sendMessage(ChatColor.RED + "You do not have permission to do that!");
				return true;
			}
			if (args.length < 3) {
				sender.sendMessage(ChatColor.RED + "Usage: /ticketgiver {player} {amount} {package_name}");
				return true;
			}
			
			String targetName = args[0];
			int amount = Integer.parseInt(args[1]);
			
			if (Bukkit.getServer().getPlayer(targetName) == null) {
				
				sender.sendMessage(ChatColor.RED + "Player not found!");
				return true;
				
			}
			
			StringBuilder type = new StringBuilder("");
			for (int i = 2; i < args.length; i++) {
				type.append(args[i]);
				type.append(" ");
			}
			
			Player target = Bukkit.getServer().getPlayer(targetName);
			
			if (target.getInventory().firstEmpty() == -1 ) {
				
				// full inventory
				
				Location loc = target.getLocation();
				World world = target.getWorld();
				
				world.dropItemNaturally(loc, new Ticket(type.toString(), amount));
				target.sendMessage(ChatColor.AQUA + "Inventory full. " + amount + "x Ticket dropped at your feet.");
				
				return true;
				
			}
			
			target.getInventory().addItem(new Ticket(type.toString(), amount));
			target.sendMessage(ChatColor.AQUA + "You received " + amount + "x Ticket.");
			
			return true;
			
			
			
		}
		
		return false;
		
	}

}
