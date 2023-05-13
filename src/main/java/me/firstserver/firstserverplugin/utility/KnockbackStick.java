package me.firstserver.firstserverplugin.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class KnockbackStick {

    public static ItemStack createKnockbackStick(){

        ArrayList<String> stickLore = new ArrayList<>();
        stickLore.add(ChatColor.GREEN + "Best tool to knock others off.");

        ItemStack stick = new ItemStack(Material.STICK, 1);
        ItemMeta stickMeta = stick.getItemMeta();
        stickMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Knockback Stick");
        stickMeta.addEnchant(Enchantment.KNOCKBACK, 10, true);
        stickMeta.setLore(stickLore);
        stick.setItemMeta(stickMeta);

        return stick;

    }

}
