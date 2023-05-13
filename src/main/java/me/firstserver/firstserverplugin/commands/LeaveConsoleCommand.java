package me.firstserver.firstserverplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class LeaveConsoleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = ((Player) sender).getPlayer();
            player.sendMessage(ChatColor.DARK_RED + "You can't do that!");

        } else if (sender instanceof ConsoleCommandSender) {

            if (args.length == 0){

                System.out.println("You can't use this command like that.");

            }else {

                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if (target == null){

                    System.out.println("This player is not online.");

                }else {

                    System.out.println("Successfully told this player.");
                    target.sendMessage(ChatColor.RED + "Xfirst_playerX left the console. Bye :)");

                }

            }

        }

        return true;
    }
}
