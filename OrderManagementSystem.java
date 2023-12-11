// Import statements for necessary Java and SQL classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.io.InputStream;

// Class definition for OrderManagementSystem
//OrderManagementSystem.java

public class OrderManagementSystem {
	
//Logger for logging events
	private static final Logger logger = Logger.getLogger(OrderManagementSystem.class.getName());
	//Database Connection
    private static Connection connection;
    
 public static void main(String[] args) {
	 initialize();
	 
	 //DATABASE INTERACTION - Initialize the Scanner
	 Scanner scanner = new Scanner(System.in);
	 
	 // Additional interactions for user management
     System.out.println("User Management Menu:");
     System.out.println("1. Add User");
     System.out.println("2. Display Users");
     System.out.print("Enter your choice: ");
     int userChoice = scanner.nextInt();
     
     switch (userChoice) {
     case 1:
         addUser();
         break;
     case 2:
         displayUsers();
         break;
     default:
         System.out.println("Invalid choice...The system will continue with order management.");
 }

     //Order Management
     OrderManagementSystem orderManagementSystem = new OrderManagementSystem();
     processOrders(scanner, orderManagementSystem);

     // Create an order
     Order newOrder = new Order(1, "John Doe", "ProductA", 5);
     
     // DATABASE INTERACTION - Add the order
     orderManagementSystem.addOrder(newOrder);

         try {
             String choice = "y";

             System.out.println("Welcome to The Shop!");

             char sel;
             do {
                 System.out.println("Please enter the price of your item:");
                 String orderText = scanner.next();
                 orderManagementSystem.addOrder(orderText);

                 System.out.println("Please continue with your order (type 'y' to continue or 'q' when you are finished):");
                 choice = scanner.next();
             } while (choice.equalsIgnoreCase("y"));

             orderManagementSystem.printOrders();

             // DATABASE INTERACTIONS - updateOrderInDatabase & deleteOrderFromDatabase
             System.out.println("Do you want to update or delete an order? (type 'u' to update, 'd' to delete, or 'n' to exit):");
             choice = scanner.next();

             if (choice.equalsIgnoreCase("u")) {
                 System.out.println("Enter the ID of the order to update:");
                 int orderId = scanner.nextInt();
                 System.out.println("Enter the updated order text:");
                 String updatedOrderText = scanner.next();
                 orderManagementSystem.updateOrderInDatabase(orderId, updatedOrderText);
             } else if (choice.equalsIgnoreCase("d")) {
                 System.out.println("Enter the ID of the order to delete:");
                 int orderId = scanner.nextInt();
                 orderManagementSystem.deleteOrderFromDatabase(orderId);
             }

             System.out.println("Do you want to place another order? (type 'y' to continue or 'n' to exit):");
             choice = scanner.next();

         } finally {
             try {
                 if (connection != null) {
                     connection.close();
                     logger.info("Database connection closed.");
                 }
                 if (scanner != null) {
                     scanner.close();
                 }
             } catch (SQLException e) {
                 logger.log(Level.SEVERE, "Error closing the database connection", e);
                 e.printStackTrace();
                 
              // DATABASE INTERACTIONS
                 System.out.println("Do you want to update or delete an order? (type 'u' to update, 'd' to delete, or 'n' to exit):");
                 String choice = scanner.next();

                 if (choice.equalsIgnoreCase("u")) {
                     System.out.println("Enter the ID of the you would like to order to update:");
                     int orderId = scanner.nextInt();
                     System.out.println("Enter the updated order text:");
                     String updatedOrderText = scanner.next();
                     orderManagementSystem.updateOrderInDatabase(orderId, updatedOrderText);
                 } else if (choice.equalsIgnoreCase("d")) {
                     System.out.println("Enter the ID of the order that you would like to delete:");
                     int orderId = scanner.nextInt();
                     orderManagementSystem.deleteOrderFromDatabase(orderId);
                 }
             }
         }
 }

 private static void initialize() {
	// TODO Auto-generated method stub
	
}

private void addOrder(Order newOrder) {
	// TODO Auto-generated method stub
	
}

private static void closeResources(Scanner scanner) {
	// TODO Auto-generated method stub
	
}

private static void processOrders(Scanner scanner, OrderManagementSystem orderManagementSystem) {
	// TODO Auto-generated method stub
	
}

private static int getUserManagementChoice(Scanner scanner) {
	// TODO Auto-generated method stub
	return 0;
}

private static void displayUsers() {
	// TODO Auto-generated method stub
	 System.out.println("Display Users Functionality Placeholder");
	
}
 private static void createUsersTable() {
	 //TODO: Implement logic to create the users table
	 System.out.println("Create Users Table Functionality Placeholder");
 }

//Database Interaction - add User
 private static void addUser() {
     try {
    	 Scanner scanner = new Scanner(System.in);
         // Take user input for first name, last name, phone number, and email
         System.out.print("Enter First Name: ");
         String firstName = scanner.next();

         System.out.print("Enter Last Name: ");
         String lastName = scanner.next();

         System.out.print("Enter Phone Number: ");
         String phoneNumber = scanner.next();

         System.out.print("Enter Email: ");
         String email = scanner.next();

         // Call a method to add user to the database
         addUserToDatabase(firstName, lastName, phoneNumber, email);

         logger.info("User's info added successfully.");

     } catch (Exception e) {
         logger.log(Level.SEVERE, "Error adding user", e);
     }
 }

 //private static void displayUsers() {
    // try {
         // Call a method to fetch and display users from the database
     //    List<String> users = fetchUsersFromDatabase();

    //     System.out.println("Users from the Database:");
      //   for (String user : users) {
        //     System.out.println(user);
         //}

 //    } catch (Exception e) {
   //      logger.log(Level.SEVERE, "Error displaying users", e);
    // }
 //}

 private static void addUserToDatabase(String firstName, String lastName, String phoneNumber, String email) {
     // TODO: Implement the logic to add a user to the database
     System.out.println("Add User to Database Functionality Placeholder");
 }

 //private static List<String> fetchUsersFromDatabase() {
     // TODO: Implement the logic to fetch users from the database
     //System.out.println("Fetch Users From Database Functionality Placeholder");
     //return new ArrayList<>();
 //}

         //    users.add(user);
       //  }

    // } catch (SQLException e) {
    //     logger.log(Level.SEVERE, "Error fetching users from the database", e);
   //  }
     //return users;
 

    // List to store orders
    private List<String> orders;
    
    // Logger for logging events
    //private static final Logger logger = Logger.getLogger(OrderManagementSystem.class.getName());
    
    // Database connection
    //private static Connection connection;

    // Static block to initialize logger and database connection
    static {
        // Set the logging level to SEVERE
        logger.setLevel(Level.ALL);
        try {
            // FileHandler for logging to a file
            FileHandler fileHandler = new FileHandler("mylog.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            // Load custom logging configuration
            InputStream stream = OrderManagementSystem.class.getClassLoader().getResourceAsStream("logging.properties");
            if (stream != null) {
                try {
                    LogManager.getLogManager().readConfiguration(stream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            

            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost/the_shop", "root", "root");
            logger.info("Connected to the database.");

            // Create table if it doesn't exist
            createTable();
        } catch (SQLException | SecurityException | IOException e) {
            // Log and print stack trace in case of an error
            logger.log(Level.SEVERE, "Error initializing logger or database connection", e);
            ((Throwable) e).printStackTrace();
        }
    }

    // Method to create orders table in the database
    //Database Interaction - Create Table
    private static void createTable() {
        try (PreparedStatement statement = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS orders (id INTEGER PRIMARY KEY AUTO_INCREMENT, order_text TEXT)")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            // Log error if table creation fails
            logger.log(Level.SEVERE, "Error creating table", e);
        }
    }

    // Constructor for OrderManagementSystem
    public OrderManagementSystem() {
        // Initialize the list of orders
        orders = new ArrayList<>();
    }

    // Method to add an order to the list and save it to the database
    public void addOrder(String orderText) {
        orders.add(orderText);
        saveOrderToDatabase(orderText);
        logger.info("Order added: " + orderText);
    }

    // Method to save an order to the database
    private void saveOrderToDatabase(String orderText) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO orders (order_text) VALUES (?)")) {
            statement.setString(1, orderText);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Log error if saving order to the database fails
            logger.log(Level.SEVERE, "Error saving order to the database", e);
        }
    }

    // Method to print orders from the database
    public void printOrders() {
        System.out.println("Orders from the MySQL Database:");
        List<String> databaseOrders = fetchOrdersFromDatabase();
        for (String orderText : databaseOrders) {
            System.out.println(orderText);
        }
    }

    // Method to fetch orders from the database
    //Database Interaction - Fetch orders from database
    private List<String> fetchOrdersFromDatabase() {
        List<String> databaseOrders = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String orderText = resultSet.getString("order_text");
                databaseOrders.add(orderText);
            }

        } catch (SQLException e) {
            // Log error if fetching orders from the database fails
            logger.log(Level.SEVERE, "Error fetching orders from the database", e);
            e.printStackTrace();
        }
        return databaseOrders;
    }

	private void deleteOrderFromDatabase(int orderId) {
		// TODO Auto-generated method stub
		
	}

	private void updateOrderInDatabase(int orderId, String updatedOrderText) {
		// TODO Auto-generated method stub
		    try {
		        // Prepare the update statement
		        String updateQuery = "UPDATE orders SET order_text = ? WHERE id = ?";
		        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
		            // Set the updated order text and order ID as parameters
		            statement.setString(1, updatedOrderText);
		            statement.setInt(2, orderId);

		            // Execute the update statement
		            int rowsAffected = statement.executeUpdate();

		            // Check if the update was successful
		            if (rowsAffected > 0) {
		                logger.info("Order updated successfully. Order ID: " + orderId);
		            } else {
		                logger.warning("No order found with ID: " + orderId);
		            }
		        }
		    } catch (SQLException e) {
		        // Log error if updating order in the database fails
		        logger.log(Level.SEVERE, "Error updating order in the database", e);
		    }
		}
}
