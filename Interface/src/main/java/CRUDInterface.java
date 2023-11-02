import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CRUDInterface extends Remote {
    public List<String> getStudents() throws RemoteException;
    public List<String> addStudent(String student) throws RemoteException;
    public List<String> deleteStudents(String student) throws RemoteException;


}
