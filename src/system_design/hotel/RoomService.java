package system_design.hotel;

public class RoomService {

    RoomDBMgt roomDBMgt = new RoomDBMgt();

    // should be async
    void prepare(int id) {
        Room room = roomDBMgt.findById(id);
        room.status = "ready";
        RequestQueue.notice(room);
    }

    boolean reserve(Request request) {
        Room room = roomDBMgt.findById(request.roomId);
        room.status = "reserved";
        room.clientId = request.clientId;
        return true;
    }

    boolean checkin(int clientId) throws Exception {
        Room room = roomDBMgt.findByClientId(clientId);
        if (room == null) {
            throw new Exception("record not found");
        }
        room.status = "checkin";
        return true;
    }

    boolean checkout(int clientId) throws Exception {

        Room room = roomDBMgt.findByClientId(clientId);
        if (room == null) {
            throw new Exception("record not found");
        }
        room.status = "checkout";
        room.clientId = 0;
        prepare(room.id);
        return true;
    }
}
