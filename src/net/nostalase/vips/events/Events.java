package net.nostalase.vips.events;

import net.craftingstore.bukkit.events.DonationReceivedEvent;
import net.craftingstore.core.models.donation.Donation;
import net.nostalase.vips.commands.SuperPickaxe;
import net.nostalase.vips.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class Events implements Listener {

    @EventHandler
    public void onDonation(DonationReceivedEvent event) {
        Donation donation = event.getDonation();
        String nickname = donation.getPlayer().getUsername();
        String pack = donation.getPackage().getName();
        for (Player p: Bukkit.getOnlinePlayers()) {
            p.sendTitle(
                    ChatColor.translateAlternateColorCodes('&', "&6&lVIP"),
                    ChatColor.translateAlternateColorCodes('&', "&6"+nickname+" se tornou &lVIP&6!"),
                    5,
                    100,
                    5
            );
            p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 100, 1);
        }
    }
    @EventHandler
    public void onBlock(PlayerInteractEvent event) {
        if (event.getItem()!=null&&Utils.isPickAxe(event.getItem().getType())&& SuperPickaxe.super_pickaxe.contains(event.getPlayer().getUniqueId())) {
            Damageable dmg = (Damageable) event.getItem().getItemMeta();
            dmg.setDamage(dmg.getDamage()-1);
            event.getItem().setItemMeta((ItemMeta)dmg);
            event.getClickedBlock().breakNaturally(event.getItem());
        }
    }

}
