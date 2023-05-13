package me.firstserver.firstserverplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepeatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player player = ((Player) sender).getPlayer();

            if (args.length == 0) {

                player.sendMessage(ChatColor.DARK_RED + "You can't use this command like that!");
                player.sendMessage(ChatColor.GREEN + "Example: /repeat <message>");

            } else if (args.length == 1){

                String word = args[0];
                player.sendMessage(ChatColor.AQUA + "Message: " + ChatColor.GREEN + word);

            }else {

                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < args.length; i++){
                    stringBuilder.append(args[i]);
                    stringBuilder.append(" ");
                }

                String finalMessage = stringBuilder.toString();
                finalMessage = finalMessage.stripTrailing();

                player.sendMessage(ChatColor.AQUA + "Message: " + ChatColor.GREEN + finalMessage);

            }

        }
    return true;
    }
}
