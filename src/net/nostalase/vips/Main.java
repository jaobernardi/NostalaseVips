package net.nostalase.vips;

import net.nostalase.vips.events.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public Logger logger = this.getLogger();

    @Override
    public void onLoad() {
        logger.info("Carregado.");
    }

    @Override
    public void onEnable() {
        logger.info("Ativado.");
        PluginManager manager = getServer().getPluginManager();

        manager.registerEvents(new Events(), this);
    }
}
