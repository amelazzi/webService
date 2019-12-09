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
        //Notification notification = notificationService.findOneById(10L);
        //notification.setMessage("Im update");
        //notification.setRead(true);
        //notificationService.deleteAll();
        testAdd();
        displayMany(notificationService.findAll());
    }

    public static void testAdd(){
        Notification notification = new Notification();
        notification.setMessage("new Notification");
        notification.setDemande(demandeService.findOneById(4L));

        Notification notification2 = new Notification();
        notification2.setMessage("Second new Notification");
        notification2.setDemande(demandeService.findOneById(3L));

        Notification notification3 = new Notification();
        notification3.setMessage("your demande is ready");
        notification3.setDemande(demandeService.findOneById(5L));

        notificationService.add(notification);
        notificationService.add(notification2);
        notificationService.add(notification3);
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
