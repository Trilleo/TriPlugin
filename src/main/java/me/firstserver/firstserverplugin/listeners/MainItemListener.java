package me.firstserver.firstserverplugin.listeners;

import me.firstserver.firstserverplugin.utility.GUIManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MainItemListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if (player.getWorld().getName().equalsIgnoreCase("world")||player.getWorld().getName().equalsIgnoreCase("world_nether")||player.getWorld().getName().equalsIgnoreCase("world_the_end")){

            ArrayList<String> buttonLore = new ArrayList<>();
            buttonLore.add(ChatColor.GREEN + "Click to open main menu.");

            ItemStack button = new ItemStack(Material.NETHER_STAR, 1);
            ItemMeta buttonMeta = button.getItemMeta();
            buttonMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "First Server Menu");
            buttonMeta.setLore(buttonLore);
            button.setItemMeta(buttonMeta);

            if (player.getInventory().contains(button)){
                player.getInventory().remove(button);
            }

            if (player.getInventory().getItem(8) == null||player.getInventory().getItem(8).getType().equals(Material.AIR)){

                player.getInventory().setItem(8, button);

            }else {

                ItemStack item = player.getInventory().getItem(8);

                player.getInventory().setItem(8, new ItemStack(Material.AIR, 1));

                player.getInventory().setItem(8, button);

                player.getInventory().addItem(item);

            }

        }

    }

    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent event){

        Player player = event.getPlayer();

        if (player.getWorld().getName().equalsIgnoreCase("world")||player.getWorld().getName().equalsIgnoreCase("world_nether")||player.getWorld().getName().equalsIgnoreCase("world_the_end")){

            ArrayList<String> buttonLore = new ArrayList<>();
            buttonLore.add(ChatColor.GREEN + "Click to open main menu.");

            ItemStack button = new ItemStack(Material.NETHER_STAR, 1);
            ItemMeta buttonMeta = button.getItemMeta();
            buttonMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "First Server Menu");
            buttonMeta.setLore(buttonLore);
            button.setItemMeta(buttonMeta);

            if (player.getInventory().contains(button)){
                player.getInventory().remove(button);
            }

            if (player.getInventory().getItem(8) == null||player.getInventory().getItem(8).getType().equals(Material.AIR)){

                player.getInventory().setItem(8, button);

            }else {

                ItemStack item = player.getInventory().getItem(8);

                player.getInventory().setItem(8, new ItemStack(Material.AIR, 1));

                player.getInventory().setItem(8, button);

                player.getInventory().addItem(item);

            }

        }

    }

    @EventHandler
    public void onClick(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR)||event.getAction().equals(Action.LEFT_CLICK_AIR)||event.getAction().equals(Action.LEFT_CLICK_BLOCK)||event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

            if (player.getInventory().getItemInMainHand().getItemMeta() == null){
                return;
            }

            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "First Server Menu")){

                GUIManager.openMainMenu(player);
                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

            }

        }

    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {

        Player player = event.getPlayer();
        ItemStack item = event.getItemDrop().getItemStack();

        if (item.getItemMeta() == null){
            return;
        }

        if (item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "First Server Menu")) {

            event.setCancelled(true);
            player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
            player.sendMessage(ChatColor.DARK_RED + "You can't drop that!");

        }

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event){

        InventoryType inventoryType = event.getInventory().getType();
        Player player = (Player) event.getPlayer();

        if (!inventoryType.equals(InventoryType.PLAYER)){

            ArrayList<String> buttonLore = new ArrayList<>();
            buttonLore.add(ChatColor.GREEN + "Click to open main menu.");

            ItemStack button = new ItemStack(Material.NETHER_STAR, 1);
            ItemMeta buttonMeta = button.getItemMeta();
            buttonMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "First Server Menu");
            buttonMeta.setLore(buttonLore);
            button.setItemMeta(buttonMeta);

            if (event.getInventory().contains(button)){

                event.getInventory().remove(button);
                player.getInventory().setItem(8, button);
                player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                player.sendMessage(ChatColor.DARK_RED + "You can't do that!");

            }

        }else {

            ArrayList<String> buttonLore = new ArrayList<>();
            buttonLore.add(ChatColor.GREEN + "Click to open main menu.");

            ItemStack button = new ItemStack(Material.NETHER_STAR, 1);
            ItemMeta buttonMeta = button.getItemMeta();
            buttonMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "First Server Menu");
            buttonMeta.setLore(buttonLore);
            button.setItemMeta(buttonMeta);

            player.getInventory().remove(button);
            player.getInventory().setItem(8, button);

        }

    }

}
