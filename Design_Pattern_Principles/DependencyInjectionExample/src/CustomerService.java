public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository repository) {
        this.customerRepository = repository;
    }
    public void getCustomerDetails(int id) {
        System.out.println("ID    : " + id);
        String customerData = customerRepository.findCustomerById(id);
        System.out.println("Result: " + customerData);
    }
}