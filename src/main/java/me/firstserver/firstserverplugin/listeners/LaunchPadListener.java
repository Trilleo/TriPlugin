package me.firstserver.firstserverplugin.listeners;

import me.firstserver.firstserverplugin.FirstServerPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class LaunchPadListener implements Listener {


    FirstServerPlugin plugin;

    public LaunchPadListener(FirstServerPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerWalk(PlayerMoveEvent event) {

        if (plugin.getConfig().getBoolean("enableLaunchPad")){

            Player player = event.getPlayer();
            Location blockUnder = player.getLocation();
            blockUnder.setY(blockUnder.getY() - 1);

            if (player.getLocation().getBlock().getType().equals(Material.valueOf(plugin.getConfig().getString("top-block"))) && blockUnder.getBlock().getType().equals(Material.valueOf(plugin.getConfig().getString("button-block")))){

                player.setVelocity(player.getLocation().getDirection().multiply(3).setY(1));
                plugin.launched_players.add(player);

            }else if (!blockUnder.getBlock().getType().equals(Material.AIR) && plugin.launched_players.contains(player)){

                plugin.launched_players.remove(player);

            }

        }

    }

}
