import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;

public class AuctionClient extends UnicastRemoteObject implements AuctionClientInterface {
    private static Auction auction;
    private String name;

    protected AuctionClient(String name) throws RemoteException {
        super();
        this.name = name;
    }

    @Override
    public void notifyClient(String message) throws RemoteException {
        System.out.println("SERVER UPDATE: " + message);
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            auction = (Auction) Naming.lookup("rmi://localhost/AuctionService");
            AuctionClient client = new AuctionClient(name);
            auction.registerClient(client);

            while (true) {
                System.out.print("Enter bid amount: ");
                double bid = scanner.nextDouble();
                String response = auction.placeBid(name, bid);
                System.out.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
