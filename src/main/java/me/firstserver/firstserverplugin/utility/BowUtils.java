package me.firstserver.firstserverplugin.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BowUtils {

    public static ItemStack createTPBow(){

        ArrayList<String> bowLore = new ArrayList<>();
        bowLore.add(ChatColor.GOLD + "Teleport you to wherever the arrow land");
        bowLore.add(ChatColor.DARK_GRAY + "You must hold the bow to teleport");

        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Teleport Bow");
        bowMeta.setLore(bowLore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        bowMeta.setUnbreakable(true);
        bow.setItemMeta(bowMeta);

        return bow;

    }

}
