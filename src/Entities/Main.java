package Entities;

public class Main {
    public static void main(String[] args) {
        // Criando a instância original
        ClientService clienteService = new ClientServiceImplements();

        // Criando um proxy que aplica o aspecto
        ClientService proxy = (ClientService) PerfomaceAspect.createProxy(clienteService);

        // Chamando o método via proxy
        proxy.cadastrarClient("João");
    }
}
