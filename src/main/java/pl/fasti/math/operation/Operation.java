package pl.fasti.math.operation;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import pl.fasti.math.MathPlugin;
import pl.fasti.math.configuration.Configuration;
import pl.fasti.math.operation.impl.Addition;
import pl.fasti.math.operation.impl.Division;
import pl.fasti.math.operation.impl.Multiplication;
import pl.fasti.math.operation.impl.Subtract;
import pl.fasti.math.util.ChatUtil;

import java.util.*;

public class Operation {

    private final MathPlugin plugin = MathPlugin.getInstance();
    private final Configuration config = plugin.getConfiguration();
    private final Random random = new Random();
    private final Addition addition = new Addition(1);
    private final Subtract subtract = new Subtract(2);
    private final Multiplication multiplication = new Multiplication(3);
    private final Division division = new Division(4);

    private final List<Math> maths = new ArrayList<Math>() {{
        addAll(Arrays.asList(addition, subtract, multiplication, division));
    }};

    private Math currentMath;

    public void generate() {
        findMathById(random.nextInt(maths.size() + 1))
                .ifPresent(math -> {

                    math.generateNumbers();

                        if (math.getId() == 4 && math.getX() == 0 || math.getY() == 0) {
                            generate();
                            return;
                        }

                    for (String message : config.messageChatDrawMath) {
                        message = StringUtils.replace(message, "{OPERATION}", math.getOperation());
                        Bukkit.broadcast(ChatUtil.component(message));
                        currentMath = math;
                    }
                });
    }

    private Optional<Math> findMathById(int id) {
        for (Math math : maths) {
            if (math.getId() == id) {
                return Optional.of(math);
            }
        }
        return Optional.empty();
    }

    public Math getCurrentMath() {
        return currentMath;
    }
}