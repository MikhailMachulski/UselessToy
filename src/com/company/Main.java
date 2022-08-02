package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        Button button = new Button();

        Player player = new Player("Player", button);
        Box box = new Box("Box", button);

        player.start();
        box.start();

        player.join();

        box.interrupt();

    }
}


