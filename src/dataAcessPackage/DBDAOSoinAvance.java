package dataAcessPackage;

import exceptionPackage.SingletonConnectionException;
import exceptionPackage.SoinException;
import exceptionPackage.VeterinaireException;
import modelPackage.SoinAvance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DBDAOSoinAvance implements ISoinAvance{
    private Connection connectionUnique;
    private String sqlInstruction;

    private ResultSet data;

    public ArrayList<SoinAvance> getSoinsAvances() throws SoinException, SingletonConnectionException, VeterinaireException {
        try {

            if (connectionUnique == null) {
                connectionUnique = SingletonConnection.getUniqueInstance();
            }

            sqlInstruction = "select * from spabd.soinAvance";
            PreparedStatement statement = connectionUnique.prepareStatement(sqlInstruction);
            data = statement.executeQuery();

            ArrayList<SoinAvance>  tousLesSoins = new ArrayList<SoinAvance>();
            GregorianCalendar dateSoin = new GregorianCalendar();
            GregorianCalendar heure = new GregorianCalendar();

            while (data.next()) {
                SoinAvance soin = new SoinAvance();
                soin.setNumRegistre(data.getInt("numSoin"));
                soin.setNumRegistre(data.getInt("numRegistre"));
                soin.setIntitule(data.getString("intitule"));
                soin.setPartieDuCorps(data.getString("partieDuCorps"));
                dateSoin.setTime( data.getDate("dateSoin"));
                soin.setDateSoin(dateSoin);
                IVeterinaire veterinaire = new DBDAOVeterinaire();
                soin.setVeterinaire(veterinaire.getUnVeterinaire(data.getInt("identifiantVeto")));
                soin.setEstUrgent(data.getBoolean("estUrgent"));

                heure.setTime( data.getDate("heure"));
                if(!data.wasNull()){
                    soin.setHeure(heure);
                }

                String remarque = data.getString("remarque");
                if(!data.wasNull()){
                    soin.setRemarque(remarque);
                }
                tousLesSoins.add(soin);
            }

            connectionUnique.close();
            return tousLesSoins;

        }
        catch (SQLException e) {
            throw new SoinException();
        }
    }

    public SoinAvance getUnSoinAvance(Integer numSoin) throws SingletonConnectionException, SoinException, VeterinaireException {

        try {
            if (connectionUnique == null) {
                connectionUnique = SingletonConnection.getUniqueInstance();
            }

            SoinAvance soin = new SoinAvance();
            GregorianCalendar dateSoin = new GregorianCalendar();
            GregorianCalendar heure = new GregorianCalendar();

            sqlInstruction = "select * from spabd.soinAvance where numSoin = ?";
            PreparedStatement statement = connectionUnique.prepareStatement(sqlInstruction);
            statement.setInt(1, numSoin);
            data = statement.executeQuery();

            while (data.next()) {
                soin.setNumRegistre(data.getInt("numSoin"));
                soin.setNumRegistre(data.getInt("numRegistre"));
                soin.setIntitule(data.getString("intitule"));
                soin.setPartieDuCorps(data.getString("partieDuCorps"));
                dateSoin.setTime( data.getDate("dateSoin"));
                soin.setDateSoin(dateSoin);
                IVeterinaire veterinaire = new DBDAOVeterinaire();
                soin.setVeterinaire(veterinaire.getUnVeterinaire(data.getInt("identifiantVeto")));
                soin.setEstUrgent(data.getBoolean("estUrgent"));

                heure.setTime( data.getDate("heure"));
                if(!data.wasNull()){
                    soin.setHeure(heure);
                }

                String remarque = data.getString("remarque");
                if(!data.wasNull()){
                    soin.setRemarque(remarque);
                };
            }
//test
            return soin;
        }
        catch (SQLException e) {
            throw new SoinException();
        }
    }
}
