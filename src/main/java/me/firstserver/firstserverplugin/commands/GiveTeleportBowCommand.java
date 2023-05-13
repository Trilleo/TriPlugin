package me.firstserver.firstserverplugin.commands;

import me.firstserver.firstserverplugin.utility.BowUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveTeleportBowCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            if (player.hasPermission("firstplugin.tpbow")){

                if (args.length == 0){

                    ItemStack bow = BowUtils.createTPBow();

                    player.getInventory().addItem(bow);
                    player.getInventory().addItem(new ItemStack(Material.ARROW, 1));

                    player.sendMessage(ChatColor.YELLOW + "Gave yourself a Teleport Bow!");
                    player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                }else {

                    String targetName = args[0];

                    Player target = Bukkit.getServer().getPlayerExact(targetName);

                    if (target == null){

                        player.sendMessage(ChatColor.DARK_RED + "That player is not online.");
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                    } else if (target.hasPermission("firstplugin.tpbow")) {

                        ItemStack bow = BowUtils.createTPBow();

                        target.getInventory().addItem(bow);
                        target.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                        target.sendMessage(ChatColor.YELLOW + "You are given a Teleport Bow by " + player.getDisplayName());
                        target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                        player.sendMessage(ChatColor.YELLOW + "Gave " + target.getDisplayName() + " a Teleport Bow");

                    }else {

                        player.sendMessage(ChatColor.DARK_RED + "That player does not have the permission!");
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                    }

                }

            }

        }

        return true;
    }
}
