package com.company;

public class Box extends Thread {
    Button button;

    public Box(String name, Button button) {
        super(name);
        this.button = button;
    }

    @Override
    public void run() {
        while (true) {
            if (button.clicker) {
                System.out.println(Thread.currentThread().getName() + " CLICK!");
                button.clicker = false;
            }
            if (isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " is finished");
                break;
            }
        }
    }
}
