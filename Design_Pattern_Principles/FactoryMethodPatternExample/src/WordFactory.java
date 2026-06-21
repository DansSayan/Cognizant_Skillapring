public class WordFactory extends AbstractFactory {
    public CommonInterface createDocument() {
        return new Word();
    }
}
