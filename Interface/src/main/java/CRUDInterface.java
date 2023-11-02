import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CRUDInterface extends Remote {
    public List<String> getStudents(boolean isCallFromSever) throws RemoteException;
    public List<String> addStudent(String student, boolean isCallFromSever) throws RemoteException;
    public List<String> deleteStudents(String student, boolean isCallFromSever) throws RemoteException;


}
