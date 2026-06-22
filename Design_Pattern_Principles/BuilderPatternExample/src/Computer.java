public class Computer {
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final String GPU;
    private Computer (Builder build) {
            this.CPU = build.CPU;
            this.RAM = build.RAM;
            this.storage = build.storage;
            this.GPU = build.GPU;
        }
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public String getGPU() { return GPU; }
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", GPU=" + GPU + "]";
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        public Builder setCPU (String CPU) {
            this.CPU = CPU;
            return this;
        }
        public Builder setRAM (String RAM) {
            this.RAM = RAM;
            return this;
        }
        public Builder setStorage (String storage) {
            this.storage = storage;
            return this;
        }
        public Builder setGPU (String GPU) {
            this.GPU = GPU;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }
}
