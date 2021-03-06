package me.damt.effects.commands;

import me.damt.effects.Effect;
import me.damt.effects.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedCommand implements CommandExecutor {


    private Effect main = Effect.getInstance();

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;

        if (commandSender instanceof Player) {
            if (player.hasPermission("effects.speed")) {
                if (main.getConfig().getBoolean("Speed.Enabled") == true) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                    player.sendMessage(Util.chat(main.getConfig().getString("Speed.Message")));
                }
            } else {
                player.sendMessage(Util.chat("&cNo Permission"));
            }
        } else {
            commandSender.sendMessage(Util.chat("&cThis is a player only command!"));
        }

        return false;
    }
}
