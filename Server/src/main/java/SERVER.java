import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;

public class SERVER {
    public static void main(String[] args) {
        try {
            // Set host server
            System.setProperty("java.rmi.server.hostname", Config.IP_SERVER);
            CRUDImpl server = new CRUDImpl();
            LocateRegistry.createRegistry(Config.PORT_SERVER);

            // Đăng ký đối tượng này với rmi registry
            Naming.rebind("rmi://" + Config.IP_SERVER + ":" + Config.PORT_SERVER + "/crud", server);

            System.out.println(">>>>>INFO: RMI Server started!!!!!!!!");
            System.out.println("rmi://" + Config.IP_SERVER + ":" + Config.PORT_SERVER + "/crud");


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
