
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CRUDImpl extends UnicastRemoteObject implements CRUDInterface{
    CRUDInterface crud = (CRUDInterface) Naming.lookup("rmi://" + Config.IP_SERVER_2 + ":" + Config.PORT_SERVER + "/crud");
    protected CRUDImpl() throws RemoteException, MalformedURLException, NotBoundException {
    }

    @Override
    public List<String> getStudents(boolean isCallFromSever) throws RemoteException {
        return Controller.getAllItems();
    }

    @Override
    public List<String> addStudent(String student, boolean isCallFromSever) throws RemoteException {
        if (!isCallFromSever) crud.addStudent(student, false);
        Controller.addToList(student);
        return Controller.getAllItems();
    }

    @Override
    public List<String> deleteStudents(String student, boolean isCallFromSever) throws RemoteException {
        if (!isCallFromSever) crud.deleteStudents(student, false);
        Controller.removeFromList(student);
        return Controller.getAllItems();
    }

}
