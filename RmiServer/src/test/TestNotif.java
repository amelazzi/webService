package test;

import com.server.entities.impl.Comment;
import com.server.entities.impl.Notification;
import com.server.service.impl.DemandeService;
import com.server.service.impl.NotificationService;
import com.server.service.interfaces.INotificationService;

import java.rmi.RemoteException;
import java.util.List;

public class TestNotif {

    static NotificationService notificationService = new NotificationService();
    static DemandeService demandeService = new DemandeService();

    public static void main(String[] args) throws RemoteException {
        displayMany(notificationService.findAll());
        displayMany(notificationService.findBy("iddemande", 2L));
        displayOne(notificationService.findOneById(1L));
    }


    public static void displayOne(Notification notif) {
        System.out.println("Comment :");
        System.out.println("-" + notif.toString());
    }

    public static void displayMany(List<Notification> listNotifs) {
        System.out.println("Comment list :");
        for (Notification notif : listNotifs) {
            System.out.println(notif.toString());
        }
    }
}
