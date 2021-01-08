package me.damt.effects;

import lombok.Getter;
import me.damt.effects.commands.FireCommand;
import me.damt.effects.commands.InvisCommand;
import me.damt.effects.commands.SpeedCommand;
import org.bukkit.plugin.java.JavaPlugin;


public class Effect extends JavaPlugin {

    @Getter private static Effect instance;

    public void onEnable() {
        registercommands();
        instance = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }
    private void registercommands() {
        getCommand("speed").setExecutor(new SpeedCommand());
        getCommand("invis").setExecutor(new InvisCommand());
        getCommand("fire").setExecutor(new FireCommand());
    }
}
