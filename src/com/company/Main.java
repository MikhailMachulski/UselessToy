package com.company;

public class Main {
    static volatile boolean clicker = false;

    public static void main(String[] args) {
        Runnable player = new Player("Player")::start;
        Runnable box = new Box("Box")::start;

        player.run();
        box.run();

    }

    static class Player extends Thread {
        public Player(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                if (clicker = false) {
                    try {
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName() + " CLICK!");
                        clicker = true;
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
    }

    static class Box extends Thread {
        public Box(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                if (clicker = true) {
                    System.out.println(Thread.currentThread().getName() + " CLICK!");
                    clicker = false;
                }
            }
        }
    }
}


