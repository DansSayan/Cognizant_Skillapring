// Step 5: Test the Command Implementation
public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Command switchOn = new LightOnCommand(livingRoomLight);
        Command switchOff = new LightOffCommand(livingRoomLight);
        RemoteControl remote = new RemoteControl(); 
        
        System.out.println("\nTurning Light On :-");
        remote.setCommand(switchOn);
        remote.pressButton(); 

        System.out.println("\nTurning Light Off :-");
        remote.setCommand(switchOff);
        remote.pressButton(); 
    }
}