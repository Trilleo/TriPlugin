package me.firstserver.firstserverplugin;

import me.firstserver.firstserverplugin.commands.*;
import me.firstserver.firstserverplugin.customEnchants.GlowEnchantment;
import me.firstserver.firstserverplugin.listeners.*;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public final class FirstServerPlugin extends JavaPlugin {

    //
    //
    //
    public String version = "1.6.0";
    //
    //
    //
    //
    //
    //
    //Lists
    public ArrayList<Player> launched_players = new ArrayList<>();
    public ArrayList<Player> creating_hologram_players = new ArrayList<>();
    //
    //
    //
    //
    //
    //
    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;

    private static FirstServerPlugin plugin;
    public static GlowEnchantment glowEnchantment;

    public static FirstServerPlugin getPlugin(){
        return plugin;
    }

    public FirstServerPlugin instance;

    public FirstServerPlugin(){
        instance = this;
    }

    @Override
    public void onDisable() {

        //UnregisterEnchants
        try {
            Field keyField = Enchantment.class.getDeclaredField("byKey");

            keyField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) keyField.get(null);

            if(byKey.containsKey(glowEnchantment.getKey())) {
                byKey.remove(glowEnchantment.getKey());
            }
            Field nameField = Enchantment.class.getDeclaredField("byName");

            nameField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) nameField.get(null);

            if(byName.containsKey(glowEnchantment.getName())) {
                byName.remove(glowEnchantment.getName());
            }
        } catch (Exception ignored) { }

        System.out.println("Plugin for First Server has stopped!");
        System.out.println("Bye :)");

    }

    @Override
    public void onEnable() {

        plugin = this;
        glowEnchantment = new GlowEnchantment("Glow");

        //Text
        System.out.println("Plugin for First Server is loading...");
        System.out.println("                                     ");
        System.out.println("   -Plugin for Trilleo Server        ");
        System.out.println("                                     ");
        System.out.println("   -Version: " + version);
        System.out.println("                                     ");
        System.out.println("   -Made by Trilleo                  ");
        System.out.println("                                     ");

        //Event listeners
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(instance), this);
        getServer().getPluginManager().registerEvents(new TeleportBowListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new FinalSpawnerListener(), this);
        getServer().getPluginManager().registerEvents(new LaunchPadListener(this), this);
        getServer().getPluginManager().registerEvents(new LaunchDamageListener(this), this);
        getServer().getPluginManager().registerEvents(glowEnchantment, this);
        getServer().getPluginManager().registerEvents(new WaterStickListener(), this);
        getServer().getPluginManager().registerEvents(new MainItemListener(), this);
        getServer().getPluginManager().registerEvents(new GUIListener(), this);
        getServer().getPluginManager().registerEvents(new DuplicateWandListener(), this);
        getServer().getPluginManager().registerEvents(new HoloStickListener(this), this);
        getServer().getPluginManager().registerEvents(new SpawnJumpListener(), this);
        getServer().getPluginManager().registerEvents(new TeleportWandListener(), this);
        getServer().getPluginManager().registerEvents(new ColorMessageListener(), this);

        System.out.println("Loaded events...");

        //Commands
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("repeat").setExecutor(new RepeatCommand());
        getCommand("joinc").setExecutor(new JoinConsoleCommand());
        getCommand("leavec").setExecutor(new LeaveConsoleCommand());
        getCommand("fart").setExecutor(new FartCommand());
        getCommand("tpbow").setExecutor(new GiveTeleportBowCommand());
        getCommand("opitems").setExecutor(new OPItemsCommand());
        getCommand("firstserver").setExecutor(new FirstServerCommand(this));
        getCommand("bangui").setExecutor(new BanGUICommand());
        getCommand("spawner").setExecutor(new SpawnerCommand());
        getCommand("glowstick").setExecutor(new GlowStickCommand());
        getCommand("lock").setExecutor(new LockCommand());
        getCommand("holostick").setExecutor(new HoloStickCommand());
        getCommand("fallingblock").setExecutor(new FallingBlockCommand());
        

        System.out.println("Loaded commands...");

        //RegisterEnchants
        registerEnchantment(glowEnchantment);

        //Vault setup
        if (!setupEconomy() ) {
            System.out.println("No economy plugin found! Disabling Plugin for First Server.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        //Setup config file
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        System.out.println("All preparations done! The plugin is ready to use.");

    }

    //Vault setup
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    //Enchants
    public static void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
        if(registered){
            // It's been registered!
        }
    }

}
