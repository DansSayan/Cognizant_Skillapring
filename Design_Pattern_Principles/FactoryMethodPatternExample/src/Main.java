public class Main {
    public static void main(String[] args) {
        AbstractFactory wordFactory = new WordFactory();
        CommonInterface wordDocument = wordFactory.createDocument();
        wordDocument.open();

        AbstractFactory pdfFactory = new PDFFactory();
        CommonInterface pdfDocument = pdfFactory.createDocument();
        pdfDocument.open();

        AbstractFactory excelFactory = new ExcelFactory();
        CommonInterface excelDocument = excelFactory.createDocument();
        excelDocument.open();
    }
}
