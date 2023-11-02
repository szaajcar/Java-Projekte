import java.util.ArrayList;
import java.util.HashMap;



class Room {
    private String name;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;


    public Room(String name) {
        this.name = name;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }


    public void addItem(Item item) {
        items.add(item);
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public HashMap<String, Room> getExits() {
        return exits;
    }
    }

