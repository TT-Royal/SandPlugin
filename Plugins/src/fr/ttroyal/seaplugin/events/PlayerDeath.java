package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;

public class PlayerDeath implements Listener {
    @EventHandler
    public void NukkitPlayerDeath(PlayerDeathEvent event){
        Player player = event.getEntity().getPlayer();
        event.setDeathMessage("" );


    }
}
