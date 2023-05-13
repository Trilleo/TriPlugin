package me.firstserver.firstserverplugin.commands;

import me.firstserver.firstserverplugin.FirstServerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GlowStickCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;
            ItemStack glowStick = new ItemStack(Material.WOODEN_SWORD, 1);
            ItemMeta stickMeta = glowStick.getItemMeta();

            ArrayList<String> stickLore = new ArrayList<>();
            stickLore.add(ChatColor.LIGHT_PURPLE + "Glow I");
            stickLore.add(ChatColor.GOLD + "Hit an entity to make it glow!");

            stickMeta.setLore(stickLore);
            stickMeta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Glow Stick");
            stickMeta.addEnchant(FirstServerPlugin.glowEnchantment, 1, true);
            glowStick.setItemMeta(stickMeta);

            player.getInventory().addItem(glowStick);
            player.sendMessage(ChatColor.GREEN + "Gave yourself a Glow Stick");
            player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

        }

        return true;
    }
}
