package jade;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    private int width, height;
    private String title;
    private long glfwWindow;

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

//        Create the window

        glfwWindow = glfwCreateWindow(this.width,this.height,this.title,NULL,NULL);
        if (glfwWindow == NULL){
            throw new IllegalStateException("Failed to create the glfw window");
        }

//        Make OpenGl the context current
        glfwMakeContextCurrent(glfwWindow);
//        Enable v-sync
        glfwSwapInterval(1);

//        Make the window visible
        glfwShowWindow(glfwWindow);

        GL.createCapabilities();
    }

    public void loop() {
        while (!glfwWindowShouldClose(glfwWindow)) {
            glfwPollEvents();
            glClearColor(0.5f, 0.7f, 1.0f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT);
            glfwSwapBuffers(glfwWindow);
        }
    }
}
