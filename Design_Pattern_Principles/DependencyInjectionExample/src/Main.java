public class Main {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        System.out.println("Fetching Existing Customer:-");
        service.getCustomerDetails(101);

        System.out.println("\nFetching Non-Existent Customer:-");
        service.getCustomerDetails(999);
    }
}