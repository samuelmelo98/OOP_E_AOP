package Entities;

public class ClientServiceImplements implements ClientService {
    @Override
    public void cadastrarClient(String clientName) {
        System.out.println("Cadastrando cliente: " + clientName);

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Cliente cadastrado com sucesso!");
    }
}
