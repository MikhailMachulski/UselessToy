package com.company;

public class Player extends Thread {
    Button button;

    private int wait = 3000;

    public Player(String name, Button button) {
        super(name);
        this.button = button;
    }

    @Override
    public void run() {
        while (!button.clicker) {
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(wait);
                    System.out.println(Thread.currentThread().getName() + " CLICK!");
                    button.clicker = true;
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
