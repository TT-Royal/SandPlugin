package fr.ttroyal.seaplugin;

import cn.nukkit.plugin.PluginBase;
import fr.ttroyal.seaplugin.command.spawn;
import fr.ttroyal.seaplugin.command.create;
import fr.ttroyal.seaplugin.command.world;
import fr.ttroyal.seaplugin.loaders.EventLoader;
import fr.ttroyal.seaplugin.utils.Utils;

public class NukkitMain extends PluginBase {

    @Override
    public void onEnable() {


        this.getLogger().info("§aLe plugin a bien été chargé!");
        EventLoader.load(Utils.instance);
        registerCommands();


    }

    @Override
    public void onDisable() {
        this.getLogger().info("§eLe plugin a bien été désactivé!");
    }

    @Override
    public void onLoad() {
        Utils.instance = this;
    }

    public void registerCommands() {
        this.getServer().getCommandMap().register("spawn", new spawn());
        this.getServer().getCommandMap().register("create", new create());
        this.getServer().getCommandMap().register("world", new world());
    }

}
