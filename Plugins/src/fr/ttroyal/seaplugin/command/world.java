package fr.ttroyal.seaplugin.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import org.jline.reader.ParsedLine;

public class world extends Command {

    public world() {
        super("world");
        this.setDescription("§6Se teleporter à un monde");

    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§6Vous devez être un joueur pour executer la commande!");
            return false;
        }

        Player player = (Player) sender;
        player.teleport(player.getServer().getLevelByName(s).getSpawnLocation().getLocation());
        player.sendTip("§6Vous avez été téleporté au monde " + s);



        return false;
    }

}
