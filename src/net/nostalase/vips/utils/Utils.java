package net.nostalase.vips.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {

    public static void sendMessage(Player[] players, String text) {
        for (Player p: players) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
        }
    }

    public static void sendMessage(Player player, String text) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
    }
}
