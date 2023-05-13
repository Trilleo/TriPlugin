package me.firstserver.firstserverplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Objects;

public class TeleportWandListener implements Listener {

    @EventHandler
    public void onTPWandClick(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if (event.getHand() == null){
            return;
        }

        if (event.getHand().equals(EquipmentSlot.OFF_HAND)){
            return;
        }

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

            if (player.getInventory().getItemInMainHand().getItemMeta() == null){
                return;
            }

            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Teleport Wand")){

                Location loc = Objects.requireNonNull(event.getClickedBlock()).getLocation();
                loc.setY(loc.getY() + 1);
                loc.setX(loc.getX() + 0.5);
                loc.setZ(loc.getZ() + 0.5);
                player.teleport(loc);
                player.sendMessage(ChatColor.GREEN + "Successfully teleported you to " + loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ());
                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

            }

        }

    }

}
