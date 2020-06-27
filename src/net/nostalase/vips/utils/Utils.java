package net.nostalase.vips.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Utils {

    public static void sendMessage(Player[] players, String text) {
        for (Player p: players) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
        }
    }

    public static boolean isPickAxe(Material material) {
        ArrayList<Material> picks = new ArrayList<>();
        picks.add(Material.DIAMOND_PICKAXE);
        picks.add(Material.STONE_PICKAXE);
        picks.add(Material.GOLDEN_PICKAXE);
        picks.add(Material.WOODEN_PICKAXE);
        picks.add(Material.IRON_PICKAXE);
        return picks.contains(material);
    }

    public static void sendMessage(Player player, String text) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
    }
}
