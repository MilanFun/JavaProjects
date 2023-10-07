package stepik.robot;

public class Robot {
    private int x = 0;
    private int y = 0;
    private Direction dir = Direction.UP;

    public Direction getDirection() {
        return this.dir;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void turnLeft() {
        if(this.dir == Direction.UP) {
            this.dir = Direction.LEFT;
        } else if(this.dir == Direction.LEFT) {
            this.dir = Direction.DOWN;
        } else if(this.dir == Direction.DOWN) {
            this.dir = Direction.RIGHT;
        } else if(this.dir == Direction.RIGHT) {
            this.dir = Direction.UP;
        }
    }

    public void turnRight() {
        if(this.dir == Direction.UP) {
            this.dir = Direction.RIGHT;
        } else if(this.dir == Direction.RIGHT) {
            this.dir = Direction.DOWN;
        } else if(this.dir == Direction.DOWN) {
            this.dir = Direction.LEFT;
        } else if(this.dir == Direction.LEFT) {
            this.dir = Direction.UP;
        }
    }

    public void stepForward() {
        if(this.dir == Direction.UP) {
            this.y += 1;
        } else if(this.dir == Direction.LEFT) {
            this.x -= 1;
        } else if(this.dir == Direction.DOWN) {
            this.y -= 1;
        } else if(this.dir == Direction.RIGHT) {
            this.x += 1;
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if(toX >= 0) {
            robot.turnRight();
            for(int i = 0; i < toX; i++) {
                robot.stepForward();
            }
            robot.turnLeft();
        } else {
            robot.turnLeft();
            for(int i = 0; i > toX; i--) {
                robot.stepForward();
            }
            robot.turnRight();
        }

        if(toY >= 0) {
            for(int i = 0; i < toY; i++) {
                robot.stepForward();
            }
        } else {
            robot.turnLeft();
            robot.turnLeft();
            for(int i = 0; i > toY; i--) {
                robot.stepForward();
            }
            robot.turnLeft();
            robot.turnLeft();
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static void main(String... args) {
        Robot robot = new Robot();
        moveRobot(robot, 0, 0);
        System.out.println(robot.getX());
        System.out.println(robot.getY());
    }
}

