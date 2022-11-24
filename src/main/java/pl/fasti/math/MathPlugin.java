package pl.fasti.math;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import org.bukkit.plugin.java.JavaPlugin;
import pl.fasti.math.command.MathCommand;
import pl.fasti.math.configuration.Configuration;
import pl.fasti.math.handler.ChatHandler;
import pl.fasti.math.operation.Operation;
import pl.fasti.math.task.AutomaticDrawTask;
import revxrsal.commands.bukkit.BukkitCommandHandler;
import java.io.File;

public class MathPlugin extends JavaPlugin {

    private static MathPlugin instance;
    private Configuration configuration;
    private Operation operation;

    @Override
    public void onEnable() {
        instance = this;
        loadConfiguration();
        operation = new Operation();
        BukkitCommandHandler.create(this).register(new MathCommand());
        loadAutomaticTask();
        getServer().getPluginManager().registerEvents(new ChatHandler(), this);
    }

    private void loadConfiguration() {
        configuration = ConfigManager.create(Configuration.class, (it) -> {
            it.withConfigurer(new YamlBukkitConfigurer());
            it.withBindFile(new File(getDataFolder(), "configuration.yml"));
            it.saveDefaults();
            it.load(true);
        });
    }

    private void loadAutomaticTask() {
        if (configuration.automaticTaskDraw) {
            getServer().getScheduler().runTaskTimer(this, new AutomaticDrawTask(), 20L, configuration.seconds * 20L);
        }
    }

    public static MathPlugin getInstance() {
        return instance;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public Operation getOperation() {
        return operation;
    }
}