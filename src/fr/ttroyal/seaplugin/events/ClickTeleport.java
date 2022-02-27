package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;

public class ClickTeleport implements Listener {
    @EventHandler
    public void NukkitClickTeleport(PlayerFormRespondedEvent event){
        Player player = event.getPlayer();
        if(event.getResponse() == null) return;
        if(event.getWindow().wasClosed()) return;
        if(event.getWindow() instanceof FormWindowSimple){
            FormWindowSimple form = (FormWindowSimple) event.getWindow();
            String element = form.getResponse().getClickedButton().getText();

            if(element == "§l§7»§r Se Téléporter"){
                FormWindowSimple teleport = new FormWindowSimple("§6Menu §l§7» §rSe Téléporter", "Séléctionnez un lieux de téléportation.");

                ElementButton ile = new ElementButton("§l§7»§r Aller sur mon île");
                teleport.addButton(ile);

                ElementButton spawn = new ElementButton("§l§7»§r Aller au Hub");
                teleport.addButton(spawn);

                ElementButton retour = new ElementButton("§cRetour");
                teleport.addButton(retour);
                player.showFormWindow(teleport);
            }
        }
    }
}
