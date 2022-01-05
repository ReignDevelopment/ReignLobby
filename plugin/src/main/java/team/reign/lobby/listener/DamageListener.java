package team.reign.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof org.bukkit.entity.Player)
            e.setCancelled(true);
        if (e.getDamager() instanceof org.bukkit.entity.Player)
            e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof org.bukkit.entity.Player && e.getCause() == EntityDamageEvent.DamageCause.FALL)
            e.setCancelled(true);
    }
}
