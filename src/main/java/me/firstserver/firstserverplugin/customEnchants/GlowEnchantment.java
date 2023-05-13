package me.firstserver.firstserverplugin.customEnchants;

import me.firstserver.firstserverplugin.FirstServerPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class GlowEnchantment extends Enchantment implements Listener {

    public GlowEnchantment(String namespace){
        super(new NamespacedKey(FirstServerPlugin.getPlugin(), namespace));
    }

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent event){

        if (event.getDamager() instanceof Player){

            Player player = (Player) event.getDamager();

            if(player.getInventory().getItemInMainHand().getItemMeta() == null){
            } else if (player.getEquipment().getItemInMainHand().containsEnchantment(FirstServerPlugin.glowEnchantment)) {

                player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                event.getEntity().setGlowing(true);

            }

        }

    }

    @Override
    public String getName() {
        return "Glow";
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.WEAPON;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return true;
    }

}
