package me.firstserver.firstserverplugin.commands;

import me.firstserver.firstserverplugin.FirstServerPlugin;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class FirstServerCommand implements CommandExecutor {

    FirstServerPlugin plugin;
    public FirstServerCommand(FirstServerPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length >= 1 && args[0].equalsIgnoreCase("reload")){

            plugin.reloadConfig();

            if (sender instanceof Player){

                Player player = (Player) sender;
                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendMessage(ChatColor.GREEN + "Plugin for First Server has reloaded!");

            } else if (sender instanceof ConsoleCommandSender) {

                System.out.println("Plugin for First Server has reloaded!");

            }

            return true;

        }

        if (args.length >= 1 && args[0].equalsIgnoreCase("balance")){

            if (sender instanceof Player){

                Player player = (Player) sender;
                Economy economy = FirstServerPlugin.getEconomy();

                if (args.length == 1){

                    player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                    player.sendMessage(String.format(ChatColor.GREEN + "Current balance: " + ChatColor.GOLD + economy.format(economy.getBalance(player))));

                } else if (args.length == 2) {

                    String targetName = args[1];
                    Player target = Bukkit.getServer().getPlayerExact(targetName);

                    if (target == null){

                        player.sendMessage(ChatColor.DARK_RED + "That player isn't online!");
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                    }else {

                        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                        player.sendMessage(String.format(ChatColor.GREEN + "Current balance for " + targetName + ": " + ChatColor.GOLD + economy.format(economy.getBalance(target))));

                    }

                }

            }

            return true;

        }

        if (args.length >= 1 && args[0].equalsIgnoreCase("on")){

            if (sender instanceof ConsoleCommandSender){

                plugin.getConfig().set("is-closed", false);
                plugin.saveConfig();
                plugin.reloadConfig();
                System.out.println("Turned on the server.");

            } else if (sender instanceof Player) {

                Player player = (Player) sender;

                if (player.isOp()){

                    plugin.getConfig().set("is-closed", false);
                    plugin.saveConfig();
                    plugin.reloadConfig();
                    System.out.println("Turned on the server.");
                    player.sendMessage(ChatColor.GREEN + "Turned on the server.");
                    player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                }else {

                    player.sendMessage(ChatColor.DARK_RED + "You don't have the permission.");
                    player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                }

            }

            return true;

        }

        if (args.length >= 1 && args[0].equalsIgnoreCase("off")){

            if (sender instanceof ConsoleCommandSender){

                plugin.getConfig().set("is-closed", true);
                plugin.saveConfig();
                plugin.reloadConfig();
                System.out.println("Turned off the server.");

            }else if (sender instanceof Player) {

                Player player = (Player) sender;

                if (player.isOp()){

                    plugin.getConfig().set("is-closed", true);
                    plugin.saveConfig();
                    plugin.reloadConfig();
                    System.out.println("Turned off the server.");
                    player.sendMessage(ChatColor.GREEN + "Turned off the server.");
                    player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                }else {

                    player.sendMessage(ChatColor.DARK_RED + "You don't have the permission.");
                    player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                }

            }

            return true;

        }

        if (sender instanceof Player){

            Player player = (Player) sender;
            player.sendMessage(ChatColor.DARK_RED + "Nothing to show!");

        } else if (sender instanceof ConsoleCommandSender) {

            System.out.println("Nothing to show.");

        }

        return true;
    }
}
