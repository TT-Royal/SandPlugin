package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;

public class OnChat implements Listener {
    @EventHandler
    public void NukkitOnChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);
        if(player.getName().equals("plutosophe")) {
            player.getServer().broadcastMessage("[§7"+player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getString("name "+player.getName(),"sans île")+"§r]" + " §4\uE105 TT Royal" + " §l§6»§r " + event.getMessage());
        }else if(player.isOp()){
            player.getServer().broadcastMessage("[§7"+player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getString("name "+player.getName(),"sans île")+"§r] §c\uE105 " + player.getName() + " §l§6»§r " + event.getMessage());
        }else{
            player.getServer().broadcastMessage("[§7"+player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getString("name "+player.getName(),"sans île")+"§r] " + player.getName() + " §l§6»§r " + event.getMessage());

        }
    }
}