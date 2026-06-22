public class Main {
    public static void main(String[] args) {
        StockMarket stock = new StockMarket();
        Observer alex = new MobileApp("Alex");
        Observer liveDashboard = new WebApp();
        stock.register(alex);
        stock.register(liveDashboard);

        System.out.println("\nMarket Update 1:-");
        stock.setStockData("AAPL (Apple)", 175.50);

        System.out.println("\nMarket Update 2:-");
        stock.setStockData("TSLA (Tesla)", 220.15);

        stock.deregister(alex);
        System.out.println("\nMarket Update 3 (Alex Unsubscribed):-");
        stock.setStockData("AAPL (Apple)", 178.20);
    }
}