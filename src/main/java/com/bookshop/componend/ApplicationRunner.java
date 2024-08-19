package main.java.com.bookshop.componend;


public class ApplicationRunner {

    private final EntityRegister entityRegister = new EntityRegister();
    public void run(){
        if(Authenticator.authentication()){
            entityRegister.registerClients();
        }

    }
}
