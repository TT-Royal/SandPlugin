package fr.ttroyal.seaplugin.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.ElementToggle;
import cn.nukkit.form.window.FormWindowCustom;


public class create extends Command {

    public create() {
        super("create");
        this.setDescription("§6Créer votre île");
        this.setAliases(new String[]{"creer"});
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§6Vous devez être un joueur pour executer la commande!");
            return false;
        }

    Player player = (Player) sender;

        FormWindowCustom createile = new FormWindowCustom("§6Créer une île");

        ElementInput name = new ElementInput("Nom de votre île","Entrez le nom de votre île.");
        createile.addElement(name);

        ElementInput desc = new ElementInput("Description de votre île","Entrez la description de votre île.");
        createile.addElement(desc);

        ElementToggle open = new ElementToggle("Île public", true);
        createile.addElement(open);

        player.showFormWindow(createile);


        return false;
    }
}
