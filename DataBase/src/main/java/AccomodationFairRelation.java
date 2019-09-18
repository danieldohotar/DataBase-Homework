public class AccomodationFairRelation {

    int id;
    int idAccomodation;
    int idRoomFair;

    public AccomodationFairRelation(int idAccomodation, int idRoomFair) {
        this.idAccomodation = idAccomodation;
        this.idRoomFair = idRoomFair;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAccomodation() {
        return idAccomodation;
    }

    public void setIdAccomodation(int idAccomodation) {
        this.idAccomodation = idAccomodation;
    }

    public int getIdRoomFair() {
        return idRoomFair;
    }

    public void setIdRoomFair(int idRoomFair) {
        this.idRoomFair = idRoomFair;
    }

    @Override
    public String toString() {
        return "AccomodationFairRelation{" +
                "id=" + id +
                ", idAccomodation=" + idAccomodation +
                ", idRoomFair=" + idRoomFair +
                '}';
    }
}
