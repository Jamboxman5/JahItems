package net.jahcraft.jahitems.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class JumpyBootsListener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	
	public void onJump(PlayerMoveEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (player.getInventory().getBoots() == null) return;
		ItemStack boots = player.getInventory().getBoots();
		if (!isJumpyBoots(boots)) return;
		if (player.isSneaking()) return;
		
		double jumpVelocity = (double) 0.42F;
		if (player.hasPotionEffect(PotionEffectType.JUMP)) {
			jumpVelocity += (double) ((float) (player.getPotionEffect(PotionEffectType.JUMP).getAmplifier() + 1) * 0.1F);
		}
		
		if (event.getFrom().getY() < event.getTo().getY() &&
//			player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR &&
			player.getLocation().getBlock().getType() != Material.LADDER &&
			!player.isOnGround()
			&& Double.compare(player.getVelocity().getY(), jumpVelocity) == 0) {
			player.setVelocity(player.getVelocity().add(new Vector(0,.5,0)));
			
		}
		
	}
	
	private boolean isJumpyBoots(ItemStack i) {
		return (i.getType() == Material.GOLDEN_BOOTS && i.hasItemMeta() && i.getItemMeta().getCustomModelData() == 1);
	}
	
	@EventHandler
	
	public void onFall(EntityDamageEvent event) {
	
		if (!(event.getEntity() instanceof Player)) return;
		
		Player player = (Player) event.getEntity();
		
		if (event.getCause() != DamageCause.FALL) return;
		
		if (player.getInventory().getBoots() == null) return;
		if (isJumpyBoots(player.getInventory().getBoots())) event.setCancelled(true); 
		
	}

}
