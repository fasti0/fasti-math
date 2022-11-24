package pl.fasti.math.operation.impl;

import pl.fasti.math.operation.Math;

public class Division implements Math {

    private int id, x, y, result;
    private String operation;

    public Division(int id) {
        this.id = id;
    }

    @Override
    public void generateNumbers() {
        int x = random.nextInt(config.minDivision);
        int y = random.nextInt(config.maxDivision);
        result = x / y;
        operation = x + " : " + y;
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