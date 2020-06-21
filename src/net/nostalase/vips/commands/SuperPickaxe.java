package net.nostalase.vips.commands;

import net.nostalase.vips.Main;
import net.nostalase.vips.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SuperPickaxe implements CommandExecutor {

    public static ArrayList<UUID> super_pickaxe = new ArrayList<>();
    private final Main plugin;
    public SuperPickaxe (Main plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Você precisa ser um player para executar esse comando");
            return false;
        }

        Player player = (Player) sender;

        if (super_pickaxe.contains(player.getUniqueId())) {
            super_pickaxe.remove(player.getUniqueId());
            player.removeMetadata("superpickaxe", this.plugin);
            Utils.sendMessage(player, "&5&lVIP&7 - Você &c&ldesativou&7 a &6Super Picareta");
        } else {
            super_pickaxe.add(player.getUniqueId());
            player.setMetadata("superpickaxe", new FixedMetadataValue(this.plugin, true));
            Utils.sendMessage(player, "&5&lVIP&7 - Você &a&lativou&7 a &6Super Picareta");
        }

        return false;
    }
}
