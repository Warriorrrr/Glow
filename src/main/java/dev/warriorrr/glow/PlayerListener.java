package dev.warriorrr.glow;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.inventivetalent.glow.GlowAPI;

import static dev.warriorrr.glow.Glow.glowingPlayers;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        Bukkit.getScheduler().runTaskLater(Glow.getPlugin(), new Runnable() {
            @Override
            public void run() {
                updateGlowingPlayers(player);
                if (player.hasPermission("group.premium")) {
                    GlowAPI.setGlowing(player, GlowAPI.Color.PURPLE, Bukkit.getOnlinePlayers());
                    glowingPlayers.add(player);
                } else
                    GlowAPI.setGlowing(player, null, Bukkit.getOnlinePlayers());
            }
        }, 20L);
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        if (glowingPlayers.contains(event.getPlayer()))
            glowingPlayers.remove(event.getPlayer());
    }

    public void updateGlowingPlayers(Player player) {
        for (Player op : Bukkit.getOnlinePlayers()) {
            if (GlowAPI.isGlowing(op, player))
                GlowAPI.setGlowing(op, null, player);
            
            if (glowingPlayers.contains(op))
                GlowAPI.setGlowing(op, GlowAPI.Color.PURPLE, player);
        }
    }
}
