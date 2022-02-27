package fr.ttroyal.seaplugin.events;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.mob.EntityGhast;
import cn.nukkit.entity.mob.EntityMagmaCube;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.level.Position;
import cn.nukkit.potion.Effect;

public class SendCanonVise implements Listener {
    @EventHandler
    public void NukkitSendCanonVise(PlayerFormRespondedEvent event){

        Player player = event.getPlayer();
        if(event.getWindow().wasClosed()) return;
        if(event.getWindow() instanceof FormWindowCustom){
        FormWindowCustom formWindowCustom = (FormWindowCustom) event.getWindow();
        if(formWindowCustom.getTitle() == "§6Canon §l§7» §rModifier la visée") {
            player.getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();

            player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().set("canon" + player.getLevel().getName(), formWindowCustom.getResponse().getSliderResponse(1));
            player.getServer().getPluginManager().getPlugin("SeaPlugin").saveConfig();
            player.getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();

            player.getLevel().getEntity( player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getInt("canonid" + player.getLevel().getName())).setNameTag("§l§7» §6Canon§r\n\nId du canon: §7"+ player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getInt("canonid" + player.getLevel().getName() +"\n"));
            player.getLevel().getEntity( player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getInt("canonid" + player.getLevel().getName())).setNameTagAlwaysVisible();

            Entity entity = player.getLevel().getEntity(player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().getInt("canonid" + player.getLevel().getName()));

        }
        }
    }





}
