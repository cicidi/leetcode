package system_design.hotel;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RequestQueue {

    static Queue<Request> queue = new LinkedList<>();

//    RequestService requestService = new RequestService();

    public static boolean enqueue(Request request) {
        queue.add(request);
        return false;
    }

    public static List<Room> match(Request request) {
        return RoomDBMgt.findByType(request.roomType);
    }

    public static Request notice(Room room) {
        while (!queue.isEmpty()) {
            Request request = queue.peek();
            if (request.roomType.equals(room.type)) {
                Request r = queue.poll();
                System.out.println("notify user " + r.clientId);
            }
        }
        return null;
    }
}
