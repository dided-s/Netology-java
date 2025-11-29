package gym_inheritance;

public class Main {

    public static void main(String[] args) {
        SmartRobot robot = new SmartRobot();
        robot.moveDown();
        robot.moveDown();
        robot.moveLeft();
        robot.moveUp();
        robot.moveDown();
        robot.moveLeft();
        robot.moveLeft();

        System.out.println("Координаты робота: " + robot.getX() + ":" + robot.getY());
        System.out.println("Количество шагов: " + robot.getStepsCount());
    }
}

class Robot {
    private int x;
    private int y;

    public void moveRight() {
        x++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveUp() {
        y--;
    }

    public void moveDown() {
        y++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class SmartRobot extends Robot {

    private int stepsCount;

    public SmartRobot() {
        stepsCount = 0;
    }

    public int getStepsCount() {
        return stepsCount;
    }

    @Override
    public void moveDown() {
        stepsCount++;
        super.moveDown();
    }

    @Override
    public void moveUp() {
        stepsCount++;
        super.moveUp();
    }

    public void moveLeft() {
        stepsCount++;
        super.moveLeft();
    }

    @Override
    public void moveRight() {
        stepsCount++;
        super.moveRight();
    }
}