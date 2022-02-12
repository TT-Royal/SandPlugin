package fr.ttroyal.seaplugin.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import cn.nukkit.level.Position;

public class spawn extends Command {

    public spawn() {
        super("spawn");
        this.setDescription("§6Aller au Hub.");
        this.setAliases(new String[]{"lobby", "hub"});
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args){
        if(!(sender instanceof Player)) {
            sender.sendMessage("§6Vous devez être un joueur pour executer la commande!");
            return false;
        }

        Player player = (Player) sender;
        Level Hub = player.getServer().getLevelByName("Hub");
        Position pos = new Position(100,100,100, Hub);
        player.sendTip("§6Vous êtes maintenant au Hub!");
        player.teleport(pos);



        return false;
    }
}
