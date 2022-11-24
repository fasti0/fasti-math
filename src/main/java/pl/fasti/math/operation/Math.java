package pl.fasti.math.operation;

import pl.fasti.math.MathPlugin;
import pl.fasti.math.configuration.Configuration;
import java.util.Random;

public interface Math {

    Configuration config = MathPlugin.getInstance().getConfiguration();

    Random random = new Random();

    void generateNumbers();

    int getId();

    int getX();

    int getY();

    int getResult();

    String getOperation();

    void setResult(int result);
}
