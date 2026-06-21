public class PDFFactory extends AbstractFactory {
    public CommonInterface createDocument() {
        return new PDF();
    }
}
