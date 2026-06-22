interface Notifier {
    void send (String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email : " + message);
    }
}