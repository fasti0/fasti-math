package pl.fasti.math.task;

import pl.fasti.math.MathPlugin;

public class AutomaticDrawTask implements Runnable {

    private final MathPlugin plugin = MathPlugin.getInstance();

    @Override
    public void run() {
        plugin.getOperation().generate();
    }
}
