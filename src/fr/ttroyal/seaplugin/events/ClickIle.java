package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.level.Position;
import cn.nukkit.potion.Effect;

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
                player.teleport(player.getServer().getLevelByName("ile"+ player.getName()).getSafeSpawn().getLocation());
                player.sendTitle("§6Téloportation","à l'ile",0,30,0);
                player.addEffect(Effect.getEffectByName("blindness").setDuration(50).setVisible(false));
                Position pos = new Position(0.5, 15, 0.5);
                player.teleport(pos);
            }
        }

    }
}
