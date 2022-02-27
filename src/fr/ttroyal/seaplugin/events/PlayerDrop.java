package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDropItemEvent;

public class PlayerDrop implements Listener {
    @EventHandler
    public void NukkitPlayerDrop(PlayerDropItemEvent event){
        Player player = event.getPlayer();
        if(event.getItem().getId() == -200){
            event.setCancelled(true);
            player.sendTip("§cVous ne pouvez pas jeter cet item.");
        }
    }
}
