package me.damt.effects;

import me.damt.effects.commands.FireCommand;
import me.damt.effects.commands.InvisCommand;
import me.damt.effects.commands.SpeedCommand;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    public void onEnable() {
        registercommands();

        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }
    private void registercommands() {
        getCommand("speed").setExecutor(new SpeedCommand(this));
        getCommand("invis").setExecutor(new InvisCommand(this));
        getCommand("fire").setExecutor(new FireCommand(this));
    }
}
