import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }

        Connection conn = null;
        DriverManager.setLoginTimeout(60);
        try {
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")
                    .append("://")
                    .append("127.0.0.1")
                    .append(":")
                    .append(5432)
                    .append("/")
                    .append("company")
                    .append("?user=")
                    .append("postgres")
                    .append("&password=")
                    .append("iloveeddie").toString();
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }

        if (conn == null) {
            System.out.println("Connection error");
        }

        TablesManager tablesManager = new TablesManager();
        tablesManager.createTables(conn);
        tablesManager.printAccomodationAndRoomFair(conn);

        tablesManager.printTable(conn);



        Accomodation apartment1 = new Accomodation("Double Bedroom", "Double", 4, "Double Bedroom apartment near Paris with excellent view");
        Accomodation apartment2 = new Accomodation("Single Bedroom", "Single", 2, "Single Bedroom apartment near London with excellent view");
        Accomodation apartment3 = new Accomodation("PentHouse", "Double", 8, "Penthouse in Vienna perfect for 8 people");
        Accomodation apartment4 = new Accomodation("Apartment", "Double", 2, "Apartment in Bucharest With Double bed perfect for a couple");
        Accomodation apartment5 = new Accomodation("Hostel", "Double", 2, "Hostel in Berlin near Berlin Wall");
        Accomodation apartment6 = new Accomodation("Hotel", "Single", 4, "Hotel in Transylvania with four rooms each with their own Bed");


        tablesManager.insertIntoAccomodationTable(apartment1, conn);
        tablesManager.insertIntoAccomodationTable(apartment2, conn);
        tablesManager.insertIntoAccomodationTable(apartment3, conn);
        tablesManager.insertIntoAccomodationTable(apartment4, conn);
        tablesManager.insertIntoAccomodationTable(apartment5, conn);
        tablesManager.insertIntoAccomodationTable(apartment6, conn);

        RoomFair roomFairInSummer1 = new RoomFair(100, "Summer");
        RoomFair roomFairInSummer2 = new RoomFair(200,"Summer");
        RoomFair roomFairInSummer3 = new RoomFair(300, "Summer");
        RoomFair roomFairInSummer4 = new RoomFair(400,"Summer");
        RoomFair roomFairInAutumn1 = new RoomFair(100, "Autumn");
        RoomFair roomFairInAutumn2 = new RoomFair(200,"Autumn");
        RoomFair roomFairInAutumn3 = new RoomFair(300, "Autumn");
        RoomFair roomFairInAutumn4 = new RoomFair(400,"Autumn");
        RoomFair roomFairInWinter1 = new RoomFair(100, "Winter");
        RoomFair roomFairInWinter2 = new RoomFair(200,"Winter");
        RoomFair roomFairInWinter3 = new RoomFair(300, "Winter");
        RoomFair roomFairInWinter4 = new RoomFair(400,"Winter");
        RoomFair roomFairInSpring1 = new RoomFair(100, "Spring");
        RoomFair roomFairInSpring2 = new RoomFair(200,"Spring");
        RoomFair roomFairInSpring3 = new RoomFair(300, "Spring");
        RoomFair roomFairInSpring4 = new RoomFair(400,"Spring");


        tablesManager.insertIntoRoomFairTable(roomFairInSummer1, conn);
        tablesManager.insertIntoRoomFairTable(roomFairInSummer2,conn);
        tablesManager.insertIntoRoomFairTable(roomFairInSummer3, conn);
        tablesManager.insertIntoRoomFairTable(roomFairInSummer4,conn);
        tablesManager.insertIntoRoomFairTable(roomFairInAutumn1, conn);
        tablesManager.insertIntoRoomFairTable(roomFairInAutumn2,conn);
        tablesManager.insertIntoRoomFairTable(roomFairInAutumn3, conn);
        tablesManager.insertIntoRoomFairTable(roomFairInAutumn4,conn);
        tablesManager.insertIntoRoomFairTable(roomFairInWinter1, conn);
        tablesManager.insertIntoRoomFairTable(roomFairInWinter2,conn);
        tablesManager.insertIntoRoomFairTable(roomFairInWinter3, conn);
        tablesManager.insertIntoRoomFairTable(roomFairInWinter4,conn);
        tablesManager.insertIntoRoomFairTable(roomFairInSpring1, conn);
        tablesManager.insertIntoRoomFairTable(roomFairInSpring2,conn);
        tablesManager.insertIntoRoomFairTable(roomFairInSpring3, conn);
        tablesManager.insertIntoRoomFairTable(roomFairInSpring4,conn);

        AccomodationFairRelation accomodationFairRelation1 = new AccomodationFairRelation(1,2);
        AccomodationFairRelation accomodationFairRelation2 = new AccomodationFairRelation(2,2);
        AccomodationFairRelation accomodationFairRelation3 = new AccomodationFairRelation(3,3);
        AccomodationFairRelation accomodationFairRelation4 = new AccomodationFairRelation(4,3);
        AccomodationFairRelation accomodationFairRelation5 = new AccomodationFairRelation(5,4);
        AccomodationFairRelation accomodationFairRelation6 = new AccomodationFairRelation(6,1);
        AccomodationFairRelation accomodationFairRelation7 = new AccomodationFairRelation(1,5);
        AccomodationFairRelation accomodationFairRelation8 = new AccomodationFairRelation(2,5);
        AccomodationFairRelation accomodationFairRelation9 = new AccomodationFairRelation(3,7);
        AccomodationFairRelation accomodationFairRelation10 = new AccomodationFairRelation(4,7);
        AccomodationFairRelation accomodationFairRelation11 = new AccomodationFairRelation(5,8);
        AccomodationFairRelation accomodationFairRelation12 = new AccomodationFairRelation(6,7);
        AccomodationFairRelation accomodationFairRelation13 = new AccomodationFairRelation(1,9);
        AccomodationFairRelation accomodationFairRelation14 = new AccomodationFairRelation(2,9);
        AccomodationFairRelation accomodationFairRelation15 = new AccomodationFairRelation(3,10);
        AccomodationFairRelation accomodationFairRelation16 = new AccomodationFairRelation(4,10);

        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation1, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation2, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation3, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation4, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation5, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation6, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation7, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation8, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation9, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation10, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation11, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation12, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation13, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation14, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation15, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation16, conn);



    }
}
