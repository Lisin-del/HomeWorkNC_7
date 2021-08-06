package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ZooInit {
    private ConnectionDb db = ConnectionDb.getInstanceConnect();

    private List<CageImpl> cages = new LinkedList<>();

    private ConditionImpl conditionForCageOne = new ConditionImpl(Species.LEON);
    private ConditionImpl conditionForCageTwo = new ConditionImpl(Species.GIRAFFE);
    private ConditionImpl conditionForCageThree = new ConditionImpl(Species.SQUIRREL);
    private ConditionImpl conditionForCageFour = new ConditionImpl(Species.PENGUIN);

    private CageImpl cageOne;
    private CageImpl cageTwo;
    private CageImpl cageThree;
    private CageImpl cageFour;

    public void checkDbCage() {
        Connection connection = db.getConnection();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT COUNT(*) FROM cage");
            while(resultSet.next()) {
                if(resultSet.getInt("count") == 0) {
                    cageOne = new CageImpl(1, 100, conditionForCageOne, true);
                    cageTwo = new CageImpl(2, 200, conditionForCageTwo, true);
                    cageThree = new CageImpl(3, 60, conditionForCageThree, true);
                    cageFour = new CageImpl(4, 80, conditionForCageFour, true);

                    Statement statement = connection.createStatement();
                    int resultUpdate = statement.executeUpdate("INSERT INTO cage(cond_cage, isvacantcage, cage_area) VALUES('leon', true, 100), " +
                            "('giraffe', true, 200), " +
                            "('squirrel', true, 60), " +
                            "('penguin', true, 80)");

                }
                else if(resultSet.getInt("count") > 0) {
                    resultSet = connection.createStatement().executeQuery("SELECT * FROM cage");

                    while(resultSet.next()) {
                        int id_cage = resultSet.getInt("id_cage");
                        String cond_cage = resultSet.getString("cond_cage");
                        boolean isVacantCage = resultSet.getBoolean("isvacantcage");
                        double cage_area = resultSet.getDouble("cage_area");

                        switch (cond_cage) {
                            case "leon": cageOne = new CageImpl(id_cage, cage_area, conditionForCageOne, isVacantCage);
                            break;
                            case "giraffe": cageTwo = new CageImpl(id_cage, cage_area, conditionForCageTwo, isVacantCage);
                            break;
                            case "squirrel": cageThree = new CageImpl(id_cage, cage_area, conditionForCageThree, isVacantCage);
                            break;
                            case "penguin": cageFour = new CageImpl(id_cage, cage_area, conditionForCageFour, isVacantCage);
                            break;
                        }
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
        cages.add(cageOne);
        cages.add(cageTwo);
        cages.add(cageThree);
        cages.add(cageFour);
    }

    public List<CageImpl> getCages() {
        return cages;
    }


}
