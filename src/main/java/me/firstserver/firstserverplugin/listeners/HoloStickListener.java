package me.firstserver.firstserverplugin.listeners;

import eu.decentsoftware.holograms.api.DHAPI;
import me.firstserver.firstserverplugin.FirstServerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.List;

public class HoloStickListener implements Listener {

    FirstServerPlugin plugin;
    public HoloStickListener(FirstServerPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerClickBlock(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if (event.getHand() == null){
            return;
        }

        if (event.getHand().equals(EquipmentSlot.OFF_HAND)){
            return;
        }

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

            if (player.getInventory().getItemInMainHand().getItemMeta() == null)return;

            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "HoloStick")){

                plugin.creating_hologram_players.add(player);
                player.sendMessage(ChatColor.YELLOW + "Type in the name of hologram:");

            }

        }

    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){

        Player player = event.getPlayer();

        if (plugin.creating_hologram_players.contains(player)){

            List<String> list = new ArrayList<>();
            list.add("Blank line");
            String holoName = event.getMessage();
            event.setCancelled(true);
            DHAPI.createHologram(holoName, player.getLocation(), true, list);
            player.sendMessage(ChatColor.GREEN + "Successfully created a hologram.");
            plugin.creating_hologram_players.remove(player);

        }

    }

}
