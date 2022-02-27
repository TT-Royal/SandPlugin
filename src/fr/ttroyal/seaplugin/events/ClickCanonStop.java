package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowSimple;

public class ClickCanonStop implements Listener {
    @EventHandler
    public void NukkitClickCanonStop(PlayerFormRespondedEvent event){

        Player player =event.getPlayer();
        if(event.getResponse() == null) return;
        if(event.getWindow().wasClosed()) return;
        if(event.getWindow() instanceof FormWindowSimple){
            FormWindowSimple form = (FormWindowSimple) event.getWindow();
            String element = form.getResponse().getClickedButton().getText();

            if(element == "§l§7»§r Eteindre le canon"){
                Entity entity =  player.getLevel().getEntity( player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getInt("CanonID-"+player.getLevelName()) );
                event.getPlayer().getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("CanonStatus-"+entity.getId(), false);
                player.getLevel().getEntity( player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getInt("CanonID-"+ player.getLevelName()) ).setNameTag("   §7» §l§6Canon§r   \n \n\n§r Etat : §cEteindre§r\nBoulets :§7 "+ player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getInt("CanonBoulets-"+entity.getId()));
                player.getServer().getPluginManager().getPlugin("SeaPlugin").saveConfig();

                player.getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();
            }
        }
    }
}
