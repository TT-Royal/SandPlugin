package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementToggle;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;

public class ClickCreateile implements Listener {
    @EventHandler
    public void NukkitClickCreateile(PlayerFormRespondedEvent event){
        Player player = event.getPlayer();
        if(event.getResponse() == null) return;
        if(event.getWindow().wasClosed()) return;
        if(event.getWindow() instanceof FormWindowSimple){
            FormWindowSimple form = (FormWindowSimple) event.getWindow();
            String element = form.getResponse().getClickedButton().getText();
            if(element == "§l§7»§r Créer une île"){
                FormWindowCustom createile = new FormWindowCustom("§6Créer une île");

                ElementInput name = new ElementInput("Nom de votre île","Entrez le nom de votre île.");
                createile.addElement(name);

                ElementInput desc = new ElementInput("Description de votre île","Entrez la description de votre île.","");
                createile.addElement(desc);

                ElementToggle open = new ElementToggle("Île public", true);
                createile.addElement(open);

                player.showFormWindow(createile);
            }
        }
    }
}
