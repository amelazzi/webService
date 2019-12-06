package test;

import com.server.entities.impl.Rate;
import com.server.service.impl.RateService;

import java.rmi.RemoteException;
import java.util.List;

public class TestRate {
    static RateService rateService = new RateService();
    public static void main(String[] args) throws RemoteException {
        displayMany(rateService.findAll());
        displayMany(rateService.findBy("idproduct", 6L));
        displayOne(rateService.findOneById(3L));

    }

    public static void displayOne(Rate rate) {
        System.out.println("Demande :");
        System.out.println("-" + rate.toString());
    }

    public static void displayMany(List<Rate> listDemandes) {
        System.out.println("Demande list :");
        for (Rate d : listDemandes) {
            System.out.println("-" + d.toString());
        }
    }
}
