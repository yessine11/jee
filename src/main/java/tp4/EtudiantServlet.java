package tp4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.List;
@WebServlet("/EtudiantServlet")
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/universite";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		List<Etudiant> etudiants = EtudiantDAO.getAllEtudiants();
		try {
	
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            String selectQuery = "SELECT * FROM etudiants";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
			}

            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		 request.setAttribute("etudiants", etudiants);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
	        dispatcher.forward(request, response);
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int rowsInserted = 0;
			int rowsUpdated = 0;
			int rowsDeleted = 0;
			
			String action = request.getParameter("action");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	            

	            if ("ajouter".equals(action)) {
	            String insertQuery = "INSERT INTO etudiants (nom, prenom, date_naissance, filiere) VALUES (?, ?, ?, ?)";
	            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
	            insertStatement.setString(1, request.getParameter("nom"));
	            insertStatement.setString(2, request.getParameter("prenom"));
	            insertStatement.setDate(3, Date.valueOf(request.getParameter("date_naissance"))); // Assuming date_naissance is a date
	            insertStatement.setString(4, request.getParameter("filiere"));
	            rowsInserted = insertStatement.executeUpdate();
	            System.out.println("Rows Inserted: " + rowsInserted);
	            response.sendRedirect(request.getContextPath() + "/etudiant");

	            } else if ("modifier".equals(action)) {
	            String updateQuery = "UPDATE etudiants SET nom = ?, prenom = ?, date_naissance = ?, filiere = ? WHERE id = ?";
	            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	            updateStatement.setString(1, request.getParameter("nom"));
	            updateStatement.setString(2, request.getParameter("prenom"));
	            updateStatement.setDate(3, Date.valueOf(request.getParameter("date_naissance"))); // Assuming date_naissance is a date
	            updateStatement.setString(4, request.getParameter("filiere"));
	            updateStatement.setInt(5, Integer.parseInt(request.getParameter("id"))); rowsUpdated = updateStatement.executeUpdate();
	            System.out.println("Rows Updated: " + rowsUpdated);
	            response.sendRedirect(request.getContextPath() + "/etudiant");
	            
	            } else if ("supprimer".equals(action)) {
	            String deleteQuery = "DELETE FROM etudiants WHERE id = ?";
	            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
	            deleteStatement.setInt(1, Integer.parseInt(request.getParameter("id")));
	            rowsDeleted = deleteStatement.executeUpdate();
	            System.out.println("Rows Deleted: " + rowsDeleted);
	            response.sendRedirect(request.getContextPath() + "/etudiant");
	            } 

	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

			
		}