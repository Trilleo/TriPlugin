package me.firstserver.firstserverplugin.listeners;

import me.firstserver.firstserverplugin.events.SpawnerBreakEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){

        Block blockBroken = event.getBlock();
        Player player = event.getPlayer();

        if (blockBroken.getType().equals(Material.SPAWNER) && player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)){

            Bukkit.getServer().getPluginManager().callEvent(new SpawnerBreakEvent(event.getPlayer(), blockBroken));

        }

    }

}
