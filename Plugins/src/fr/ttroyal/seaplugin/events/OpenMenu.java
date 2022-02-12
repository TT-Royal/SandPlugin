package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.*;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;

public class OpenMenu implements Listener {

    @EventHandler
    public void NukkitOpenMenu(PlayerInteractEvent event){
       Player player = event.getPlayer();
        if(event.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_AIR) {

            if (player.getInventory().getItemInHand().getId() == -200) {
player.getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();

                FormWindowSimple menu = new FormWindowSimple("§6Menu", "Séléctionnez une catégorie");

                ElementButton teleport = new ElementButton("§l§7»§r Se Téléporter");
                menu.addButton(teleport);


                if(player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().exists("name " + player.getName())){
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
