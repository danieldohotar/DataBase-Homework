import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class Tests {

    private TablesManager tablesManager;
    private Connection conn;
    private Accomodation accomodation;
    private RoomFair roomFair;
    private AccomodationFairRelation accomodationFairRelation;

    @Before
    public void setup() {

        tablesManager = new TablesManager();
        accomodation = new Accomodation("Double Bedroom", "Single Beds", 2, "Perfect for Summer");
        roomFair = new RoomFair(200, "Summer");
        accomodationFairRelation = new AccomodationFairRelation(1, 1);

        conn = null;
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
    }

    @Test

    public void insertIntoTable() {
        tablesManager.insertIntoAccomodationTable(accomodation, conn);
        tablesManager.insertIntoRoomFairTable(roomFair, conn);
        tablesManager.insertIntoAccomodationFairRelationTable(accomodationFairRelation, conn);
    }

    @Test

    public void printApartmentTypeAndValue() {
        tablesManager.insertIntoAccomodationTable(accomodation, conn);
        tablesManager.insertIntoRoomFairTable(roomFair, conn);
        List<Object> list = tablesManager.printAccomodationAndRoomFair(conn);
        Accomodation accomodation = (Accomodation) list.get(0);
        RoomFair roomFair = (RoomFair) list.get(1);
        Assert.assertEquals("The bed type is not the expected one ", "Double", accomodation.getBedType());
        Assert.assertEquals("The description is not the expected one ", "Double Bedroom apartment near Paris with excellent view", accomodation.getDescription());
        Assert.assertEquals("The apartment type is not the expected one ", "Double Bedroom", accomodation.getType());
        Assert.assertEquals("Too many guests ", 4, accomodation.getMaxGuests());
        Assert.assertEquals("The season was not the expected one ", "Summer", roomFair.getSeason());
        Assert.assertEquals("The value was not the expected one", 100.0, roomFair.getValue(), 0.0);
    }
}
