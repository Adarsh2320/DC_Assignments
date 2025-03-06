import java.rmi.*;

public interface AuctionClientInterface extends Remote {
    void notifyClient(String message) throws RemoteException;
}
