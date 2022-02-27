package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.block.BlockID;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEntityEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.item.Item;

public class TapCanon implements Listener {
    @EventHandler
    public void NukkitTapCanon(PlayerInteractEntityEvent event){
      Player player = event.getPlayer();
      Entity entity = event.getEntity();
        player.getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();




      if(entity.getOriginalName() == "Magma Cube") {

              Item tnt = new Item(BlockID.TNT);
    if(player.getInventory().getItemInHand() == tnt ){
        event.getPlayer().getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("CanonBoulets-"+entity.getId(), player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getInt("CanonBoulets-" + entity.getId())+1);


        player.getServer().getPluginManager().getPlugin("SeaPlugin").saveConfig();
        player.getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();
        player.getLevel().getEntity( player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getInt("CanonID-"+ player.getLevelName()) ).setNameTag("   §7» §l§6Canon§r   \n \n\n§r Etat : §2Allumé§r\nBoulets :§7 "+ player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getInt("CanonBoulets-"+entity.getId()));

    }else {

        if (player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getBoolean("CanonStatus-" + entity.getId()) == true) {

        player.getServer().getPluginManager().getPlugin("SeaPlugin").saveConfig();
        player.getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();

        FormWindowSimple canon = new FormWindowSimple("§6Canon", "Séléctionnez une action");

        ElementButton start = new ElementButton("§l§7»§r Eteindre le canon");
        canon.addButton(start);

        ElementButton modif = new ElementButton("§l§7»§r Modifier la visée");
        canon.addButton(modif);

        ElementButton rotate = new ElementButton("§l§7»§r Tourner le canon");
        canon.addButton(rotate);

        ElementButton remove = new ElementButton("§l§7»§r §cRetirer le canon");
        canon.addButton(remove);

        player.showFormWindow(canon);
    } else {
        player.getServer().getPluginManager().getPlugin("SeaPlugin").saveConfig();
        player.getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();

        FormWindowSimple canon = new FormWindowSimple("§6Canon", "Séléctionnez une action");

        ElementButton start = new ElementButton("§l§7»§r Démarrer le canon");
        canon.addButton(start);

        ElementButton modif = new ElementButton("§l§7»§r Modifier la visée");
        canon.addButton(modif);

        ElementButton rotate = new ElementButton("§l§7»§r Tourner le canon");
        canon.addButton(rotate);

        ElementButton remove = new ElementButton("§l§7»§r §cRetirer le canon");
        canon.addButton(remove);

        player.showFormWindow(canon);
    }

}
      }

    }
}
