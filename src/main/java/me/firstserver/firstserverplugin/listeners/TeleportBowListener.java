package me.firstserver.firstserverplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class TeleportBowListener implements Listener {

    @EventHandler
    public void onArrowLand(ProjectileHitEvent event){

        if (event.getEntity().getType() == EntityType.ARROW){

            if (event.getEntity().getShooter() instanceof Player){

                Player player = (Player) event.getEntity().getShooter();

                if(player.getInventory().getItemInMainHand().getItemMeta() == null){
                    return;
                }

                ItemStack itemInMainHand = player.getInventory().getItemInMainHand();

                String bow = itemInMainHand.getItemMeta().getDisplayName();

                if (bow.equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Teleport Bow")){

                    Location location = event.getEntity().getLocation();
                    event.getEntity().remove();
                    player.teleport(location);
                    player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1.0f, 1.0f);
                    player.sendMessage(ChatColor.GREEN + "Successfully teleported you by the Teleport Bow");
                    System.out.println(player.getDisplayName() + " used the Teleport Bow");

                }

            }

        }

    }

}
