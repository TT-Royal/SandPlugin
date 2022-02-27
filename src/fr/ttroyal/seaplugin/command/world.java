package fr.ttroyal.seaplugin.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.potion.Effect;
import org.jline.reader.ParsedLine;

public class world extends Command {

    public world() {
        super("worldile");
        this.setDescription("§6Se teleporter à un monde");

    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§6Vous devez être un joueur pour executer la commande!");
            return false;
        }
        if(sender.isOp() == true) {

            Player player = (Player) sender;
            player.teleport(player.getServer().getLevelByName("ile").getSpawnLocation().getLocation());
            player.sendTitle("§6Téloportation", "à ile", 0, 40, 0);
            player.addEffect(Effect.getEffectByName("blindness").setDuration(50).setVisible(false));
        }else{
            ((Player) sender).sendTip("§cVous ne pouvez pas aller sur ce monde!");
        }

        return false;
    }

}
