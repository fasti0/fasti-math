package pl.fasti.math.operation.impl;

import pl.fasti.math.operation.Math;

public class Multiplication implements Math {

    private int id, x, y, result;
    private String operation;

    public Multiplication(int id) {
        this.id = id;
    }

    @Override
    public void generateNumbers() {
        x = random.nextInt(config.minMultiplication);
        y = random.nextInt(config.maxMultiplication);
        result = x * y;
        operation = x + " * " + y;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public String getOperation() {
        return operation;
    }

    @Override
    public void setResult(int result) {
        this.result = result;
    }
}
