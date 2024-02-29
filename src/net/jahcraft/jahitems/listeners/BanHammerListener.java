package net.jahcraft.jahitems.listeners;

import java.util.Date;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.ban.ProfileBanList;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import net.md_5.bungee.api.ChatColor;


public class BanHammerListener implements Listener {

	private String banReason = ChatColor.of("#00E8FF") + "» " + ChatColor.of("#FFD700") + "" + ChatColor.BOLD + "The Ban Hammer Has Spoken!" + ChatColor.of("#00E8FF") + " «";
	
	@EventHandler
	public void onHammer(EntityDamageByEntityEvent e) {
		
		if (!(e.getDamager() instanceof Player)) return;
		Player damager = (Player) e.getDamager();
		if (damager.getInventory() == null) return;
		if (!damager.hasPermission("jahcore.ban")) return;
		if (damager.getInventory().getItemInMainHand() == null) return;
		if (damager.getInventory().getItemInMainHand().getType() != Material.DIAMOND_AXE) return;
		if (!damager.getInventory().getItemInMainHand().hasItemMeta()) return;
		if (!damager.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()) return;
		if (damager.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() != 1) return;
		
		if (e.getEntity() instanceof Player) {
			Player target = (Player) e.getEntity();
			ProfileBanList banList = (ProfileBanList) Bukkit.getBanList(Type.PROFILE);
			banList.addBan(target.getPlayerProfile(), banReason, (Date) null, damager.getName());
			target.kickPlayer(banReason);
			
			for (Player p : Bukkit.getServer().getOnlinePlayers()) {
				p.sendTitle(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD+ target.getDisplayName() + " has been banned!", banReason, 1, 90, 1);
				p.playSound(p, Sound.BLOCK_ANVIL_LAND, 1, 1);
			}
			
			return;
		} else if (e.getEntity() instanceof LivingEntity) {
			LivingEntity entity = (LivingEntity) e.getEntity();
			entity.setHealth(0);
			
			if (entity.getCustomName() != null) {
				for (Player p : Bukkit.getServer().getOnlinePlayers()) {
					p.sendTitle(ChatColor.of("#49B3FF") + entity.getCustomName() + " has been banned!", banReason, 10, 90, 25);
					p.playSound(p, Sound.BLOCK_ANVIL_LAND, 1, 1);
				}
			} 
			
			return;
		}
		
	}
	
}
