
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CRUDImpl extends UnicastRemoteObject implements CRUDInterface{
    protected CRUDImpl() throws RemoteException {
    }

    @Override
    public List<String> getStudents() throws RemoteException {
        return Controller.getAllItems();
    }

    @Override
    public List<String> addStudent(String student) throws RemoteException {
        Controller.addToList(student);
        return Controller.getAllItems();
    }

    @Override
    public List<String> deleteStudents(String student) throws RemoteException {
        Controller.removeFromList(student);
        return Controller.getAllItems();
    }

}
