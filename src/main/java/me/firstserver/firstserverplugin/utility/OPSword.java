package me.firstserver.firstserverplugin.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class OPSword {

    public static ItemStack createOPSword(){

        ArrayList<String> swordLore = new ArrayList<>();
        swordLore.add(ChatColor.RED + "Perfect tool for PvP");

        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "OP Sword");
        swordMeta.setLore(swordLore);
        swordMeta.setUnbreakable(true);
        swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
        swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        swordMeta.addEnchant(Enchantment.KNOCKBACK,50,true);
        sword.setItemMeta(swordMeta);

        return sword;

    }

}
