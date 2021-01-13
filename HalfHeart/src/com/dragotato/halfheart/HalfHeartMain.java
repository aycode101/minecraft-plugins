package com.dragotato.halfheart;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HalfHeartMain extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getLogger().info("onEnable() has been called. HalfHeart plugin has been enabled. ");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("onDisable() has been called. HalfHeart plugin has been disabled.");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("halfheart")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
			} else {
				// sets player health to half a heart
				Player p = (Player) sender;
				if (p.getMaxHealth() == 1)
					p.sendMessage(ChatColor.RED + "Health is already set to half a heart.");
				else {
					p.setMaxHealth(1);
					p.sendMessage(ChatColor.AQUA + "Health is set to " + ChatColor.BOLD + "half a heart!");
				}
				return true;
			}
			
		} else if (cmd.getName().equalsIgnoreCase("resethealth")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
			} else {
				// sets player health to full health (10 hearts)
				Player p = (Player) sender;
				if (p.getMaxHealth() == 20)
					p.sendMessage(ChatColor.RED + "Health is already set to default.");
				else {
					p.setMaxHealth(20);
					p.setHealth(20);
					p.sendMessage(ChatColor.GREEN + "Reset to default health.");
				}
				return true;
			}
		}
		
		return false;
	}
}
