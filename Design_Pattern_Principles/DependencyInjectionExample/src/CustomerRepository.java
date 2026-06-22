interface CustomerRepository {
    String findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        if (id == 101) return "John Doe (Premium Member)";
        else if (id == 102) return "Alice Smith (Standard Member)";
        else return "Customer Not Found";
    }
}