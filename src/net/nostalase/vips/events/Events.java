package net.nostalase.vips.events;

import net.craftingstore.bukkit.events.DonationReceivedEvent;
import net.craftingstore.core.models.donation.Donation;
import net.nostalase.vips.commands.SuperPickaxe;
import net.nostalase.vips.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class Events implements Listener {

    @EventHandler
    public void onBlock(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)&&event.getItem()!=null&&Utils.isPickAxe(event.getItem().getType())&& SuperPickaxe.super_pickaxe.contains(event.getPlayer().getUniqueId())) {
            Damageable dmg = (Damageable) event.getItem().getItemMeta();
            if(event.getClickedBlock().getType().getHardness()<0) {return;}
            if (!(dmg.getDamage()>=event.getItem().getType().getMaxDurability())){

            dmg.setDamage(dmg.getDamage()+10);
            event.getItem().setItemMeta((ItemMeta)dmg);
            event.getClickedBlock().breakNaturally(event.getItem());}
        }
    }

}
