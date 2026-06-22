interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;
    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer(); 
    }
    private void loadFromRemoteServer() {
        System.out.println("--> Connecting to remote server... Downloading " + filename);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void display() {
        System.out.println("Rendering and displaying image: " + filename);
    }
}