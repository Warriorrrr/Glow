package dev.warriorrr.glow;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Glow extends JavaPlugin {

    public  static List<Player> glowingPlayers = new ArrayList<Player>();
    private static Glow plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    public static Glow getPlugin() {
        return plugin;
    }
}
