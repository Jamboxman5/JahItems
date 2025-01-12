package net.jahcraft.jahitems.listeners;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class JetPackListener implements Listener {
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		
		if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
	
		ItemStack item = e.getItem();
		if (item == null) return;
		if (!isJetPack(item)) return;
		if (e.getPlayer() == null) return;

		Player p = e.getPlayer();
			
		e.setCancelled(true);
		
		jet(p, Math.min(item.getAmount(), 5));
		
	}
	
	private boolean isJetPack(ItemStack i) {
		return (i.getType() == Material.FIREWORK_STAR && i.hasItemMeta() && i.getItemMeta().getCustomModelData() == 1);
	}
	
	private void jet(Player p, int power) {
		boolean heightLimitReached = true;
		
		for (int i = 0; i < 80 * power; i++) {
			if (p.getLocation().subtract(0, i, 0).getBlock().getType() != Material.AIR) {
				heightLimitReached = false;
			}
		}
		
		if (!heightLimitReached) {
			p.setVelocity(p.getLocation().getDirection().multiply(.4).setY(.4).multiply(power));
			p.getLocation().getWorld().playSound(p.getLocation(), Sound.ITEM_FIRECHARGE_USE, 1f, 1f);
			p.getLocation().getWorld().spawnParticle(Particle.FLAME, p.getLocation(), 5*power, .3f, .3f, .3f, .03f*power);
			p.getLocation().getWorld().spawnParticle(Particle.SMOKE_NORMAL, p.getLocation(), 5*power, .3f, .3f, .3f, .03f*power);
		} else {
			p.sendMessage(ChatColor.RED + "Height limit reached!");
		}
	}

}
