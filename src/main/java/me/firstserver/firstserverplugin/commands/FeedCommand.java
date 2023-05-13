package me.firstserver.firstserverplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = ((Player) sender).getPlayer();

            if(player.hasPermission("firstplugin.feed")){

                player.setFoodLevel(20);
                player.setSaturation(20.00F);
                player.sendMessage(ChatColor.YELLOW + "Food set to max.");

            }else {

                player.sendMessage(ChatColor.DARK_RED + "You don't have the permission!");

            }

        }

        return true;
    }
}
