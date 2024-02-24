package net.jahcraft.jahitems.util;

import java.util.HashMap;

import org.bukkit.inventory.ItemStack;

import net.jahcraft.jahitems.foods.Cheese;
import net.jahcraft.jahitems.foods.FriedEgg;
import net.jahcraft.jahitems.foods.Hamburger;
import net.jahcraft.jahitems.foods.HotDog;
import net.jahcraft.jahitems.foods.PepperoniStick;
import net.jahcraft.jahitems.foods.Pizza;
import net.jahcraft.jahitems.foods.SalmonSushi;
import net.jahcraft.jahitems.foods.Tomato;
import net.jahcraft.jahitems.items.BanHammer;
import net.jahcraft.jahitems.items.Cutlass;
import net.jahcraft.jahitems.items.JetPack;
import net.jahcraft.jahitems.items.JumpyBoots;
import net.jahcraft.jahitems.items.Katana;
import net.jahcraft.jahitems.items.NetheriteCutlass;
import net.jahcraft.jahitems.items.NetheriteKatana;
import net.jahcraft.jahitems.items.NetheriteRapier;
import net.jahcraft.jahitems.items.NightVisionHelmet;
import net.jahcraft.jahitems.items.Rapier;
import net.jahcraft.jahitems.items.ScubaHelmet;

public class ItemStorage {

	public static HashMap<String, ItemStack> itemGetter = getItems();
		
	private static HashMap<String, ItemStack> getItems() {

		HashMap<String, ItemStack> items = new HashMap<>();
		
		items.put("cutlass", new Cutlass());
		items.put("jetpack", new JetPack());
		items.put("jumpyboots", new JumpyBoots());
		items.put("katana", new Katana());
		items.put("netheritecutlass", new NetheriteCutlass());
		items.put("netheritekatana", new NetheriteKatana());
		items.put("netheriterapier", new NetheriteRapier());
		items.put("nightvisionhelmet", new NightVisionHelmet());
		items.put("rapier", new Rapier());
		items.put("scubahelmet", new ScubaHelmet());
		items.put("cheese", new Cheese());
		items.put("friedegg", new FriedEgg());
		items.put("hamburger", new Hamburger());
		items.put("hotdog", new HotDog());
		items.put("pepperonistick", new PepperoniStick());
		items.put("pizza", new Pizza());
		items.put("salmonsushi", new SalmonSushi());
		items.put("tomato", new Tomato());
		items.put("banhammer", new BanHammer());
		
		return items;
	}
	
}
