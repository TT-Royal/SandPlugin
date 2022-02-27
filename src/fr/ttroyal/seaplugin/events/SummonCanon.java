package fr.ttroyal.seaplugin.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.CreatureSpawnEvent;
import cn.nukkit.event.entity.EntityEvent;
import cn.nukkit.event.entity.EntitySpawnEvent;


public class SummonCanon implements Listener {
    @EventHandler
    public void NukkitSummonCanon(EntitySpawnEvent event){


        if(event.getEntity().getOriginalName() == "Magma Cube"){
            event.getEntity().getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("CanonID-"+event.getEntity().getLevelName(), event.getEntity().getId());
            event.getEntity().getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("CanonStatus-"+event.getEntity().getId(), false);
            event.getEntity().getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("CanonBoulets-"+event.getEntity().getId(), 0);
            event.getEntity().getServer().getPluginManager().getPlugin("SeaPlugin").saveConfig();
            event.getEntity().setNameTag("   §7» §l§6Canon§r ("+event.getEntity().getId()+")  \n \n\n§r Etat : §cEteint§r\nBoulets :§7 0");
                event.getEntity().setNameTagAlwaysVisible();

           event.getEntity().getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();
        }

    }
}
