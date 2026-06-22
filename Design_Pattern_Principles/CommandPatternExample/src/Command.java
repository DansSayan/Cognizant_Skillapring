interface Command {
    void execute(); 
}

class Light {
    public void turnOn() {
        System.out.println("The light is ON.");
    }
    public void turnOff() {
        System.out.println("The light is OFF.");
    }
}