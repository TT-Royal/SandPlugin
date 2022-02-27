package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.level.Position;
import cn.nukkit.potion.Effect;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;

public class SendCreateForm implements Listener {
    @EventHandler
    public void NukkitSendCreateForm(PlayerFormRespondedEvent event) {
        Player player = event.getPlayer();

        if(event.getWindow().wasClosed()) return;
        if(event.getWindow() instanceof FormWindowCustom){
            FormWindowCustom formWindowCustom = (FormWindowCustom) event.getWindow();
            if(formWindowCustom.getTitle() == "§6Créer une île"){
                                player.getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();
             player.sendTip( " §2Votre île à été créer.");
                player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("name " + player.getName(), formWindowCustom.getResponse().getInputResponse(0));
                player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("desc " + player.getName(), formWindowCustom.getResponse().getInputResponse(1));
                player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("public " + player.getName(), formWindowCustom.getResponse().getToggleResponse(2));
                player.getServer().getPluginManager().getPlugin("SeaPlugin").saveConfig();

               // player.getServer().generateLevel("ile"+ player.getName());
                player.getServer().dispatchCommand(player.getServer().getConsoleSender(),"mw copy ile ile" + player.getName());
                player.sendTitle("§2Création","de l'ile",0,60,0);
                player.addEffect(Effect.getEffectByName("blindness").setDuration(100).setVisible(false));
                player.teleport(player.getServer().getLevelByName("ile"+player.getName()).getSafeSpawn().getLocation());
                Position pos = new Position(0.5, 15, 0.5);
                player.teleport(pos);

            }
        }


    }
}
