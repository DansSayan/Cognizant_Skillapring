// Step 3: Implement Concrete Commands
class LightOnCommand implements Command { 
    private Light light; 
    public LightOnCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.turnOn();
    }
}
class LightOffCommand implements Command { 
    private Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.turnOff();
    }
}
class RemoteControl {
    private Command command; 
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        if (command != null) {
            command.execute(); 
        } else {
            System.out.println("No command assigned to this slot.");
        }
    }
}