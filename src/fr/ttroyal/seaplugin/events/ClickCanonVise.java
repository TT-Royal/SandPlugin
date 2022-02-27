package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.form.element.ElementSlider;
import cn.nukkit.form.element.ElementToggle;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;

public class ClickCanonVise implements Listener {
    @EventHandler
    public void NukkitClickCanonVise(PlayerFormRespondedEvent event){
        Player player = event.getPlayer();



        if(event.getResponse() == null) return;
        if(event.getWindow().wasClosed()) return;
        if(event.getWindow() instanceof FormWindowSimple){
            FormWindowSimple form = (FormWindowSimple) event.getWindow();
            String element = form.getResponse().getClickedButton().getText();

            if(element == "§l§7»§r Modifier la visée"){
                FormWindowCustom modif = new FormWindowCustom("§6Canon §l§7» §rModifier la visée");

                ElementLabel desc = new ElementLabel("Ce paramètre vous permet de modifier l'orientation du canon. \n\nQuand l'orientation est entre 0 et 4, le canon tire vers la gauche. Quand elle est entre 6 et 10, le canon tire vers la droite. Et si elle est à 5, le canon tire tout droit.");
                modif.addElement(desc);

                if(player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().exists("canon" + player.getLevel().getName())) {
                    ElementSlider orientation = new ElementSlider("Orientation du canon", 0, 10, 1, player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getInt("canon" + player.getLevel().getName()));
                    modif.addElement(orientation);
                }else{
                    ElementSlider orientation = new ElementSlider("Orientation du canon", 0, 10, 1, 5);
                    modif.addElement(orientation);
                }
                player.showFormWindow(modif);
            }
        }



    }
}
