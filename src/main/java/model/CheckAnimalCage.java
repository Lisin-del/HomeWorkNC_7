package model;

import javax.swing.plaf.nimbus.State;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CheckAnimalCage {
    private ConnectionDb db = ConnectionDb.getInstanceConnect();
    private List<String> namesAnimals = new ArrayList<>();
    private ZooInit zooInit;
    private int count;

    public CheckAnimalCage(ZooInit zooInit) {
        this.zooInit = zooInit;
    }

    public void checkNameAnimal() {
        Connection connection = db.getConnection();
        count = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM animal, cage WHERE animal.id_animal = cage.id_animal");
            while (rs.next()) {
                count = rs.getInt("count");
                if(rs.getInt("count") == 0) {
                    namesAnimals.add("nameNotFound");
                }
                else if(rs.getInt("count") > 0) {
                    rs = statement.executeQuery("SELECT name_animal FROM animal, cage WHERE animal.id_animal = cage.id_animal");
                    while (rs.next()) {
                        String name = rs.getString("name_animal");
                        namesAnimals.add(name);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getNamesAnimals() {
        return namesAnimals;
    }

    public int getCount() {
        return count;
    }


    public void updateAddAnimal(Species species, String name) {
        String speciesConvert = species.toString().toLowerCase();
        Connection connection = db.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = connection.createStatement().executeQuery("SELECT COUNT(*) FROM animal");
            while(rs.next()) {
                int l = rs.getInt("count");
                if(rs.getInt("count") == 0) {
                    int resultUpdate = statement.executeUpdate("INSERT INTO animal(species_animal, name_animal) VALUES('" + speciesConvert + "', '" + name + "')");
                    resultUpdate = statement.executeUpdate("UPDATE cage SET id_animal = animal.id_animal, isvacantcage = false  FROM animal WHERE animal.species_animal = cage.cond_cage");

                }
                else if(rs.getInt("count") > 0) {
                    int resultUpdate1 = statement.executeUpdate("UPDATE animal SET name_animal = '" + name + "' WHERE species_animal ='" + speciesConvert + "'");
                    int resultUpdate2 = statement.executeUpdate("UPDATE cage SET id_animal = animal.id_animal, isvacantcage = false  FROM animal WHERE animal.species_animal = cage.cond_cage");
                    if(resultUpdate1 == 0) {
                        resultUpdate1 = statement.executeUpdate("INSERT INTO animal(species_animal, name_animal) VALUES('" + speciesConvert + "', '" + name + "')");
                        resultUpdate2 = statement.executeUpdate("UPDATE cage SET id_animal = animal.id_animal, isvacantcage = false  FROM animal WHERE animal.species_animal = cage.cond_cage");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateOutAnimal(String removeAnimal) {
        Connection connection = db.getConnection();
        try {
            Statement statement = connection.createStatement();
            int resultRemove = statement.executeUpdate("UPDATE cage SET isvacantcage = true FROM animal WHERE animal.name_animal = '" + removeAnimal + "' AND animal.id_animal = cage.id_animal");
            resultRemove = statement.executeUpdate("DELETE FROM animal WHERE name_animal = '" + removeAnimal + "'");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void updateInLog(InhibitionLog inhibitionLog) {
        Connection connection = db.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = connection.createStatement().executeQuery("SELECT id_animal FROM animal WHERE name_animal = '" + inhibitionLog.getAnimalName() + "'");
            while (rs.next()) {
                int id_animal = rs.getInt("id_animal");
                int resultLogInsert = statement.executeUpdate("INSERT INTO \"inhibitionLog\"(checkindate, species_animal, name_animal, id_animal) VALUES('" + inhibitionLog.getCheckInDate() + "', '"
                        + inhibitionLog.getAnimalSpecies() + "', '" + inhibitionLog.getAnimalName() + "', '" + id_animal + "')");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateOutLog(InhibitionLog inhibitionLog) {
        Connection connection = db.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = connection.createStatement().executeQuery("SELECT log.checkindate, log.species_animal, an.id_animal FROM \"inhibitionLog\" AS log, animal AS an WHERE log.name_animal = '" + inhibitionLog.getAnimalName() + "' AND log.checkoutdate is null " +
                    "AND log.id_animal = an.id_animal");
            while(rs.next()) {
                String dt = rs.getString("checkindate");
                String species = rs.getString("species_animal");
                int id = rs.getInt("id_animal");
                int resultUpdateRemove = statement.executeUpdate("INSERT INTO \"inhibitionLog\"(checkindate, checkoutdate, species_animal, name_animal, id_animal) VALUES('" + dt + "', '"
                        + inhibitionLog.getCheckOutDate() + "', '" + species + "', '" + inhibitionLog.getAnimalName() + "', '" + id + "')");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void getLog() {
        Connection connection = db.getConnection();
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM \"inhibitionLog\"");
            while(rs.next()) {
                System.out.print(rs.getInt("id_log") + " ");
                System.out.print(rs.getString("checkindate") + " ");
                System.out.print(rs.getString("checkoutdate") + " ");
                System.out.print(rs.getString("species_animal") + " ");
                System.out.println(rs.getString("name_animal") + " ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
