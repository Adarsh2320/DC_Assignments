import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public interface Auction extends Remote {
    String placeBid(String bidderName, double bidAmount) throws RemoteException;
    double getHighestBid() throws RemoteException;
    String getHighestBidder() throws RemoteException;
    void registerClient(AuctionClientInterface client) throws RemoteException;
}
