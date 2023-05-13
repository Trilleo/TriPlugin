package me.firstserver.firstserverplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class WaterStickListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){

        Player player = event.getPlayer();

        if(player.getInventory().getItemInMainHand().getItemMeta() == null){
            return;
        }

        if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Water Stick")){

            Location waterLoc = event.getBlock().getLocation();

            waterLoc.getBlock().setType(Material.WATER, true);
            player.sendMessage(ChatColor.GREEN + "Successfully placed water!");
            player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

        }

    }

}
