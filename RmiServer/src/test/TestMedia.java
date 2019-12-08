package test;

import com.server.entities.impl.Media;
import com.server.service.impl.MediaService;
import com.server.service.impl.ProductService;

import java.io.File;
import java.rmi.RemoteException;
import java.util.List;

public class TestMedia {

    public static MediaService mediaService = new MediaService();
    public static ProductService productService = new ProductService();

    public static void main(String[] args) throws RemoteException {
        Media image = new Media();
        image.setIdMedia(1L);
        image.setImage(new File("/Users/macos/Desktop/Upem/Service_Web_REST/webService/RmiServer/src/resources/test.png"));
        image.setName("test");
        image.setProduct(productService.findOneById(6L));

        mediaService.add(image);
    }

    public static void displayOne(Media media) {
        System.out.println("Product :");
        System.out.println("-" + media.toString());
    }

    public static void displayMany(List<Media> listProducts) {
        System.out.println("Product list :");
        for (Media m : listProducts) {
            System.out.println(m.toString());
        }
    }
}
