public class Main {
    public static void main(String[] args) {
        Image highResPhoto = new ProxyImage("ultra_hd_space_photo.png");
        System.out.println("Proxy object created. No heavy download has started yet.\n");
        System.out.println("First Display Request:-");
        highResPhoto.display(); 
        
        System.out.println("\n-------------------------------------\n");
        System.out.println("Second Display Request:-");
        highResPhoto.display();
    }
}