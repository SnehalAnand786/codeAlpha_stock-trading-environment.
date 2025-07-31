import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Stock class
class Stock {
    String symbol;
    double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}

// User class
class User {
    String username;
    double balance;
    Map<String, Integer> portfolio;

    public User(String username, double balance) {
        this.username = username;
        this.balance = balance;
        this.portfolio = new HashMap<String, Integer>();
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public Map<String, Integer> getPortfolio() {
        return portfolio;
    }

    public void buyStock(Stock stock, int quantity) {
        if (balance >= stock.getPrice() * quantity) {
            balance -= stock.getPrice() * quantity;
            portfolio.put(stock.getSymbol(), portfolio.getOrDefault(stock.getSymbol(), 0) + quantity);
            System.out.println("Bought " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        if (portfolio.containsKey(stock.getSymbol()) && portfolio.get(stock.getSymbol()) >= quantity) {
            balance += stock.getPrice() * quantity;
            portfolio.put(stock.getSymbol(), portfolio.get(stock.getSymbol()) - quantity);
            System.out.println("Sold " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("You do not own enough shares to sell");
        }
    }
}

public class StockTradingEnvironment {
    ArrayList<Stock> stocks;
    ArrayList<User> users;
    Scanner scanner;

    public StockTradingEnvironment() {
        this.stocks = new ArrayList<String, Integer>();
        this.users = new ArrayList<String, Integer>();
        this.scanner = new Scanner(System.in);

        // Initialize stocks
        stocks.add(new Stock("AAPL", 150.0));
        stocks.add(new Stock("GOOG", 2500.0));
        stocks.add(new Stock("MSFT", 200.0));
    }

    public void run() {
        while (true) {
            System.out.println("1. Create user");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    createUser();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void createUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over
        users.add(new User(username, balance));
        System.out.println("User created successfully");
    }

    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                loggedInMenu(user);
                return;
            }
        }
        System.out.println("User not found");
    }

    private void loggedInMenu(User user) {
        while (true) {
            System.out.println("1. Display market data");
            System.out.println("2. Buy stock");
            System.out.println("3. Sell stock");
            System.out.println("4. Display portfolio");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    displayMarketData();
                    break;
                case 2:
                    buyStock(user);
                    break;
                case 3:
                    sellStock(user);
                    break;
                case 4:
                    displayPortfolio(user);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void displayMarketData() {
        System.out.println("Market Data:");
        for (Stock stock : stocks) {
System.out.println("Market Data:");
}
}
}



