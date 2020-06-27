package net.nostalase.vips;

import net.nostalase.vips.commands.SuperPickaxe;
import net.nostalase.vips.commands.Vip;
import net.nostalase.vips.events.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public Logger logger = this.getLogger();
    public static Main INSTANCE;

    @Override
    public void onLoad() {
        logger.info("Carregado.");
    }

    @Override
    public void onEnable() {
        logger.info("Ativado.");
        PluginManager manager = getServer().getPluginManager();

        this.getCommand("vip").setExecutor(new Vip());
        this.getCommand("superpick").setExecutor(new SuperPickaxe(this));


        manager.registerEvents(new Events(), this);
    }
}
