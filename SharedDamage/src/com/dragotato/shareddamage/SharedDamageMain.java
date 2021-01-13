package com.dragotato.shareddamage;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SharedDamageMain extends JavaPlugin{
	
	@Override 
	public void onEnable() {
		getLogger().info("SharedDamage plugin enabled.");
		PluginManager pm = getServer().getPluginManager();
		SharedDamageListener listener = new SharedDamageListener(this);
		pm.registerEvents(listener, this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("SharedDamage plugin disabled.");
	}
}
