package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;

public class ClickMonIle implements Listener {
    @EventHandler
    public void NukkitClickMonIle(PlayerFormRespondedEvent event){
        Player player = event.getPlayer();
        if(event.getResponse() == null) return;
        if(event.getWindow().wasClosed()) return;
        if(event.getWindow() instanceof FormWindowSimple){
            FormWindowSimple form = (FormWindowSimple) event.getWindow();
            String element = form.getResponse().getClickedButton().getText();
            if(element == "§l§7»§r Mon île"){
                FormWindowSimple ile = new FormWindowSimple("§6Mon île","Séléctionnez une catégorie");

                ElementButton info = new ElementButton("§l§7»§r Informations");
                ile.addButton(info);

                ElementButton member = new ElementButton("§l§7»§r Les Membres");
                ile.addButton(member);

                ElementButton treasor = new ElementButton("§l§7»§r Le Trésor");
                ile.addButton(treasor);

                ElementButton gerer = new ElementButton("§l§7»§r Gérer l'île");
                ile.addButton(gerer);

                ElementButton retour = new ElementButton("§cRetour");
                ile.addButton(retour);

                player.showFormWindow(ile);


            }
        }
    }
}
