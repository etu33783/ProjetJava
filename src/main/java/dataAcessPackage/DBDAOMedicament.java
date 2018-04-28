package dataAcessPackage;

import exceptionPackage.*;
import exceptionPackage.MedicamentException;
import modelPackage.Medicament;
import modelPackage.SoinAvance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DBDAOMedicament implements IMedicament {
    private Connection connectionUnique;
    private String sqlInstruction;

    private ResultSet data;

    public ArrayList<Medicament> getMedicaments() throws MedicamentException, SingletonConnectionException {
        try {

            if (connectionUnique == null) {
                connectionUnique = SingletonConnection.getUniqueInstance();
            }

            sqlInstruction = "select * from spabd.medicament";
            PreparedStatement statement = connectionUnique.prepareStatement(sqlInstruction);
            data = statement.executeQuery();

            ArrayList<Medicament> tousLesMedicaments = new ArrayList<Medicament>();
            while (data.next()) {
                Medicament medicament = new Medicament();
                GregorianCalendar datePreparation = new GregorianCalendar();

                medicament.setIdentifiantMed(data.getInt("identifiantMed"));
                datePreparation.setTime( data.getDate("datePreparation"));
                medicament.setDatePreparation(datePreparation);
                medicament.setStockage(data.getString("stockage"));
                medicament.setPosologie(data.getString("posologie"));
                medicament.setNomMedic(data.getString("nomMedic"));
                tousLesMedicaments.add(medicament);
            }

            //connectionUnique.close();
            return tousLesMedicaments;

        } catch (SQLException e) {
            throw new MedicamentException();
        }
    }

    public Medicament getUnMedicament(Integer identifiantMed) throws SingletonConnectionException, MedicamentException{

        try {
            if (connectionUnique == null) {
                connectionUnique = SingletonConnection.getUniqueInstance();
            }

            Medicament medicament = new Medicament();
            GregorianCalendar datePreparation = new GregorianCalendar();

            sqlInstruction = "select * from spabd.medicament where identifiantMed = ?";
            PreparedStatement statement = connectionUnique.prepareStatement(sqlInstruction);
            statement.setInt(1, identifiantMed);
            data = statement.executeQuery();

            while (data.next()) {
                medicament.setIdentifiantMed(data.getInt("identifiantMed"));
                datePreparation.setTime( data.getDate("datePreparation"));
                medicament.setDatePreparation(datePreparation);
                medicament.setStockage(data.getString("stockage"));
                medicament.setPosologie(data.getString("posologie"));
                medicament.setNomMedic(data.getString("nomMedic"));
            }

            return medicament;
        }
        catch (SQLException e) {
            throw new MedicamentException();
        }
    }
}
