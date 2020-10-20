package me.damt.effects.commands;

import me.damt.effects.Main;
import me.damt.effects.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FireCommand implements CommandExecutor {

    private Main main;
    public FireCommand(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;

        if (commandSender instanceof Player && player.hasPermission("effects.fire")) {
            if (main.getConfig().getBoolean("Fire.Enabled") == true) {
                player.sendMessage(Util.chat(main.getConfig().getString("Fire.Message")));
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
            }
        } else {
            player.sendMessage(Util.chat("&cNo Permission"));
        }

        return false;
    }
}
