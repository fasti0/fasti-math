package pl.fasti.math.handler;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import pl.fasti.math.MathPlugin;
import pl.fasti.math.operation.Math;
import pl.fasti.math.util.ChatUtil;

public class ChatHandler implements Listener {

    MathPlugin plugin = MathPlugin.getInstance();
    Math math = plugin.getOperation().getCurrentMath();
    int resultNotCorrect = -999;

    @EventHandler
    public void onAsyncChat(AsyncChatEvent event) {
        if (String.valueOf(event.message()).equalsIgnoreCase(String.valueOf(math.getResult()))) {
            if (math.getResult() != resultNotCorrect) win(event.getPlayer());
            else event.setCancelled(true);
        }
    }

    private void win(Player player) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), plugin.getConfiguration().commandExecute
                .replace("{PLAYER}", player.getName()));

        String message = plugin.getConfiguration().messageChatWinner;
        message = StringUtils.replace(message, "{PLAYER}", player.getName());
        message = StringUtils.replace(message, "{RESULT}", String.valueOf(math.getResult()));
        Bukkit.broadcast(ChatUtil.component(message));

        math.setResult(resultNotCorrect);
    }
}
