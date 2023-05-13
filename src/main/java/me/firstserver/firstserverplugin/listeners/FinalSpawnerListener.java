package me.firstserver.firstserverplugin.listeners;

import me.firstserver.firstserverplugin.events.SpawnerBreakEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class FinalSpawnerListener implements Listener {

    @EventHandler
    public void onSpawnerBreak(SpawnerBreakEvent event){

        Player player = event.getBreaker();
        CreatureSpawner CS = (CreatureSpawner) event.getSpawner().getState();
        EntityType mob = CS.getSpawnedType();

        ItemStack spawner = new ItemStack(Material.SPAWNER, 1);
        BlockStateMeta meta = (BlockStateMeta) spawner.getItemMeta();
        CreatureSpawner finalCS = (CreatureSpawner) meta.getBlockState();
        finalCS.setSpawnedType(CS.getSpawnedType());
        meta.setBlockState(finalCS);
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Spawner");
        ArrayList<String> spawnerLore = new ArrayList<>();
        spawnerLore.add(ChatColor.GREEN + mob.name() + " spawner");
        meta.setLore(spawnerLore);
        spawner.setItemMeta(meta);

        player.getInventory().addItem(spawner);
        player.sendMessage(ChatColor.YELLOW + "You mined a " + mob.name() + " spawner!");
        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

    }

}
