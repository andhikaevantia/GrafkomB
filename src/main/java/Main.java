import Engine.Object;
import Engine.ShaderProgram;
import Engine.Sphere;
import Engine.Window;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
        new Window(600,600,
                "Hello World");
    ArrayList<Object> objects
            = new ArrayList<>();
    ArrayList<Object> objectsRectangle
            = new ArrayList<>();

    ArrayList<Object> objectsPointsControl = new ArrayList<>();
    public void init(){
        window.init();
        GL.createCapabilities();

        //code
//        objects.add(new Object2d(
//            Arrays.asList(
//                new ShaderProgram.ShaderModuleData(
//                        "resources/shaders/scene.vert"
//                        , GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData(
//                        "resources/shaders/scene.frag"
//                        , GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(
//                List.of(
//                    new Vector3f(0.0f,0.5f,0.0f),
//                    new Vector3f(-0.5f,-0.5f,0.0f),
//                    new Vector3f(0.5f,-0.5f,0.0f)
//                )
//            ),
//            new Vector4f(0.0f,1.0f,1.0f,1.0f)
//        ));
//        objects.add(new Object2d(
//            Arrays.asList(
//                new ShaderProgram.ShaderModuleData(
//                        "resources/shaders/sceneWithVerticesColor.vert"
//                        , GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData(
//                        "resources/shaders/sceneWithVerticesColor.frag"
//                        , GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(
//                List.of(
//                        new Vector3f(0.0f,0.5f,0.0f),
//                        new Vector3f(-0.5f,-0.5f,0.0f),
//                        new Vector3f(0.5f,-0.5f,0.0f)
//                )
//            ),
//            new ArrayList<>(
//                List.of(
//                    new Vector3f(1.0f,0.0f,0.0f),
//                    new Vector3f(0.0f,1.0f,0.0f),
//                    new Vector3f(0.0f,0.0f,1.0f)
//                )
//            )
//        ));
//        objectsRectangle.add(new Rectangle(
//            Arrays.asList(
//                new ShaderProgram.ShaderModuleData(
//                        "resources/shaders/scene.vert"
//                        , GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData(
//                        "resources/shaders/scene.frag"
//                        , GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(
//                List.of(
//                    new Vector3f(0.0f,0.0f,0.0f),
//                    new Vector3f(0.5f,0.0f,0.0f),
//                    new Vector3f(0.0f,0.5f,0.0f),
//                    new Vector3f( 0.5f,0.5f,0.0f)
//                )
//            ),
//            new Vector4f(0.0f,1.0f,1.0f,1.0f),
//            Arrays.asList(0,1,2,1,2,3)
//        ));
//        objectsPointsControl.add(new Object2d(
//            Arrays.asList(
//                new ShaderProgram.ShaderModuleData(
//                        "resources/shaders/scene.vert"
//                        , GL_VERTEX_SHADER),
//                new ShaderProgram.ShaderModuleData(
//                        "resources/shaders/scene.frag"
//                        , GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(),
//            new Vector4f(0.0f,1.0f,1.0f,1.0f)
//        ));
        objects.add(new Sphere(
            Arrays.asList(
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.vert"
                        , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData(
                        "resources/shaders/scene.frag"
                        , GL_FRAGMENT_SHADER)
            ),
            new ArrayList<>(
                List.of(
                    new Vector3f(-0.5f,0.5f,0.0f),
                    new Vector3f(-0.5f,-0.5f,0.0f),
                    new Vector3f(0.5f,-0.5f,0.0f),
                    new Vector3f(0.5f,0.5f,0.0f)
                )
            ),
            new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.125f,
                0.125f,
                0.125f
        ));
//        objects.get(0).translateObject(0.5f,0.0f,0.0f);
        objects.get(0).scaleObject(2.0f,2.0f,2.0f);
    }
    public void input(){
        if (window.isKeyPressed(GLFW_KEY_W)) {
            objects.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
        }
        if(window.getMouseInput().isLeftButtonPressed()){
            Vector2f pos = window.getMouseInput().getCurrentPos();
            //System.out.println("x : "+pos.x+" y : "+pos.y);
            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);
            //System.out.println("x : "+pos.x+" y : "+pos.y);
            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))){
                System.out.println("x : "+pos.x+" y : "+pos.y);
                //objectsPointsControl.get(0).addVertices(new Vector3f(pos.x,pos.y,0));
            }

        }

    }
    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            GL.createCapabilities();
            input();
            //code
            //..
            for(Object object:objects){
                object.draw();
            }
//            for(Object2d object:objectsRectangle){
//                object.draw();
//            }
//            for(Object2d object:objectsPointsControl){
//                object.drawLine();
//            }
            // Restore state
            glDisableVertexAttribArray(0);
            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }
    public void run() {

        init();
        loop();

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}