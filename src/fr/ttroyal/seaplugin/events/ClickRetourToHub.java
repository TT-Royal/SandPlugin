package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;

public class ClickRetourToHub implements Listener {
    @EventHandler
    public void NukkitClickRetourToHub(PlayerFormRespondedEvent event){
        Player player = event.getPlayer();
        if(event.getResponse() == null) return;
        if(event.getWindow().wasClosed()) return;
        if(event.getWindow() instanceof FormWindowSimple){
            FormWindowSimple form = (FormWindowSimple) event.getWindow();
            String element = form.getResponse().getClickedButton().getText();
            if(element == "§cRetour"){
                FormWindowSimple menu =new FormWindowSimple("§6Menu", "Séléctionnez une catégorie");

                ElementButton teleport = new ElementButton("§l§7»§r Se Téléporter");
                menu.addButton(teleport);
                player.getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();

                if(player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getBoolean("public " + player.getName())){
                    ElementButton gerer = new ElementButton("§l§7»§r Mon île");
                    menu.addButton(gerer);
                }else{
                    ElementButton create = new ElementButton("§l§7»§r Créer une île");
                    menu.addButton(create);
                }


                player.showFormWindow(menu);
            }
        }
    }
}
