package me.firstserver.firstserverplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

import java.util.ArrayList;

public class SpawnerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            if(args.length < 1){

                player.sendMessage(ChatColor.DARK_RED + "You can't use this command like that!");
                player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

            } else if (args.length > 1) {

                player.sendMessage(ChatColor.DARK_RED + "You can't use this command like that!");
                player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);

            }else {

                EntityType mob = EntityType.valueOf(args[0].toUpperCase());

                Location location = player.getLocation();

                ItemStack spawner = new ItemStack(Material.SPAWNER, 1);
                BlockStateMeta meta = (BlockStateMeta) spawner.getItemMeta();
                CreatureSpawner CS = (CreatureSpawner) meta.getBlockState();
                CS.setSpawnedType(mob);
                meta.setBlockState(CS);
                meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Spawner");
                ArrayList<String> spawnerLore = new ArrayList<>();
                spawnerLore.add(ChatColor.GREEN + mob.name() + " spawner");
                meta.setLore(spawnerLore);
                spawner.setItemMeta(meta);

                player.getInventory().addItem(spawner);
                player.sendMessage(ChatColor.YELLOW + "You got a " + mob.name() + " spawner!");
                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

            }

        }

        return true;
    }
}
