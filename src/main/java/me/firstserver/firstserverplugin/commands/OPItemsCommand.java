package me.firstserver.firstserverplugin.commands;

import me.firstserver.firstserverplugin.utility.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OPItemsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if (args.length == 0){

                GUIManager.openOPMenu(player);

            }else if (args.length >= 1){

                String itemType = args[0];

                if (itemType.equalsIgnoreCase("sword")){

                    if (args.length == 1){

                        ItemStack sword = OPSword.createOPSword();

                        player.getInventory().addItem(sword);
                        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                        player.sendMessage(ChatColor.YELLOW + "Gave yourself an OP Sword!");

                    }else if (args.length == 2){

                        String targetName = args[1];

                        Player target = Bukkit.getServer().getPlayerExact(targetName);

                        if (target == null) {

                            player.sendMessage(ChatColor.DARK_RED + "That player is not online.");
                            player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                        } else {

                            ItemStack sword = OPSword.createOPSword();

                            target.getInventory().addItem(sword);
                            target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                            target.sendMessage(ChatColor.YELLOW + "You are given an OP Sword by " + player.getDisplayName());

                            player.sendMessage(ChatColor.YELLOW + "Gave " + target.getDisplayName() + " an OP Sword");

                        }

                    }else {

                        player.sendMessage(ChatColor.DARK_RED + "You can't use this command like that.");
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                    }

                } else if (itemType.equalsIgnoreCase("bow")) {

                    if (args.length == 1){

                        ItemStack bow = OPBow.createOPBow();

                        player.getInventory().addItem(bow);
                        player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                        player.sendMessage(ChatColor.YELLOW + "Gave yourself an OP Bow!");

                    }else if (args.length == 2){

                        String targetName = args[1];

                        Player target = Bukkit.getServer().getPlayerExact(targetName);

                        if (target == null) {

                            player.sendMessage(ChatColor.DARK_RED + "That player is not online.");
                            player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                        } else {

                            ItemStack bow = OPBow.createOPBow();

                            target.getInventory().addItem(bow);
                            target.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                            target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                            target.sendMessage(ChatColor.YELLOW + "You are given an OP Bow by " + player.getDisplayName());

                            player.sendMessage(ChatColor.YELLOW + "Gave " + target.getDisplayName() + ChatColor.YELLOW + " an OP Bow");

                        }

                    }else {

                        player.sendMessage(ChatColor.DARK_RED + "You can't use this command like that.");
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                    }

                }else if (itemType.equalsIgnoreCase("knockbackstick")||itemType.equalsIgnoreCase("kbstick")) {

                    if (args.length == 1) {

                        ItemStack stick = KnockbackStick.createKnockbackStick();

                        player.getInventory().addItem(stick);
                        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                        player.sendMessage(ChatColor.YELLOW + "Gave yourself a Knockback Stick!");

                    } else if (args.length == 2) {

                        String targetName = args[1];

                        Player target = Bukkit.getServer().getPlayerExact(targetName);

                        if (target == null) {

                            player.sendMessage(ChatColor.DARK_RED + "That player is not online.");
                            player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                        } else {

                            ItemStack stick = KnockbackStick.createKnockbackStick();

                            target.getInventory().addItem(stick);
                            target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                            target.sendMessage(ChatColor.YELLOW + "You are given a Knockback Stick by " + player.getDisplayName());

                            player.sendMessage(ChatColor.YELLOW + "Gave " + target.getDisplayName() + " a Knockback Stick");

                        }

                    } else {

                        player.sendMessage(ChatColor.DARK_RED + "You can't use this command like that.");
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                    }

                }else if (itemType.equalsIgnoreCase("waterstick")) {

                    if (args.length == 1) {

                        ItemStack stick = WaterStick.createWaterStick();

                        player.getInventory().addItem(stick);
                        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                        player.sendMessage(ChatColor.YELLOW + "Gave yourself a Water Stick!");

                    } else if (args.length == 2) {

                        String targetName = args[1];

                        Player target = Bukkit.getServer().getPlayerExact(targetName);

                        if (target == null) {

                            player.sendMessage(ChatColor.DARK_RED + "That player is not online.");
                            player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                        } else {

                            ItemStack stick = WaterStick.createWaterStick();

                            target.getInventory().addItem(stick);
                            target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                            target.sendMessage(ChatColor.YELLOW + "You are given a Water Stick by " + player.getDisplayName());

                            player.sendMessage(ChatColor.YELLOW + "Gave " + target.getDisplayName() + " a Water Stick");

                        }

                    } else {

                        player.sendMessage(ChatColor.DARK_RED + "You can't use this command like that.");
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                    }

                }else if (itemType.equalsIgnoreCase("teleportwand") || itemType.equalsIgnoreCase("tpwand")) {

                    if (args.length == 1) {

                        ItemStack stick = TeleportWand.createTeleportWand();

                        player.getInventory().addItem(stick);
                        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                        player.sendMessage(ChatColor.YELLOW + "Gave yourself a Teleport Wand!");

                    } else if (args.length == 2) {

                        String targetName = args[1];

                        Player target = Bukkit.getServer().getPlayerExact(targetName);

                        if (target == null) {

                            player.sendMessage(ChatColor.DARK_RED + "That player is not online.");
                            player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                        } else {

                            ItemStack stick = TeleportWand.createTeleportWand();

                            target.getInventory().addItem(stick);
                            target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                            target.sendMessage(ChatColor.YELLOW + "You are given a Teleport Wand by " + player.getDisplayName());

                            player.sendMessage(ChatColor.YELLOW + "Gave " + target.getDisplayName() + " a Teleport Wand");

                        }

                    } else {

                        player.sendMessage(ChatColor.DARK_RED + "You can't use this command like that.");
                        player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

                    }

                }

            }

        }

        return true;
    }

}
