package me.firstserver.firstserverplugin.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUIManager {

    private static Inventory lockGUI;

    public static void openLockGUI(Player player){

        lockGUI = Bukkit.createInventory(player, 9, ChatColor.AQUA + "Lock the block?");

        ItemStack confirm = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        ItemMeta confirmMeta = confirm.getItemMeta();
        confirmMeta.setDisplayName(ChatColor.GREEN + "Confirm");
        confirm.setItemMeta(confirmMeta);
        lockGUI.setItem(0, confirm);

        ItemStack cancel = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        ItemMeta cancelMeta = cancel.getItemMeta();
        cancelMeta.setDisplayName(ChatColor.RED + "Cancel");
        cancel.setItemMeta(cancelMeta);
        lockGUI.setItem(8, cancel);

        ItemStack block = new ItemStack(Material.CHEST, 1);
        ItemMeta blockMeta = block.getItemMeta();
        blockMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Chest");
        block.setItemMeta(blockMeta);
        lockGUI.setItem(4, block);

        player.openInventory(lockGUI);

    }

    public static void openOPMenu(Player player){

        Inventory item = Bukkit.createInventory(player, 27, ChatColor.GOLD + "" + ChatColor.BOLD + "OP Tools Menu");

        //Air
        ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta airMeta = air.getItemMeta();
        airMeta.setDisplayName(" ");
        air.setItemMeta(airMeta);

        item.setItem(0, air);
        item.setItem(1, air);
        item.setItem(2, air);
        item.setItem(3, air);
        item.setItem(4, air);
        item.setItem(5, air);
        item.setItem(6, air);
        item.setItem(7, air);
        item.setItem(8, air);
        item.setItem(18, air);
        item.setItem(19, air);
        item.setItem(20, air);
        item.setItem(21, air);
        item.setItem(22, air);
        item.setItem(23, air);
        item.setItem(24, air);
        item.setItem(25, air);
        item.setItem(26, air);

        //Sword
        ItemStack sword = OPSword.createOPSword();
        item.setItem(9, sword);

        //Bow
        ItemStack bow = OPBow.createOPBow();
        item.setItem(10, bow);

        //Water Stick
        ItemStack stick = WaterStick.createWaterStick();
        item.setItem(11, stick);

        //KB Stick
        ItemStack KBStick = KnockbackStick.createKnockbackStick();
        item.setItem(12, KBStick);

        //TP Wand
        ItemStack TPWand = TeleportWand.createTeleportWand();
        item.setItem(13, TPWand);

        //Open
        player.openInventory(item);
        System.out.println(player.getDisplayName() + " opened OP Items Menu!");

    }

    public static void openMainMenu(Player player){

        Inventory main = Bukkit.createInventory(player, 27, ChatColor.GOLD + "" + ChatColor.BOLD + "First Server Menu");

        //Air
        ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta airMeta = air.getItemMeta();
        airMeta.setDisplayName(" ");
        air.setItemMeta(airMeta);

        main.setItem(0, air);
        main.setItem(1, air);
        main.setItem(2, air);
        main.setItem(3, air);
        main.setItem(4, air);
        main.setItem(5, air);
        main.setItem(6, air);
        main.setItem(7, air);
        main.setItem(8, air);
        main.setItem(18, air);
        main.setItem(19, air);
        main.setItem(20, air);
        main.setItem(21, air);
        main.setItem(22, air);
        main.setItem(23, air);
        main.setItem(24, air);
        main.setItem(25, air);

        //Useful Tools
        ArrayList<String> toolsLore = new ArrayList<>();
        toolsLore.add(ChatColor.GREEN + "Left click me!");
        toolsLore.add(ChatColor.GREEN + "Open useful tools menu.");

        ItemStack tools = new ItemStack(Material.DIAMOND, 1);
        ItemMeta toolsMeta = tools.getItemMeta();
        toolsMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Useful Tools");
        toolsMeta.setLore(toolsLore);
        tools.setItemMeta(toolsMeta);

        main.setItem(12, tools);

        //Server News
        ArrayList<String> newsLore = new ArrayList<>();
        newsLore.add(ChatColor.GREEN + "Check for news on First Server.");

        ItemStack news = new ItemStack(Material.FILLED_MAP, 1);
        ItemMeta newsMeta = news.getItemMeta();
        newsMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Server News");
        newsMeta.setLore(newsLore);
        news.setItemMeta(newsMeta);

        main.setItem(14, news);

        //Close
        ArrayList<String> closeLore = new ArrayList<>();
        closeLore.add(ChatColor.RED + "Close inventory");

        ItemStack close = new ItemStack(Material.BARRIER, 1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.DARK_RED + "Close");
        closeMeta.setLore(closeLore);
        close.setItemMeta(closeMeta);

        main.setItem(26, close);

        //Open inventory
        player.openInventory(main);

    }

    public static void openToolsMenu(Player player){

        //Create inventory
        Inventory toolsMenu = Bukkit.createInventory(player, 27, ChatColor.GOLD + "" + ChatColor.BOLD + "Useful Tools");

        //Air
        ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta airMeta = air.getItemMeta();
        airMeta.setDisplayName(" ");
        air.setItemMeta(airMeta);

        toolsMenu.setItem(0, air);
        toolsMenu.setItem(1, air);
        toolsMenu.setItem(2, air);
        toolsMenu.setItem(3, air);
        toolsMenu.setItem(4, air);
        toolsMenu.setItem(5, air);
        toolsMenu.setItem(6, air);
        toolsMenu.setItem(7, air);
        toolsMenu.setItem(8, air);
        toolsMenu.setItem(18, air);
        toolsMenu.setItem(19, air);
        toolsMenu.setItem(20, air);
        toolsMenu.setItem(21, air);
        toolsMenu.setItem(22, air);
        toolsMenu.setItem(23, air);
        toolsMenu.setItem(24, air);
        toolsMenu.setItem(25, air);

        //Dirt get
        ArrayList<String> dirtLore = new ArrayList<>();
        dirtLore.add(ChatColor.GREEN + "Left click me!");
        dirtLore.add(ChatColor.GREEN + "Get 64 dirt blocks.");

        ItemStack dirt = new ItemStack(Material.DIRT, 64);
        ItemMeta dirtMeta = dirt.getItemMeta();
        dirtMeta.setDisplayName(ChatColor.AQUA + "64x Dirt Blocks");
        dirtMeta.setLore(dirtLore);
        dirt.setItemMeta(dirtMeta);

        toolsMenu.setItem(9, dirt);

        //Duplicate Wand get

        ArrayList<String> dupWandLore = new ArrayList<>();
        dupWandLore.add(ChatColor.GREEN + "Left click me!");
        dupWandLore.add(ChatColor.GREEN + "Get 1x Duplicate Wands for " + ChatColor.GOLD + "100$");

        ItemStack dupWand = new ItemStack(Material.STICK, 1);
        ItemMeta dupWandMeta = dupWand.getItemMeta();
        dupWandMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Duplicate Wand");
        dupWandMeta.setLore(dupWandLore);
        dupWand.setItemMeta(dupWandMeta);

        toolsMenu.setItem(10, dupWand);

        //

        //Close
        ArrayList<String> closeLore = new ArrayList<>();
        closeLore.add(ChatColor.RED + "Close inventory");

        ItemStack close = new ItemStack(Material.BARRIER, 1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.DARK_RED + "Close");
        closeMeta.setLore(closeLore);
        close.setItemMeta(closeMeta);

        toolsMenu.setItem(26, close);

        //Open inventory
        player.openInventory(toolsMenu);

    }

    public static void openNewsMenu(Player player){

        //Create Inventory
        Inventory main = Bukkit.createInventory(player, 54, ChatColor.GOLD + "" + ChatColor.BOLD + "Server News");

        //Add News
        NewsUtils.addNews(main);

        //Open
        player.openInventory(main);

    }

}
