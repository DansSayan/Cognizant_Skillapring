public class Main {
    public static void main (String[] args) {
        Computer gamingPC = new Computer.Builder()
            .setCPU("Intel Core i7")
            .setRAM("16GB")
            .setStorage("1TB SSD")
            .setGPU("NVIDIA RTX 4060")
            .build();
        System.out.println(gamingPC);

        Computer officePC = new Computer.Builder()
            .setCPU("Intel Core i5")
            .setRAM("8GB")
            .setStorage("512GB SSD")
            .setGPU("AMD RX 7600")
            .build();
        System.out.println(officePC);
    }
}
