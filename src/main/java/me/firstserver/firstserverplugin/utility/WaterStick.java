package me.firstserver.firstserverplugin.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class WaterStick {

    public static ItemStack createWaterStick(){

        ArrayList<String> stickLore = new ArrayList<>();
        stickLore.add(ChatColor.AQUA + "Left click a block to create water");

        ItemStack stick = new ItemStack(Material.STICK, 1);
        ItemMeta stickMeta = stick.getItemMeta();
        stickMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Water Stick");
        stickMeta.setLore(stickLore);
        stick.setItemMeta(stickMeta);

        return stick;

    }

}
