package me.firstserver.firstserverplugin.commands;

import me.firstserver.firstserverplugin.utility.HoloStick;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HoloStickCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            if (player.hasPermission("firstplugin.holostick")){

                player.getInventory().addItem(HoloStick.createHoloStick());
                player.sendMessage(ChatColor.GREEN + "Gave yourself a HoloStick");
                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                System.out.println(player.getDisplayName() + " got a HoloStick");

            }else {

                player.sendMessage(ChatColor.DARK_RED + "You don't have the permission!");
                player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

            }

        }

        return true;
    }
}
