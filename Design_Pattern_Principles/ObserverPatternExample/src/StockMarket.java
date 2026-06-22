import java.util.*;
class StockMarket implements Stock {
    private List <Observer> obs = new ArrayList<>();
    private String stock_sym;
    private double price;
    public void setStockData(String stockSymbol, double price) {
        this.stock_sym = stockSymbol;
        this.price = price;
        notifyObservers(); 
    }
    @Override
    public void register(Observer observer) { obs.add(observer); }
    @Override
    public void deregister(Observer observer) { obs.remove(observer); }
    @Override
    public void notifyObservers() {
        for (Observer observer : obs) 
            observer.update(stock_sym, price);
    }
}
class MobileApp implements Observer {
    private String user;
    public MobileApp(String user) { this.user = user; }
    @Override
    public void update(String stock_sym, double price) {
        System.out.println("[Mobile Notification for " + user + "] " + stock_sym + " is now $" + price);
    }
}
class WebApp implements Observer {
    @Override
    public void update(String stock_sym, double price) {
        System.out.println("[Web Dashboard Alert] Live Feed updated -> " + stock_sym + ": $" + price);
    }
}