package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementToggle;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;

public class ClickGererIle implements Listener {
    @EventHandler
    public void NukkitClickGererIle(PlayerFormRespondedEvent event){
        Player player = event.getPlayer();

        if(event.getResponse() == null) return;
        if(event.getWindow().wasClosed()) return;
        if(event.getWindow() instanceof FormWindowSimple){
            FormWindowSimple form = (FormWindowSimple) event.getWindow();
            String element = form.getResponse().getClickedButton().getText();

            if(element == "§l§7»§r Gérer l'île"){
                FormWindowCustom gerer = new FormWindowCustom("§6Gérer l'île");

                ElementInput name = new ElementInput("Nom de votre île","Entrez le nom de votre île", player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getString("name "+ player.getName()));
                gerer.addElement(name);

                ElementInput desc = new ElementInput("Description de votre île", "Entrez la description de votre île.", player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getString("desc "+ player.getName()));
                gerer.addElement(desc);

                ElementToggle publi = new ElementToggle("Ile public",player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getBoolean("public "+ player.getName()));
                gerer.addElement(publi);

                player.showFormWindow(gerer);
            }
        }
    }
}
