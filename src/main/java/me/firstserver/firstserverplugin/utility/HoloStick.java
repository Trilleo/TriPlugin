package me.firstserver.firstserverplugin.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class HoloStick {

    public static ItemStack createHoloStick(){

        ArrayList<String> stickLore = new ArrayList<>();
        stickLore.add(ChatColor.GREEN + "Useful item to create a hologram");

        ItemStack stick = new ItemStack(Material.STICK, 1);
        ItemMeta stickMeta = stick.getItemMeta();
        stickMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "HoloStick");
        stickMeta.setLore(stickLore);
        stick.setItemMeta(stickMeta);

        return stick;
    }

}
