package net.jahcraft.jahitems.main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import net.jahcraft.jahitems.commands.ItemGetter;
import net.jahcraft.jahitems.commands.ItemGiver;
import net.jahcraft.jahitems.commands.TicketGiver;
import net.jahcraft.jahitems.listeners.BanHammerListener;
import net.jahcraft.jahitems.listeners.ItemListListener;
import net.jahcraft.jahitems.listeners.JetPackListener;
import net.jahcraft.jahitems.listeners.JumpyBootsListener;
import net.jahcraft.jahitems.listeners.ScubaHelmetListener;
import net.jahcraft.jahitems.runnables.NightVisionChecker;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	public static boolean checkNVHelmet = true;
//	public Economy eco;

	@Override
	public void onEnable() {
		
//		if (!setupEconomy()) {
//			
//			Bukkit.getLogger().info("Economy not detected! Disabling JahCore!");
//			getServer().getPluginManager().disablePlugin(this);
//			return;
//			
//		}
		
		plugin = this;
		
		//JAHITEMS
				try {
					
					//COMMANDS
					getCommand("itemgetter").setExecutor((CommandExecutor) new ItemGetter());
					getCommand("ticketgiver").setExecutor((CommandExecutor) new TicketGiver());
					getCommand("itemgiver").setExecutor((CommandExecutor) new ItemGiver());
					
					//LISTENERS
					getServer().getPluginManager().registerEvents(new JumpyBootsListener(), this);
//					getServer().getPluginManager().registerEvents(new NightVisionHelmetListener(), this);
					getServer().getPluginManager().registerEvents(new ScubaHelmetListener(), this);
					getServer().getPluginManager().registerEvents(new JetPackListener(), this);
					getServer().getPluginManager().registerEvents(new BanHammerListener(), this);
					getServer().getPluginManager().registerEvents(new ItemListListener(), this);
					
					//UI
					ItemGetter.menu = ItemGetter.createList();
					
					//THREADS
					Bukkit.getScheduler().runTaskAsynchronously(this, new NightVisionChecker());
					
				} catch(Exception e) {
					
					Bukkit.getLogger().warning("Failed to load JahItems!");
					e.printStackTrace();
					
				}			
	}
	
	@Override 
	public void onDisable() {

		checkNVHelmet = false;		
		
		Bukkit.getLogger().info("JahSkills Unloaded and Disabled!");
		
	}
	
//	private boolean setupEconomy() {
//		
//		RegisteredServiceProvider<Economy> economy = getServer().
//				getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
//		
//		if (economy != null)
//			eco = economy.getProvider();
//		return (eco != null);
//		
//	}

}
