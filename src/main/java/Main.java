import java.awt.*;
import jade.Window;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting application...");
        Window window = Window.get();
        System.out.println("Window instance created");
        window.run();
        System.out.println("Window run() completed");
    }
}
