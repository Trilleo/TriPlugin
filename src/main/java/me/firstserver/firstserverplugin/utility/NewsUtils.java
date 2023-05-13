package me.firstserver.firstserverplugin.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class NewsUtils {

    public static void addNews(Inventory inv) {

        //News 1
        ItemStack news1 = new ItemStack(Material.EMERALD, 1);
        ItemMeta news1Meta = news1.getItemMeta();
        ArrayList<String> news1Lore = new ArrayList<>();
        news1Lore.add(ChatColor.GOLD + "The adventure begins here!");
        news1Lore.add(ChatColor.GREEN + "#1 Added the Server News feature.");
        news1Lore.add(ChatColor.GREEN + "#2 GUI pages improvements.");
        news1Lore.add(ChatColor.GREEN + "#3 Added the blocks that can't be duplicated.");
        news1Lore.add(ChatColor.GREEN + "#4 Small bug fixes.");

        news1Meta.setDisplayName(ChatColor.AQUA + "Thread #1 - 2023/2/7 - 1.4.0");
        news1Meta.setLore(news1Lore);
        news1.setItemMeta(news1Meta);

        inv.addItem(news1);

        //News 2
        ItemStack news2 = new ItemStack(Material.MAP, 1);
        ItemMeta news2Meta = news2.getItemMeta();
        ArrayList<String> news2Lore = new ArrayList<>();
        news2Lore.add("   ");
        news2Lore.add(ChatColor.GREEN + "#1 Added Teleport Wand item(OP only).");
        news2Lore.add(ChatColor.GREEN + "#2 GUI pages improvements.");
        news2Lore.add(ChatColor.GREEN + "#3 Spawn Lobby jump system.");
        news2Lore.add(ChatColor.GREEN + "#4 Small bug fixes.");

        news2Meta.setDisplayName(ChatColor.AQUA + "Thread #2 - 2023/2/10 - 1.5.0");
        news2Meta.setLore(news2Lore);
        news2.setItemMeta(news2Meta);

        inv.addItem(news2);

        //News 3
        ItemStack news3 = new ItemStack(Material.MAP, 1);
        ItemMeta news3Meta = news3.getItemMeta();
        ArrayList<String> news3Lore = new ArrayList<>();
        news3Lore.add("   ");
        news3Lore.add(ChatColor.GREEN + "#1 Added color chat function.");
        news3Lore.add(ChatColor.DARK_GRAY + "Use &+<Color Code> to activate.");
        news3Lore.add(ChatColor.DARK_GRAY + "See " + ChatColor.GOLD + "Minecraft Wiki" + ChatColor.DARK_GRAY + " for more info.");

        news3Meta.setDisplayName(ChatColor.AQUA + "Thread #3 - 2023/4/22 - 1.6.0");
        news3Meta.setLore(news3Lore);
        news3.setItemMeta(news3Meta);

        inv.addItem(news3);
    }

}
