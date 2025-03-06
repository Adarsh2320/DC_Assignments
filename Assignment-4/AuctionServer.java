import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;

public class AuctionServer extends UnicastRemoteObject implements Auction {
    private double highestBid = 0.0;
    private String highestBidder = "No bids yet";
    private List<AuctionClientInterface> clients = new ArrayList<>();

    public AuctionServer() throws RemoteException {
        super();
    }

    @Override
    public synchronized String placeBid(String bidderName, double bidAmount) throws RemoteException {
        if (bidAmount > highestBid) {
            highestBid = bidAmount;
            highestBidder = bidderName;
            notifyClients();
            return "Bid accepted! New highest bid: $" + highestBid + " by " + highestBidder;
        } else {
            return "Bid too low! Current highest: $" + highestBid + " by " + highestBidder;
        }
    }

    @Override
    public synchronized double getHighestBid() throws RemoteException {
        return highestBid;
    }

    @Override
    public synchronized String getHighestBidder() throws RemoteException {
        return highestBidder;
    }

    @Override
    public synchronized void registerClient(AuctionClientInterface client) throws RemoteException {
        clients.add(client);
        client.notifyClient("Welcome! Current highest bid is $" + highestBid + " by " + highestBidder);
    }

    private void notifyClients() throws RemoteException {
        for (AuctionClientInterface client : clients) {
            client.notifyClient("New highest bid: $" + highestBid + " by " + highestBidder);
        }
    }

    public static void main(String[] args) {
        try {
            AuctionServer server = new AuctionServer();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("AuctionService", server);
            System.out.println("Auction Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
