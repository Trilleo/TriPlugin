package me.firstserver.firstserverplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ColorMessageListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){

        event.setCancelled(true);

        String chat = event.getMessage();

        String color = ChatColor.translateAlternateColorCodes('&', chat);

        Player player = event.getPlayer();

        player.sendMessage(ChatColor.GREEN + "You successfully sent a colored message in chat");

        player.chat(color);

    }

}
