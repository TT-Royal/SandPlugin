package fr.ttroyal.seaplugin.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementToggle;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;

public class menu extends Command {

    public menu() {
        super("menu");
        this.setDescription("§6Ouvre le menu");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§6Vous devez être un joueur pour executer la commande!");
            return false;
        }
        Player player = (Player) sender;

        player.getServer().getPluginManager().getPlugin("SeaPlugin").reloadConfig();

        FormWindowSimple menu = new FormWindowSimple("§6Menu", "Séléctionnez une catégorie");

        ElementButton teleport = new ElementButton("§l§7»§r Se Téléporter");
        menu.addButton(teleport);


        if (player.getServer().getPluginManager().getPlugin("SeaPlugin").getConfig().exists("name " + player.getName())) {
            ElementButton gerer = new ElementButton("§l§7»§r Mon île");
            menu.addButton(gerer);
        } else {
            ElementButton create = new ElementButton("§l§7»§r Créer une île");
            menu.addButton(create);
        }
        player.showFormWindow(menu);

        return false;
    }
}
