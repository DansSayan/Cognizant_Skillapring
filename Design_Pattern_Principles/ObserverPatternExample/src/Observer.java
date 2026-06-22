interface Observer {
    void update (String stock_sym, double price);
}
interface Stock {
    void register (Observer observer);
    void deregister (Observer observer);
    void notifyObservers ();
}