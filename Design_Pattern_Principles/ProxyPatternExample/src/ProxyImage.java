public class ProxyImage implements Image {
    private String filename;
    private RealImage realImage; 
    public ProxyImage(String filename) {
        this.filename = filename;
    }
    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("[Proxy] Image not loaded yet. Creating RealImage instance...");
            realImage = new RealImage(filename); 
        }
        else 
            System.out.println("[Proxy] Retrieving cached image instance."); 
        realImage.display();
    }
}