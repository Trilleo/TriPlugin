package me.firstserver.firstserverplugin.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class ShearSheepListener implements Listener {

    @EventHandler
    public void onShearSheep(PlayerShearEntityEvent event){

        Player player = event.getPlayer();
        Entity entity = event.getEntity();

        if (entity.getType() == EntityType.SHEEP){
            player.sendMessage("§4This is a sheep! You can't do that!");
            player.playSound(player, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
            event.setCancelled(true);
        }else{
            player.sendMessage("§2This is not a sheep. You can shear it!");
            player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        }

    }

}
