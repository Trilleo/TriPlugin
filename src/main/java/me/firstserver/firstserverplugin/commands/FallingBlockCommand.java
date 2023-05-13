package me.firstserver.firstserverplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FallingBlockCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        //Main

        if (sender instanceof ConsoleCommandSender){
            System.out.println("You can't do that!");
        } else if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 1){
                if (Material.getMaterial(args[0]) == null){
                    player.sendMessage(ChatColor.DARK_RED + "Couldn't find block.");
                    player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                }else {

                    BlockData data = Material.getMaterial(args[0]).createBlockData();

                    //

                }
            }else {
                player.sendMessage(ChatColor.DARK_RED + "You can't do that!");
                player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
            }

        }

        return true;
    }
}
