package me.firstserver.firstserverplugin.listeners;

import me.firstserver.firstserverplugin.FirstServerPlugin;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class LaunchDamageListener implements Listener {

    FirstServerPlugin plugin;

    public LaunchDamageListener(FirstServerPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent event){

        if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL) && event.getEntity().getType().equals(EntityType.PLAYER)){

            Player player = (Player) event.getEntity();

            if (plugin.launched_players.contains(player)){

                event.setCancelled(true);
                plugin.launched_players.remove(player);

            }

        }

    }

    @EventHandler
    public void onSpawnFallDamage(EntityDamageEvent event){

        if (event.getEntity().equals(EntityType.PLAYER) && event.getCause().equals(EntityDamageEvent.DamageCause.FALL)){

            Player player = (Player) event.getEntity();

            if (player.getWorld().getName().equalsIgnoreCase("Spawn")){

                event.setCancelled(true);

            }

        }

    }

}
