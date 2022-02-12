package fr.ttroyal.seaplugin.loaders;

import cn.nukkit.plugin.PluginManager;
import fr.ttroyal.seaplugin.NukkitMain;
import fr.ttroyal.seaplugin.events.*;

public class EventLoader {
    public static void load(NukkitMain instance) {
        PluginManager pm = instance.getServer().getPluginManager();

        pm.registerEvents(new PlayerMove(), instance );
        pm.registerEvents(new PlayerJoin(), instance);
        pm.registerEvents(new PlayerLeave(), instance);
        pm.registerEvents(new OpenMenu(), instance);
        pm.registerEvents(new OnChat(), instance);
        pm.registerEvents(new PlayerDestroyBlock(), instance);
        pm.registerEvents(new PlayerPlaceBlock(), instance);
        pm.registerEvents(new PlayerDrop(), instance);
        pm.registerEvents(new PlayerChangeItemInventory(), instance);
        pm.registerEvents(new PlayerDeath(), instance);

        //Create Île
        pm.registerEvents(new SendCreateForm(), instance);
        //Gérer l'île
        pm.registerEvents(new SendGererForm(), instance);

        //Menu (Form, OpenMenu.java)
        pm.registerEvents(new ClickTeleport(), instance);
        pm.registerEvents(new ClickCreateile(), instance);
        pm.registerEvents(new ClickMonIle(), instance);

            //Teleport
        pm.registerEvents(new ClickIle(), instance);
        pm.registerEvents(new ClickSpawn(), instance);
        pm.registerEvents(new ClickRetourToHub(), instance);

            //MonÎle
        pm.registerEvents(new ClickGererIle(), instance);
    }
}
