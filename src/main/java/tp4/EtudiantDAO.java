package tp4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/universite";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

   
    public static List<Etudiant> getAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String selectQuery = "SELECT * FROM etudiants";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Etudiant etudiant = new Etudiant();
                    etudiant.setId(resultSet.getInt("id"));
                    etudiant.setNom(resultSet.getString("nom"));
                    etudiant.setPrenom(resultSet.getString("prenom"));
                    etudiant.setDateNaissance(resultSet.getDate("date_naissance"));
                    etudiant.setFiliere(resultSet.getString("filiere"));
                    etudiants.add(etudiant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }

    
    public static Etudiant getEtudiantById(int id) {
        Etudiant etudiant = null;

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String selectQuery = "SELECT * FROM etudiants WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        etudiant = new Etudiant();
                        etudiant.setId(resultSet.getInt("id"));
                        etudiant.setNom(resultSet.getString("nom"));
                        etudiant.setPrenom(resultSet.getString("prenom"));
                        etudiant.setDateNaissance(resultSet.getDate("date_naissance"));
                        etudiant.setFiliere(resultSet.getString("filiere"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }

        return etudiant;
    }

    
    public static boolean addEtudiant(Etudiant etudiant) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String insertQuery = "INSERT INTO etudiants (nom, prenom, date_naissance, filiere) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, etudiant.getNom());
                preparedStatement.setString(2, etudiant.getPrenom());
                preparedStatement.setDate(3, new java.sql.Date(etudiant.getDateNaissance().getTime()));
                preparedStatement.setString(4, etudiant.getFiliere());
                int rowsInserted = preparedStatement.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
         
            return false;
        }
    }

    public static boolean updateEtudiant(Etudiant etudiant) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String updateQuery = "UPDATE etudiants SET nom = ?, prenom = ?, date_naissance = ?, filiere = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, etudiant.getNom());
                preparedStatement.setString(2, etudiant.getPrenom());
                preparedStatement.setDate(3, new java.sql.Date(etudiant.getDateNaissance().getTime()));
                preparedStatement.setString(4, etudiant.getFiliere());
                preparedStatement.setInt(5, etudiant.getId());
                int rowsUpdated = preparedStatement.executeUpdate();
                return rowsUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
          
            return false;
        }
    }

    public static boolean deleteEtudiant(int id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String deleteQuery = "DELETE FROM etudiants WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, id);
                int rowsDeleted = preparedStatement.executeUpdate();
                return rowsDeleted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
          
            return false;
        }
    }
}
