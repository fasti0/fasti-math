package pl.fasti.math.command;

import org.bukkit.entity.Player;
import pl.fasti.math.MathPlugin;
import pl.fasti.math.configuration.Configuration;
import pl.fasti.math.util.ChatUtil;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;

@Command("math")
@CommandPermission("fasti.math")
public class MathCommand {

    private final MathPlugin plugin = MathPlugin.getInstance();
    private final Configuration config = plugin.getConfiguration();

    @Default
    public void math(Player sender) {
        sender.sendMessage(ChatUtil.colored(config.messageCommandUsage));
    }

    @Subcommand("draw")
    public void draw(Player sender) {
        plugin.getOperation().generate();
        sender.sendMessage(ChatUtil.colored(config.messageCommandDraw));
    }
}
