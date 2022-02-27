package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowCustom;

public class SendGererForm implements Listener {
    @EventHandler
    public void NukkitSendGererForm(PlayerFormRespondedEvent event){
        Player player = event.getPlayer();

        if(event.getWindow().wasClosed()) return;
        if(event.getWindow() instanceof FormWindowCustom){
            FormWindowCustom formWindowCustom = (FormWindowCustom) event.getWindow();
            if(formWindowCustom.getTitle() == "§6Gérer l'île"){
                player.getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();

                player.sendTip(" §2Votre île à bien été modifié");
                player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("name " + player.getName(), formWindowCustom.getResponse().getInputResponse(0));
                player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("desc " + player.getName(), formWindowCustom.getResponse().getInputResponse(1));player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("name " + player.getName(), formWindowCustom.getResponse().getInputResponse(0));
                player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("public " + player.getName(), formWindowCustom.getResponse().getToggleResponse(2));
                player.getServer().getPluginManager().getPlugin("SeaPlugin").saveConfig();

            }
        }
    }
}
