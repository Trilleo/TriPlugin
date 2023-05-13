package me.firstserver.firstserverplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = ((Player) sender).getPlayer();

            if(player.hasPermission("firstplugin.god")){

                if (player.isInvulnerable()){

                    player.setInvulnerable(false);
                    player.sendMessage(ChatColor.GREEN + "God mode disabled!");

                }else {

                    player.setInvulnerable(true);
                    player.sendMessage(ChatColor.RED + "God mode enabled!");

                }

            }else {

                player.sendMessage(ChatColor.DARK_RED + "You don't have the permission!");

            }

        }

        return true;
    }

}
