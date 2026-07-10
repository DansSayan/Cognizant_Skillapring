package com.example;

public class MyService {
    private ExternalApi api;
    public MyService(ExternalApi api) {
        this.api = api;
    }
    public String fetchData() {
        return api.getData();
    }
    public String fetchDataSeq() {
        String step1 = api.getData();
        String step2 = api.getData();
        return step1 + " & " + step2;
    }
    public void performAction() {
        api.checkAccess();
    }
}