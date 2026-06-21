public class ExcelFactory extends AbstractFactory {
    public CommonInterface createDocument() {
        return new Excel();
    }
}
