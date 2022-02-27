package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;

public class PlayerDestroyBlock implements Listener {
    @EventHandler
    public void NukkitPlayerDestroyBlock(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(player.getInventory().getItemInHand().getId() == -200){
            event.setCancelled(true);
        }
    }
}
