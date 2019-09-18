import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TablesManager {

    public void createTables(Connection conn) throws SQLException {

        PreparedStatement ps1 = conn.prepareStatement("CREATE TABLE IF NOT EXISTS accomodation(id SERIAL NOT NULL PRIMARY KEY,type varchar(32),bed_type varchar(32),max_guests INT, description varchar(512))");
        PreparedStatement ps2 = conn.prepareStatement("CREATE TABLE IF NOT EXISTS room_fair(id SERIAL NOT NULL PRIMARY KEY, value DOUBLE PRECISION, season varchar(32))");
        PreparedStatement ps3 = conn.prepareStatement("CREATE TABLE IF NOT EXISTS accomodation_fair_relation(id SERIAL NOT NULL PRIMARY KEY, id_accomodation integer REFERENCES accomodation (id), id_room_fair integer REFERENCES room_fair (id))");

        ps1.executeUpdate();
        ps1.close();
        ps2.executeUpdate();
        ps2.close();
        ps3.executeUpdate();
        ps3.close();
    }

    public void insertIntoAccomodationTable(Accomodation accomodation, Connection connection) {
        try (PreparedStatement ps = connection
                .prepareStatement("insert into accomodation (type, bed_type, max_guests, description)"
                        + "values (?, ?, ?, ?)")) {
            ps.setString(1, accomodation.type);
            ps.setString(2, accomodation.bedType);
            ps.setInt(3, accomodation.maxGuests);
            ps.setString(4, accomodation.description);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Cannot insert accomodation: " + e.getMessage());
        }
    }

    public void insertIntoRoomFairTable(RoomFair roomFair, Connection connection) {
        try (PreparedStatement ps = connection
                .prepareStatement("insert into room_fair (value, season)"
                        + "values (?, ?)")) {
            ps.setDouble(1, roomFair.value);
            ps.setString(2, roomFair.season);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Cannot insert room_fair: " + e.getMessage());
        }
    }

    public void insertIntoAccomodationFairRelationTable(AccomodationFairRelation accomodationFairRelation, Connection connection) {
        try (PreparedStatement ps = connection
                .prepareStatement("insert into accomodation_fair_relation (id_accomodation, id_room_fair)"
                        + "values (?, ?)")) {
            ps.setInt(1, accomodationFairRelation.idAccomodation);
            ps.setInt(2, accomodationFairRelation.idRoomFair);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Cannot insert accomodation_fair_relation: " + e.getMessage());
        }
    }

    public static void printTable(Connection conn) {

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT\n" +
                     "    *\n" +
                     "FROM \n" +
                     "    accomodation_fair_relation\n" +
                     "    INNER JOIN accomodation ON accomodation_fair_relation.id_accomodation = accomodation.id\n" +
                     "    INNER JOIN room_fair ON accomodation_fair_relation.id_room_fair = room_fair.id;")) {

            while (rs.next()) {
                String type = rs.getString("type");
                double value = rs.getDouble("value");
                System.out.println("The type is:->>>  " + type + "   " + "The value is:->>>  " + value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Object> printAccomodationAndRoomFair(Connection conn) {
        List<Object> list = new ArrayList<>();

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM accomodation INNER JOIN room_fair on accomodation.id = room_fair.id;")) {
            while (rs.next()) {
                String type = rs.getString("type");
                String bedType = rs.getString("bed_type");
                Integer maxGuests = rs.getInt("max_guests");
                String description = rs.getString("description");
                Double value = rs.getDouble("value");
                String season = rs.getString("season");

                Accomodation accomodation = new Accomodation(type, bedType, maxGuests, description);
                RoomFair roomFair = new RoomFair(value, season);
                list.add(accomodation);
                list.add(roomFair);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}