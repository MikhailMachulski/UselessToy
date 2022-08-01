package com.company;

public class Main {
    static volatile boolean clicker = false;

    public static void main(String[] args) throws InterruptedException{
        Player player = new Player("Player");
        Box box = new Box("Box");

        player.start();
        box.start();

        player.join();

        box.interrupt();

    }

    static class Player extends Thread {
        private int wait = 3000;

        public Player(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!clicker) {
                try {
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(wait);
                        System.out.println(Thread.currentThread().getName() + " CLICK!");
                        clicker = true;
                    } break;
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                if (isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + " is finished");
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
                if (clicker) {
                        System.out.println(Thread.currentThread().getName() + " CLICK!");
                        clicker = false;
                }
                if (isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + " is finished");
                    break;
                }
            }
        }
    }
}


