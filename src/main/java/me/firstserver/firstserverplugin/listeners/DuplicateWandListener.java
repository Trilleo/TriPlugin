package me.firstserver.firstserverplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class DuplicateWandListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if (event.getHand() == null){
            return;
        }

        if (event.getHand().equals(EquipmentSlot.OFF_HAND)){
            return;
        }

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){

            if (player.getInventory().getItemInMainHand().getItemMeta() == null){
                return;
            }

            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "" + ChatColor.BOLD + "Duplicate Wand")){

                Material click = event.getClickedBlock().getType();


                if (click.equals(Material.BEDROCK)||click.equals(Material.BARRIER)||click.equals(Material.NETHERITE_BLOCK)){
                    player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
                    player.sendMessage(ChatColor.DARK_RED + "You can't duplicate this block!");
                    return;
                }

                ItemStack remove = player.getInventory().getItemInMainHand();
                remove.setAmount(remove.getAmount() - 1);
                ItemStack block = new ItemStack(event.getClickedBlock().getType(), 32);
                player.getInventory().addItem(block);
                player.sendMessage(ChatColor.GREEN + "Successfully duplicated the block");
                System.out.println(player.getDisplayName() + " used the Duplicate Wand.");

            }

        }

    }

}
