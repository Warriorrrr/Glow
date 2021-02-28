package dev.warriorrr.glow;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.inventivetalent.glow.GlowAPI;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("group.premium"))
            GlowAPI.setGlowing(event.getPlayer(), GlowAPI.Color.PURPLE, Bukkit.getOnlinePlayers());
    }
}