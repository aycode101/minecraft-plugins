package com.dragotato.shareddamage;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class SharedDamageListener implements Listener {
	
	public SharedDamageListener(SharedDamageMain plugin) {
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event) {
		
		if (event.getEntityType() == EntityType.PLAYER) {
			
			Player p = (Player) event.getEntity();
			
			if (!p.getLastDamageCause().equals(DamageCause.CUSTOM)) {
				for (Player player: Bukkit.getOnlinePlayers()) {
					// Reduce rest of players's health by damage
					if (player != p)
						//player.damage(event.getDamage());
						player.setHealth(player.getHealth() - event.getDamage());
				}
				
			}
			
		}

	}
	
}
