package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowSimple;

public class ClickIle implements Listener {
    @EventHandler
    public void NukkitClickIle(PlayerFormRespondedEvent event){
        Player player = event.getPlayer();
        if(event.getResponse() == null) return;
        if(event.getWindow().wasClosed()) return;
        if(event.getWindow() instanceof FormWindowSimple){
            FormWindowSimple form = (FormWindowSimple) event.getWindow();
            String element = form.getResponse().getClickedButton().getText();

            if(element == "§l§7»§r Aller sur mon île"){
                player.teleport(player.getServer().getLevelByName("ile"+ player.getName()).getSpawnLocation().getLocation());
                player.sendTip("§2Vous êtes maintenant sur votre île!");
                player.createBossBar("Bienvenue sur votre Île",0);
            }
        }

    }
}
