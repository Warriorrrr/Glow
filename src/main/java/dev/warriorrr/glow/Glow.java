package dev.warriorrr.glow;

import org.bukkit.plugin.java.JavaPlugin;
import org.inventivetalent.glow.GlowAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Glow extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onPlayerJoin(PlayerJoinEvent event) {
                if (event.getPlayer().hasPermission("group.premium"))
                    GlowAPI.setGlowing(event.getPlayer(), GlowAPI.Color.PURPLE, Bukkit.getOnlinePlayers());
            }
        }, this);
    }
}
