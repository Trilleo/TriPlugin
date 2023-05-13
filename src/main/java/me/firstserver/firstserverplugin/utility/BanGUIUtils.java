package me.firstserver.firstserverplugin.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BanGUIUtils {

    public static void openMenu(Player player){

        ArrayList<Player> list = new ArrayList<>(player.getServer().getOnlinePlayers());

        Inventory banGUI = Bukkit.createInventory(player, 27, ChatColor.GOLD + "First Server Ban GUI");

        for (int i = 0; i < list.size(); i++) {

            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta headMeta = playerHead.getItemMeta();
            headMeta.setDisplayName(ChatColor.DARK_RED + list.get(i).getDisplayName());

            ArrayList<String> headLore = new ArrayList<>();
            headLore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Ban this player!");

            playerHead.setItemMeta(headMeta);

            banGUI.addItem(playerHead);

        }

        player.openInventory(banGUI);
        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

    }

    public static void openConfirmMenu(Player player, Player target){

        Inventory confirmBan = Bukkit.createInventory(player, 9, ChatColor.GREEN + "Confirm?");

        //Confirm
        ItemStack ban = new ItemStack(Material.GREEN_WOOL, 1);
        ItemMeta banMeta = ban.getItemMeta();
        banMeta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Confirm");
        ban.setItemMeta(banMeta);
        confirmBan.setItem(1, ban);

        //PHead
        ItemStack pHead = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta pHeadMeta = pHead.getItemMeta();
        pHeadMeta.setDisplayName(ChatColor.DARK_RED + target.getDisplayName());
        pHead.setItemMeta(pHeadMeta);
        confirmBan.setItem(4, pHead);

        //Cancel
        ItemStack cancel = new ItemStack(Material.BARRIER, 1);
        ItemMeta cancelMeta = cancel.getItemMeta();
        cancelMeta.setDisplayName(ChatColor.RED + "Cancel");
        cancel.setItemMeta(cancelMeta);
        confirmBan.setItem(7, cancel);

        //Air
        ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta airMeta = air.getItemMeta();
        airMeta.setDisplayName(" ");
        air.setItemMeta(airMeta);

        confirmBan.setItem(0, air);
        confirmBan.setItem(2, air);
        confirmBan.setItem(3, air);
        confirmBan.setItem(5, air);
        confirmBan.setItem(6, air);
        confirmBan.setItem(8, air);

        player.openInventory(confirmBan);
        player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

    }

}
