package me.firstserver.firstserverplugin.listeners;

import me.firstserver.firstserverplugin.FirstServerPlugin;
import me.firstserver.firstserverplugin.utility.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class GUIListener implements Listener {

    @EventHandler
    public void onBanMenuClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "First Server Ban GUI")){

            event.setCancelled(true);

            if (event.getCurrentItem() == null){
                return;
            }

            if (event.getCurrentItem().getType() == Material.PLAYER_HEAD){

                Player target = player.getServer().getPlayerExact(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));

                BanGUIUtils.openConfirmMenu(player, target);

            }

        } else if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Confirm?")) {

            event.setCancelled(true);

            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Cancel")){

                BanGUIUtils.openMenu(player);

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Confirm")){

                String name = ChatColor.stripColor(event.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                player.getServer().getBanList(BanList.Type.NAME).addBan(name, ChatColor.DARK_RED + "You are banned by " + player.getDisplayName(), null, null);
                player.sendMessage(ChatColor.GREEN + "Successfully banned " + name);
                player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);

            }

        }

    }

    @EventHandler
    public void onLockMenuClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Lock the block?")){

            event.setCancelled(true);

            if (event.getCurrentItem() == null){
                return;
            }

            if (event.getCurrentItem().getItemMeta() == null){
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Confirm")){

                player.sendMessage(ChatColor.GREEN + "Creating new locker......");
                player.closeInventory();
                LockUtils.createNewLock(player);

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Cancel")) {

                player.closeInventory();
                player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                player.sendMessage(ChatColor.DARK_RED + "Lock canceled.");

            }

        }

    }

    @EventHandler
    public void onMainMenuClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "First Server Menu")){

            //Make player can't move item
            event.setCancelled(true);

            if (event.getCurrentItem() == null){
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "" + ChatColor.BOLD + "Useful Tools")){

                System.out.println(player.getDisplayName() + " clicked Useful Tools!");
                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                GUIManager.openToolsMenu(player);

            } else if (event.getCurrentItem().getType() == Material.BARRIER) {

                player.closeInventory();
                player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                player.sendMessage(ChatColor.DARK_GRAY + "Closed inventory");

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "" + ChatColor.BOLD + "Server News")) {

                System.out.println(player.getDisplayName() + " clicked Server News!");
                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                //Open News Menu
                GUIManager.openNewsMenu(player);

            }

        }

    }

    @EventHandler
    public void onOPMenuClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "OP Tools Menu")){

            event.setCancelled(true);

            if (event.getCurrentItem() == null){
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.BOLD + "OP Sword")){

                ItemStack sword = OPSword.createOPSword();
                player.getInventory().addItem(sword);
                player.sendMessage(ChatColor.YELLOW + "Gave yourself an OP Sword!");
                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.closeInventory();

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "OP Bow")) {

                ItemStack bow = OPBow.createOPBow();
                player.getInventory().addItem(bow);
                player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                player.sendMessage(ChatColor.YELLOW + "Gave yourself an OP Bow!");
                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.closeInventory();

            }else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Water Stick")) {

                ItemStack stick = WaterStick.createWaterStick();
                player.getInventory().addItem(stick);
                player.sendMessage(ChatColor.YELLOW + "Gave yourself a Water Stick!");
                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.closeInventory();

            }else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Knockback Stick")) {

                ItemStack stick = KnockbackStick.createKnockbackStick();
                player.getInventory().addItem(stick);
                player.sendMessage(ChatColor.YELLOW + "Gave yourself a Knockback Stick!");
                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.closeInventory();

            }else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Teleport Wand")) {

                ItemStack wand = TeleportWand.createTeleportWand();
                player.getInventory().addItem(wand);
                player.sendMessage(ChatColor.YELLOW + "Gave yourself a Teleport Wand!");
                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.closeInventory();
            }

        }

    }

    private final HashMap<UUID, Long> dirtCoolDown;

    public GUIListener(){

        this.dirtCoolDown = new HashMap<>();

    }

    @EventHandler
    public void onToolsMenuClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Useful Tools")) {

            //Make player can't move item
            event.setCancelled(true);

            if (event.getCurrentItem() == null) {
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "64x Dirt Blocks")) {

                if (!this.dirtCoolDown.containsKey(player.getUniqueId())){

                    this.dirtCoolDown.put(player.getUniqueId(), System.currentTimeMillis());

                    ItemStack giveDirt = new ItemStack(Material.DIRT, 64);

                    player.getInventory().addItem(giveDirt);
                    player.sendMessage(ChatColor.GREEN + "You got " + ChatColor.AQUA + "64x Dirt Blocks");
                    player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                    System.out.println(player.getDisplayName() + " got 64x dirt blocks");
                    player.closeInventory();

                }else {

                    long timeElapsed = System.currentTimeMillis() - dirtCoolDown.get(player.getUniqueId());

                    if (timeElapsed >= 120000){

                        this.dirtCoolDown.put(player.getUniqueId(), System.currentTimeMillis());

                        ItemStack giveDirt = new ItemStack(Material.DIRT, 64);

                        player.getInventory().addItem(giveDirt);
                        player.sendMessage(ChatColor.GREEN + "You got " + ChatColor.AQUA + "64x Dirt Blocks");
                        player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                        System.out.println(player.getDisplayName() + " got 64x dirt blocks");
                        player.closeInventory();

                    }else {

                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                        player.sendMessage(ChatColor.DARK_RED + "You can't do this again for " + ChatColor.RED + (120 - timeElapsed / 1000) + ChatColor.DARK_RED + " seconds!");
                        player.closeInventory();

                    }

                }

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Close")) {

                player.closeInventory();
                player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                player.sendMessage(ChatColor.DARK_GRAY + "Closed inventory");

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Duplicate Wand")) {

                ItemStack dupWand = DuplicateWand.createDuplicateWand();
                Economy economy = FirstServerPlugin.getEconomy();
                Double playerEco = economy.getBalance(player);

                if (playerEco >= 100.00){

                    economy.withdrawPlayer(player, 100.00);
                    player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                    player.sendMessage(ChatColor.GREEN + "Successfully bought 1x Duplicate Wand with " + ChatColor.GOLD + "100$");
                    System.out.println(player.getDisplayName() + " bought 1x Duplicate Wand.");

                    player.getInventory().addItem(dupWand);
                    player.closeInventory();

                }else {

                    player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                    player.sendMessage(ChatColor.DARK_RED + "You don't have enough money!");
                    player.closeInventory();

                }

            }

        }

    }

    @EventHandler
    public void onNewsMenuClick(InventoryClickEvent event){

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Server News")){

            event.setCancelled(true);

        }

    }

}
