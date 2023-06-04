package net.jahcraft.jahitems.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodsListener implements Listener {

	public void onEat(FoodLevelChangeEvent e) {
		
		if (e.getItem() == null) return;
		if (!e.getItem().hasItemMeta()) return;
		if (!e.getItem().getItemMeta().hasCustomModelData()) return;
		
	}
	
}
