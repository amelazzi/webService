package test;

import com.server.entities.impl.Comment;
import com.server.entities.impl.Emprunt;
import com.server.service.impl.CommentService;
import com.server.service.impl.ProductService;
import com.server.service.impl.UserService;

import java.rmi.RemoteException;
import java.util.List;

public class TestComment {

    static CommentService commentService = new CommentService();
    static UserService userService = new UserService();
    static ProductService productService = new ProductService();

    public static void main(String[] args) throws RemoteException {
        //testAdd();
        Comment comment = commentService.findOneById(3L);
        //comment.setContent("third comment updated");
        commentService.delete(comment);
        displayMany(commentService.findAll());
    }

    public static void testAdd(){
        Comment c = new Comment();
        c.setContent("first comment");
        c.setProduct(productService.findOneById(6L));
        c.setUser(userService.findOneById(1L));

        Comment c1 = new Comment();
        c1.setContent("second comment");
        c1.setProduct(productService.findOneById(6L));
        c1.setUser(userService.findOneById(2L));

        Comment c2 = new Comment();
        c2.setContent("second comment");
        c2.setProduct(productService.findOneById(9L));
        c2.setUser(userService.findOneById(3L));

        commentService.add(c);
        commentService.add(c1);
        commentService.add(c2);
    }



    public static void displayOne(Comment comment) {
        System.out.println("Comment :");
        System.out.println("-" + comment.toString());
    }

    public static void displayMany(List<Comment> listComments) {
        System.out.println("Comment list :");
        for (Comment d : listComments) {
            System.out.println(d.toString());
        }
    }
}
