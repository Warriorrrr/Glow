package dev.warriorrr.glow;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Glow extends JavaPlugin implements Listener {

    public static Glow plugin;

    @Override
    public void onEnable() {
        plugin = this;
        
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    public static Glow getPlugin() {
        return plugin;
    }
}
