package me.firstserver.firstserverplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class FartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (((Player) sender).getPlayer());
            if (args.length == 0){

                player.setHealth(0.0);
                player.sendMessage(ChatColor.DARK_RED + "You just farted on yourself. How does that feel?");
                player.playSound(player, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);

            }else if (args.length >=2) {

                player.setHealth(0.0);
                player.sendMessage(ChatColor.DARK_RED + "You can't use this command like that. Die!!!");
                player.playSound(player, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);

            }else {

                String targetName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(targetName);

                if (target == null){

                    player.setHealth(0.0);
                    player.sendMessage(ChatColor.DARK_RED + "That player is not online. Die!!!");
                    player.playSound(player, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);

                }else {

                    target.setHealth(0.0);
                    player.sendMessage(ChatColor.DARK_RED + "You successfully farted on " + target.getDisplayName());
                    target.sendMessage(ChatColor.DARK_RED + "You get farted by " + player.getDisplayName() + ". Die!!!");
                    target.playSound(target, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);

                }

            }

        }else if (sender instanceof ConsoleCommandSender) {

            if (args.length == 0) {

                System.out.println("You can't use this command like that.");

            } else if (args.length >= 4) {

                System.out.println("You can't use this command like that.");

            } else {

                String targetName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(targetName);

                if (target == null) {

                    System.out.println("That player is not online.");

                } else {

                    target.setHealth(0.0);
                    System.out.println("You successfully farted on " + target.getDisplayName());
                    target.sendMessage(ChatColor.DARK_RED + "You get farted by operator. Die!!!");
                    target.playSound(target, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);

                }
            }
        }

        return true;

    }
}