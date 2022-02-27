package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.inventory.InventoryMoveItemEvent;
import cn.nukkit.event.inventory.InventoryTransactionEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;

public class PlayerChangeItemInventory implements Listener {
    @EventHandler
    public void NukkitplayerChangeItemInventory(InventoryMoveItemEvent event) {
        Item item = event.getItem();
        Item menu = Item.get(-200);
        if(event.getItem().getId() == -200){
            event.setCancelled();
        }

        }

}
