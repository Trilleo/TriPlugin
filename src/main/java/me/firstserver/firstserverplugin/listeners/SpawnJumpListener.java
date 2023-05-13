package me.firstserver.firstserverplugin.listeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpawnJumpListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event){

        Player player = event.getPlayer();

        if (player.getWorld().getName().equalsIgnoreCase("Spawn")){

            Location blockIn = player.getLocation();

            Location blockUnder = player.getLocation();

            blockUnder.setY(blockUnder.getY() - 1.00);

            if (blockUnder.getBlock().getType().equals(Material.SLIME_BLOCK)){

                if (blockIn.getBlock().getType().equals(Material.GREEN_CARPET) || blockIn.getBlock().getType().equals(Material.LIME_CARPET) || blockIn.getBlock().getType().equals(Material.ORANGE_CARPET)){

                    PotionEffect jump = new PotionEffect(PotionEffectType.LEVITATION, 20, 10, false, false, false);

                    player.addPotionEffect(jump);

                }

            }

        }

    }

}
