package me.firstserver.firstserverplugin.utility;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LockUtils {

    public static void createNewLock(Player player){

        if (player.getTargetBlockExact(10) == null){

            player.sendMessage(ChatColor.DARK_RED + "You are not looking at a block!");
            player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

        }else {

            Block target = player.getTargetBlockExact(10);

            ItemStack item = player.getInventory().getItemInMainHand();

            if (target.getType().equals(Material.CHEST)){

                Chest chest = (Chest) player.getTargetBlockExact(10);
                chest.setLock(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName());
                player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                player.sendMessage(ChatColor.GOLD + "Successfully created a new lock.");
                player.sendMessage(ChatColor.GOLD + "The key is: " + player.getInventory().getItemInMainHand().getItemMeta().getDisplayName());

            }

        }

    }

}
