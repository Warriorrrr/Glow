package dev.warriorrr.glow;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.inventivetalent.glow.GlowAPI;
import org.inventivetalent.glow.GlowAPI.Color;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("group.premium")) {
            Bukkit.getScheduler().runTaskLater(Glow.getPlugin(), new Runnable(){
                public void run() {
                    GlowAPI.setGlowing(event.getPlayer(), Color.PURPLE, Bukkit.getOnlinePlayers());
                }
            }, 5);
        }
    }
}