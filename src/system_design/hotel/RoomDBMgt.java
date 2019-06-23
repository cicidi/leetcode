package system_design.hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomDBMgt {
    static Map<Integer, Room> db = new HashMap<Integer, Room>();

    public static Room findById(int roomId) {
        return db.get(roomId);
    }

    static {
        db.put(1, new Room(1, "ready", "double"));
        db.put(2, new Room(2, "ready", "queen"));
        db.put(3, new Room(3, "ready", "king"));
    }

    public static List<Room> findByType(String type) {
        List<Room> result = new ArrayList<>();
        for (Map.Entry<Integer, Room> entry : db.entrySet()) {
            if (entry.getValue().status.equals("ready") && entry.getValue().type.equals(type)) {
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public Room findByClientId(int clientId) {
        for (Map.Entry<Integer, Room> entry : db.entrySet()) {
            if (entry.getValue().clientId == clientId) {
                return entry.getValue();
            }
        }
        return null;
    }
}
