package system_design.hotel;

import java.util.List;

public class RequestService {

    public final RoomService roomService = new RoomService();

    List<Room> search(Request request) {
        List<Room> roomList = RequestQueue.match(request);
        return roomList;
    }

    boolean reserve(Request request) {
        List<Room> list = this.search(request);
        if (list.size() > 0) {
            request.roomId = list.get(0).id;
            roomService.reserve(request);
            return true;
        } else {
            this.wait(request);
            return true;
        }
    }

    boolean wait(Request request) {
        return RequestQueue.enqueue(request);
    }


    boolean checkin(Request request) throws Exception {
        return roomService.checkin(request.clientId);
    }

    boolean checkout(Request request) throws Exception {
        return roomService.checkout(request.clientId);
    }

    boolean notifyClient(Request request) {
        //
        System.out.println(request.clientId);
        reserve(request);
        return true;
    }


    public static void main(String[] args) throws Exception {
        RequestService requestService = new RequestService();
        Request request_1 = new Request(101, "double", true);
        Request request_2 = new Request(102, "double", true);

        requestService.reserve(request_1);
        requestService.reserve(request_2);

        requestService.checkin(request_1);
        try {
            requestService.checkin(request_2);
        } catch (Exception e) {
            System.out.println("assert exception here");
        }
        requestService.checkout(request_1);
        requestService.reserve(request_2);
        requestService.checkin(request_2);

        Room room = RoomDBMgt.findById(1);
        System.out.println(room);

    }
}
