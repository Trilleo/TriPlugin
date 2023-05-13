package me.firstserver.firstserverplugin.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class DuplicateWand {

    public static ItemStack createDuplicateWand(){

        ArrayList<String> wandLore = new ArrayList<>();
        wandLore.add(ChatColor.AQUA + "Right click a block to duplicate it 32x times");

        ItemStack stick = new ItemStack(Material.STICK, 1);
        ItemMeta stickMeta = stick.getItemMeta();
        stickMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Duplicate Wand");
        stickMeta.setLore(wandLore);
        stick.setItemMeta(stickMeta);

        return stick;

    }

}
