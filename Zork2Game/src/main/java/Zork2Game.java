import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class Zork2Game {
    private Room currentRoom;
    private ArrayList<Room> rooms;
    private ArrayList<Item> playerInventory;
    private Room winningRoom;
    private boolean gameWon = false;



    private boolean chestUnlocked;


    public Zork2Game() {
        System.out.println("*--------------------------------------------------------------------------------*");
        System.out.println("|                               Herzlich Wilkommen...                            |");
        System.out.println("*--------------------------------------------------------------------------------*");
        playerInventory = new ArrayList<>();
        chestUnlocked = false;


        // Create rooms
        rooms = new ArrayList<>();
        Room bathroom = new Room("Badezimmer");
        Room bedroom1 = new Room("Zimmer1");
        Room livingRoom = new Room("Wohnzimmer");
        Room bedroom2 = new Room("Zimmer2");
        Room bedroom3 = new Room("Zimmer3");
        Room bedroom4 = new Room("Zimmer4");
        Room bedroom5 = new Room("Zimmer5");
        Room bedroom6 = new Room("Zimmer6");

        // Add exits
        bathroom.addExit("Osten", bedroom1);
        bedroom1.addExit("Westen", bathroom);
        bedroom1.addExit("Süden", livingRoom);
        bedroom1.addExit("Osten", bedroom2);
        bedroom2.addExit("Westen", bedroom1);
        livingRoom.addExit("Norden", bedroom1);
        livingRoom.addExit("Westen", bedroom4);
        livingRoom.addExit("Süden", bedroom3);
        livingRoom.addExit("Osten", bedroom5);
        bedroom3.addExit("Norden", livingRoom);
        bedroom4.addExit("Osten", livingRoom);
        bedroom5.addExit("Westen", livingRoom);
        bedroom5.addExit("Osten", bedroom6);
        bedroom6.addExit("Westen", bedroom5);

        // Connect rooms


        // Set starting room to the bathroom (without items)
        currentRoom = bathroom;

        // Set the winning condition
        winningRoom = bedroom6;

        // Add items to rooms
        bathroom.addItem(new Item("flashlight", 1));
        bedroom2.addItem(new Item("key", 1));
        bedroom4.addItem(new Item("knife", 1));
        bedroom3.addItem(new Item("gun", 1));
        bedroom5.addItem(new Item("phone", 1));
        bedroom6.addItem(new Item("chest", 1));

        // Initialize chest status
        chestUnlocked = false;
    }

    public void pickUpItem(String itemName) {
        Item itemToRemove = null;
        for (Item item : currentRoom.getItems()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            currentRoom.removeItem(itemToRemove);
            playerInventory.add(itemToRemove);
            System.out.println("Du hast " + itemToRemove.getName() + " aufgenommen.");
        } else {
            System.out.println("Diesen Gegenstand gibt es hier nicht.");
        }
    }

    public void dropItem(String itemName) {
        Item itemToRemove = null;
        for (Item item : playerInventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            playerInventory.remove(itemToRemove);
            currentRoom.addItem(itemToRemove);
            System.out.println("Du hast " + itemToRemove.getName() + " abgelegt.");
        } else {
            System.out.println("Du hast diesen Gegenstand nicht.");
        }
    }

    public void printInventory() {
        System.out.println("*------------------*");
        System.out.println("|  Dein Inventar:  |");
        System.out.println("*------------------*");
        for (Item item : playerInventory) {
            System.out.println("*------------------------------------------*");
            System.out.println("|["+ item.getName() + "]"+ " [Gewicht: " + item.getWeight() + "]" + "                                 |");
            System.out.println("*------------------------------------------*");
        }
    }

    public void printRoomInfo() {
        System.out.println("*---------------------------------------------------*");
        System.out.println("|  Du befindest dich in " + currentRoom.getName() +  "                  |");
        System.out.println("*---------------------------------------------------*");
        ArrayList<Item> roomItems = currentRoom.getItems();
        if (!roomItems.isEmpty()) {
            System.out.println("*---------------------------------------------------------------*");
            System.out.println("|  In diesem Raum gibt es folgende Gegenstände:                 |");
            for (Item item : roomItems) {
                System.out.println("|  " + item.getName() + " (Gewicht: " + item.getWeight() + ")                                      |");
                System.out.println("*---------------------------------------------------------------*");
            }
        }

    }

    public void openChest() {
        boolean hasKey = false;
        boolean hasChest = false;
        for (Item item : playerInventory) {
            if (item.getName().equals("key")) {
                hasKey = true;
            }
            if (item.getName().equals("chest")) {
                hasChest = true;
            }
        }

        if (hasChest && hasKey) {
            gameWon = true;
            System.out.println("\u001B[34m" +  "    ____           _         _       _   _             _ \n" +
                    "  / ____|         | |       | |     | | (_)           | |\n" +
                    " | |  __ _ __ __ _| |_ _   _| | __ _| |_ _  ___  _ __ | |\n" +
                    " | | |_ | '__/ _` | __| | | | |/ _` | __| |/ _ \\| '_ \\| |\n" +
                    " | |__| | | | (_| | |_| |_| | | (_| | |_| | (_) | | | |_|\n" +
                    "  \\_____|_|  \\__,_|\\__|\\__,_|_|\\__,_|\\__|_|\\___/|_| |_(_)\n" +
                    "                                                         \n" +
                    "                                                         ");
            System.out.println("\u001B[32m" + "Du hast die Schatzkiste geöffnet und somit das Spiel gewonnen!" + "\u001B[0m");
        } else {
            if (!hasKey) {
                System.out.println("Du benötigst den Schlüssel, um die Schatzkiste zu öffnen!");
            }
            if (!hasChest) {
                System.out.println("Du brauchst die Schatzkiste, um sie zu öffnen!");
            }
        }
    }





    public void movePlayer(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("Du bewegst dich nach " + direction + ".");
            if (currentRoom == winningRoom && chestUnlocked) {
                System.out.println("Glückwunsch! Du hast das Spiel gewonnen!");
            }
        } else {
            System.out.println("Kein Ausgang in diese Richtung.");
        }
    }


    public void printMap() {
        System.out.println("*--------------------------------------------------------------------------------*");
        System.out.println("|                                   Karte                                        |");
        System.out.println("*--------------------------------------------------------------------------------*");
        System.out.println("|                                                                                |");
        System.out.println("|      |‾‾‾‾‾‾‾‾‾‾‾‾|         |‾‾‾‾‾‾‾‾‾|      |‾‾‾‾‾‾‾‾‾|                       |");
        System.out.println("|      | Badezimmer | ======= | Zimmer1 | ==== | Zimmer2 |                       |");
        System.out.println("|      |____________|         |_________|      |_________|                       |");
        System.out.println("|                                 | |                                            |");
        System.out.println("|                                 | |                                            |");
        System.out.println("|            |‾‾‾‾‾‾‾‾‾|     |‾‾‾‾‾‾‾‾‾‾‾‾|     |‾‾‾‾‾‾‾‾‾|     |‾‾‾‾‾‾‾‾‾|      |");
        System.out.println("|            | Zimmer4 | === | Wohnzimmer | === | Zimmer5 | === | Zimmer6 |      |");
        System.out.println("|            |_________|     |____________|     |_________|     |_________|      |");
        System.out.println("|                                 | |                                            |");
        System.out.println("|                                 | |                                            |");
        System.out.println("|                             |‾‾‾‾‾‾‾‾‾|                                        |");
        System.out.println("|                             | Zimmer3 |                                        |");
        System.out.println("|                             |_________|                                        |");
        System.out.println("|                                                                                |");
        System.out.println("*--------------------------------------------------------------------------------*");
    }

    public boolean isGameWon() {
        return gameWon;
    }



    public static void main(String[] args) {
        Zork2Game game = new Zork2Game();
        Scanner scanner = new Scanner(System.in);

        while (!game.isGameWon()) {
            game.printRoomInfo();
            game.printInventory();
            System.out.println("Befehle: 'pickup [Gegenstand]', 'drop [Gegenstand]', 'exit', 'map', 'openChest'");
            System.out.println("Bewegung: 'w' (Norden), 's' (Süden), 'a' (Westen), 'd' (Osten)");
            System.out.print("Gib einen Befehl ein: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            if (parts.length > 0) {
                String command = parts[0];
                if (command.equalsIgnoreCase("pickup") && parts.length > 1) {
                    String itemName = parts[1];
                    game.pickUpItem(itemName);
                } else if (command.equalsIgnoreCase("drop") && parts.length > 1) {
                    String itemName = parts[1];
                    game.dropItem(itemName);
                } else if (command.equalsIgnoreCase("exit")) {
                    System.out.println("Das Spiel wurde beendet.");
                    break;
                } else if (command.equalsIgnoreCase("map")) {
                    game.printMap();
                } else if (command.equalsIgnoreCase("openChest")) {
                    game.openChest();
                } else if (input.length() == 1) {
                    char movement = input.charAt(0);
                    switch (movement) {
                        case 'w':
                            game.movePlayer("Norden");
                            break;
                        case 's':
                            game.movePlayer("Süden");
                            break;
                        case 'a':
                            game.movePlayer("Westen");
                            break;
                        case 'd':
                            game.movePlayer("Osten");
                            break;
                        default:
                            System.out.println("Ungültiger Befehl.");
                            break;
                    }
                } else {
                    System.out.println("Ungültiger Befehl.");
                }
            }
        }
    }
}
