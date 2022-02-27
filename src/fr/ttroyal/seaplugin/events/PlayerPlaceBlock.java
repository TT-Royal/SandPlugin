package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceBlock implements Listener {
    @EventHandler
    public void NukkitPlaceBlock(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if(player.getInventory().getItemInHand().getId() == -200){
            event.setCancelled(true);
            player.sendTip("§cVous ne pouvez pas poser ce bloc.");
        }
    }
}
