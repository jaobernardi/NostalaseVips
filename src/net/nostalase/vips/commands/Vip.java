package net.nostalase.vips.commands;

import net.nostalase.vips.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vip implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            //Bla bla bla n é pra player fazer merda aqui
            Utils.sendMessage((Player) sender, "&cEste comando só pode ser executado por &lUsuários Certificados.");
            return false;
        }

        if (args.length != 2) {
            for (String x: args) {
                System.out.println(x);
            }
            sender.sendMessage("Uso incorreto.");
            return false;
        }

        String nickname;
        Player player = Bukkit.getPlayer(args[1]);

        switch (args[0].toLowerCase()) {
            case "expire":
                if (player != null && player.isOnline()) {
                    player.sendMessage("&cSeu vip expirou");
                    return false;
                } else {
                    //stuff
                    return false;
                }
            case "set":
                nickname = args[1];
                for (Player p: Bukkit.getOnlinePlayers()) {
                    p.sendTitle(
                            ChatColor.translateAlternateColorCodes('&', "&6&lVIP"),
                            ChatColor.translateAlternateColorCodes('&', "&6"+nickname+" renovou seu &lVIP&6!"),
                            5,
                            100,
                            5
                    );
                    p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 100, 1);
                }
            case "renew":
                nickname = args[1];
                for (Player p: Bukkit.getOnlinePlayers()) {
                    p.sendTitle(
                            ChatColor.translateAlternateColorCodes('&', "&6&lVIP"),
                            ChatColor.translateAlternateColorCodes('&', "&6"+nickname+" renovou seu &lVIP&6!"),
                            5,
                            100,
                            5
                    );
                    p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 100, 1);
                }
        }

        return false;
    }
}
