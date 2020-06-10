package net.nostalase.vips.events;

import net.craftingstore.bukkit.events.DonationReceivedEvent;
import net.craftingstore.core.models.donation.Donation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Events implements Listener {

    //Handling Donation
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
                    40,
                    5
            );
            p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 100, 1);
        }
    }

}
