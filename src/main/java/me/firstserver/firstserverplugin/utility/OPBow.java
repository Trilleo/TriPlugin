package me.firstserver.firstserverplugin.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class OPBow {

    public static ItemStack createOPBow(){

        ArrayList<String> bowLore = new ArrayList<>();
        bowLore.add(ChatColor.RED + "Perfect tool for PvP");

        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 50, true);
        bowMeta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 20, true);
        bowMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "OP Bow");
        bowMeta.setLore(bowLore);
        bowMeta.setUnbreakable(true);
        bow.setItemMeta(bowMeta);

        return bow;

    }

}
