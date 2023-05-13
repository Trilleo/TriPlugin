package me.firstserver.firstserverplugin.commands;

import me.firstserver.firstserverplugin.utility.GUIManager;
import me.firstserver.firstserverplugin.utility.LockUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LockCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;
            Block target;

            if (player.getTargetBlockExact(10) == null){

                player.sendMessage(ChatColor.DARK_RED + "You are not looking at a block!");
                player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

            }else {

                target = player.getTargetBlockExact(10);

                if (target.getType().equals(Material.CHEST)){

                    if (player.getInventory().getItemInMainHand().getItemMeta() == null){

                        player.sendMessage(ChatColor.DARK_RED + "You need to hold an item as the key.");

                    }else {

                        LockUtils.createNewLock(player);

                    }

                }

            }

        }

        return true;
    }
}
