package me.firstserver.firstserverplugin.commands;

import me.firstserver.firstserverplugin.utility.BanGUIUtils;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class BanGUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof ConsoleCommandSender){

            System.out.println("You can't do that!");

        } else if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("firstserver.bangui")){

                BanGUIUtils.openMenu(player);

            }

        }

        return true;
    }

}
