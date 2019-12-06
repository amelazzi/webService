package test;

import com.server.entities.impl.Rate;
import com.server.service.impl.ProductService;
import com.server.service.impl.RateService;

import java.rmi.RemoteException;
import java.util.List;

public class TestRate {

    static RateService rateService = new RateService();
    static ProductService productService = new ProductService();

    public static void main(String[] args) throws RemoteException {
        /*displayMany(rateService.findAll());
        displayMany(rateService.findBy("idproduct", 6L));
        displayOne(rateService.findOneById(3L));
        testAdd();*/
        rateService.deleteAll();
        displayMany(rateService.findAll());
    }

    public static void testAdd(){
        Rate rate = new Rate();
        rate.setValue(2);
        rate.setProduct(productService.findOneById(12L));

        Rate rate1 = new Rate();
        rate1.setValue(3);
        rate1.setProduct(productService.findOneById(12L));

        Rate rate2 = new Rate();
        rate2.setValue(4);
        rate2.setProduct(productService.findOneById(10L));

        rateService.add(rate);
        rateService.add(rate1);
        rateService.add(rate2);

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
