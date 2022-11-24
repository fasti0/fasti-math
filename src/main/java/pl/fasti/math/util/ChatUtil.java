package pl.fasti.math.util;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;

public final class ChatUtil {

    private ChatUtil() {}

    public static String colored(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static Component component(String text) {
        return Component.text(colored(text));
    }
}
