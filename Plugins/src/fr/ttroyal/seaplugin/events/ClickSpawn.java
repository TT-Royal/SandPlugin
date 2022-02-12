package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.level.Level;
import cn.nukkit.level.Position;


public class ClickSpawn implements Listener {
    @EventHandler
    public void NukkitClickSpawn(PlayerFormRespondedEvent event){
        Player player = event.getPlayer();
        if(event.getResponse() == null) return;
        if(event.getWindow().wasClosed()) return;
        if(event.getWindow() instanceof FormWindowSimple){
            FormWindowSimple form = (FormWindowSimple) event.getWindow();
            String element = form.getResponse().getClickedButton().getText();

            if(element == "§l§7»§r Aller au Hub"){
                Level Hub = player.getServer().getLevelByName("Hub");
                Position pos = new Position(100, 100, 100, Hub);
                player.sendTip("§6Vous êtes maintenant au Hub!");
                player.teleport(pos);


            }

            }
        }
    }

