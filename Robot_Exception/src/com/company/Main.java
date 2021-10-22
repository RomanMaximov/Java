package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);
        @Override
        void close();
    }

    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    public static class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int count = 0;
        //RobotConnection rc = null;
        try (RobotConnection rc = robotConnectionManager.getConnection()){
            while (count < 3) {
                    rc.moveRobotTo(toX, toY);
                    break;
                }
                //} catch (RobotConnectionException rce) {
            }
            ++count;
        //}
        if(count == 3) {
            throw new RobotConnectionException("Connection failed");
        }
    }
}

