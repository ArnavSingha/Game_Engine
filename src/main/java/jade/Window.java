package jade;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;

import static org.lwjgl.glfw.GLFW.*;

public class Window {
    private int width, height;
    private String title;

    private static Window window = null;

    private Window(){
        this.width = 1920;
        this.height = 1000;
        this.title = "Mario";
    }

    public static Window get(){
        if (Window.window == null){
            Window.window = new Window();
        }
        return Window.window;
    }

    public void run(){
        System.out.println("hello" + Version.getVersion() + "!" );

        init();
        loop();
    }

    public void init(){
//         Setup error callback
        GLFWErrorCallback.createPrint(System.err).set();

//        Initilize GLFW
        if (!glfwInit()){
            throw new IllegalStateException("unable to initialize GLFW");
        }
//        Configer GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE,GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE,GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED,GLFW_TRUE);

    }

    public void loop(){

    }
}
