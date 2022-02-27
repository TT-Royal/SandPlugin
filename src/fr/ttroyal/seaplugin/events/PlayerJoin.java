package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.block.BlockID;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerLoginEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.level.Level;
import cn.nukkit.level.Position;

public class PlayerJoin implements Listener {
    @EventHandler
    public void NukkitPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage("§l[§r§a+§r§l] §r§7" + player.getName());

        Level Hub = player.getServer().getLevelByName("Hub");
        Position pos = new Position(100,100,100, Hub);
        if(player.hasPlayedBefore() == false){
            player.getServer().broadcastMessage("§l[§r§a+§r§l] §r§e" + player.getName() + " a rejoint le serveur pour la première fois!");
        }
        player.teleport(pos);
        Item menu = Item.get(-200,0,1).setCustomName("§6Menu").setLore("§8Cette item vous permet d'ouvrir\nl'interface de menu pour vous déplacer\net gérer votre île.");
        player.getInventory().setItem(8, menu);
    }
}
