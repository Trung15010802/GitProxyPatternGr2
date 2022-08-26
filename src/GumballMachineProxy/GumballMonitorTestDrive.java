package GumballMachineProxy;

import java.net.MalformedURLException;
import java.rmi.*;

public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        String[] location = { "rmi://localhost/gumballmachine" };
        GumballMonitor[] monitors = new GumballMonitor[location.length];
        for (int i = 0; i < monitors.length; i++) {
            try {
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
                monitors[i] = new GumballMonitor(machine);
                System.out.println(monitors[i]);
            } catch (MalformedURLException | RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < monitors.length; i++) {
            monitors[i].report();   
        }
    }
}
