package me.firstserver.firstserverplugin.listeners;

import me.firstserver.firstserverplugin.FirstServerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class JoinLeaveListener implements Listener {

    FirstServerPlugin plugin;

    public JoinLeaveListener(FirstServerPlugin instance){
        this.plugin = instance;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event){

        if (plugin.getConfig().getBoolean("is-closed")) {

            Player player = event.getPlayer();

            if (!player.isOp()) {

                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.DARK_RED + "" + ChatColor.BOLD + "The server is closed. Please come back later!");
                System.out.println(player.getDisplayName() + " tried to join, but get kicked.");
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + player.getDisplayName() + ChatColor.RED + " tried to join, but get kicked.");

            }

        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if (player.hasPlayedBefore()){

            if (plugin.getConfig().getBoolean("is-closed")){

                event.setJoinMessage("§b§kXX§r §f[§2+§f]§r " + player.getDisplayName() + " §b§kXX§r");
                player.playSound(player, Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0f, 1.0f);
                player.sendTitle(ChatColor.DARK_RED + "" + ChatColor.BOLD + "WARNING", ChatColor.DARK_GRAY + "The server is closed now.", 40, 100, 40);

            }else {

                event.setJoinMessage("§b§kXX§r §f[§2+§f]§r " + player.getDisplayName() + " §b§kXX§r");
                player.playSound(player, Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0f, 1.0f);
                player.sendTitle("§4§kXX §r§6First Server §r§4§kXX§r", ChatColor.YELLOW + "Welcome to the server, " + player.getDisplayName(), 40, 100, 40);

            }

        }else{

            event.setJoinMessage(ChatColor.YELLOW + player.getDisplayName() + " joined the server for the first time. Welcome!");
            player.playSound(player, Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0f, 1.0f);
            player.sendTitle("§4§kXX §r§6First Server §r§4§kXX§r", ChatColor.YELLOW + "Welcome to the server, " + player.getDisplayName(), 40, 100, 40);

        }

        if (Bukkit.getServer().getWorld("spawn") == null){
            return;
        }

        Location spawn = Objects.requireNonNull(Bukkit.getServer().getWorld("spawn")).getSpawnLocation();

        player.teleport(spawn);

        player.getInventory().clear();

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){

        Player player = event.getPlayer();
        event.setQuitMessage("§b§kXX§r §f[§4-§f]§r " + player.getDisplayName() + " §b§kXX§r");

    }

}
