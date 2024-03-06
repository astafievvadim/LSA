package com.lsa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;
import logic.LSA;
import logic.LSAnode;
import logic.Point;
import logic.RobotCoords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();

        LSA lsa = new LSA();

        String[][] labyrinthTEST1 = {
                {"W", "W", "W", "W", "W", "W", "W", "W"},
                {"W", "W", "F", "W", "E", "E", "E", "W"},
                {"W", "E", "E", "W", "E", "W", "E", "W"},
                {"W", "E", "W", "W", "E", "W", "W", "W"},
                {"W", "E", "E", "E", "E", "E", "S", "W"},
                {"W", "W", "W", "W", "W", "W", "W", "W"}
        };

        String[][] labyrinthTEST2 = {
                {"W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W"},
                {"W","F","W","E","E","E","E","E","W","E","E","E","E","E","E","E","E","E","E","E","W"},
                {"W","E","W","E","W","W","W","E","E","E","W","W","W","W","W","W","W","E","W","E","W"},
                {"W","E","W","E","W","W","W","W","W","E","W","E","W","W","E","E","W","E","W","E","W"},
                {"W","E","W","E","W","E","E","W","W","E","E","E","E","E","E","W","W","E","W","E","W"},
                {"W","E","W","E","W","E","W","E","W","E","W","W","E","W","W","W","W","E","W","E","W"},
                {"W","E","E","E","E","E","W","E","E","E","W","W","E","E","W","W","W","S","W","E","W"},
                {"W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W"}
        };
        List<RobotCoords> path = lsa.getPathThroughLabyrinth(labyrinthTEST2);
        System.out.println(Arrays.toString(new List[]{path}));
    }
}

/*

        List<Boolean> listTest = new ArrayList<>();

        listTest.add(true); // x0 = x1
        listTest.add(true); // x1 = x2 == 1
        listTest.add(true); // x2 = x3 == 0
        listTest.add(true); // x3 = x4

        //lsa.updateThis("YnD1X0U1X1U4D2Y1Y5Y4WU3D4X2U5X3U2Y1Y2Y3WU3D5X3U3Y3D3YK");
        //lsa.updateThis("YnD1X2U3D2Y3Y1U6WD3X1U5D4Y1U6WD5Y2U6WD6X3U1D7Yk");

        //lsa.addBoolList(listTest);

        //lsa.printLSAdebug();

        String[][] labyrinthTEST = {
                {"W", "W", "W", "W", "W"},
                {"W", "E", "E", "F", "W"},
                {"W", "E", "W", "W", "W"},
                {"W", "E", "W", "W", "W"},
                {"W", "E", "E", "S", "W"},
                {"W", "W", "W", "W", "W"}
        };

        String[][] labyrinthTEST = {
                {"W", "W", "W", "W"},
                {"W", "F", "W", "W"},
                {"W", "S", "W", "W"},
                {"W", "W", "W", "W"}
        };

        LSAnode YN = new LSAnode("Y", 0, "Yn");
        LSAnode D1 = new LSAnode("D", 1, "D1");
        LSAnode X0 = new LSAnode("X", 0, "X0");
        LSAnode U1 = new LSAnode("U", 1, "U1");
        LSAnode X1 = new LSAnode("X", 1, "X1");
        LSAnode U4 = new LSAnode("U", 4, "U4");
        LSAnode D2 = new LSAnode("D", 2, "D2");
        LSAnode Y1 = new LSAnode("Y", 1, "Y1");
        LSAnode Y5 = new LSAnode("Y", 5, "Y5");
        LSAnode Y4 = new LSAnode("Y", 4, "Y4");
        LSAnode W = new LSAnode("W", 0, "W");
        LSAnode U3 = new LSAnode("U", 3, "U3");
        LSAnode D4 = new LSAnode("D", 4, "D4");
        LSAnode X2 = new LSAnode("X", 2, "X2");
        LSAnode U5 = new LSAnode("U", 5, "U5");
        LSAnode X3 = new LSAnode("X", 3, "X3");
        LSAnode U2 = new LSAnode("U", 2, "U2");
        // ++ Y1
        LSAnode Y2 = new LSAnode("Y", 2, "Y2");
        LSAnode Y3 = new LSAnode("Y", 3, "Y3");
        // ++ W
        // ++ U3
        LSAnode D5 = new LSAnode("D", 5, "D5");
        // ++ X3
        // ++ U3
        // ++ Y3
        LSAnode D3 = new LSAnode("D", 3, "D3");
        LSAnode YK = new LSAnode("Y", 0, "Yk");

        lsa.addNodeDEBUG(YN);
        lsa.addNodeDEBUG(D1);
        lsa.addNodeDEBUG(X0);
        lsa.addNodeDEBUG(U1);
        lsa.addNodeDEBUG(X1);
        lsa.addNodeDEBUG(U4);
        lsa.addNodeDEBUG(D2);
        lsa.addNodeDEBUG(Y1);
        lsa.addNodeDEBUG(Y5);
        lsa.addNodeDEBUG(Y4);
        lsa.addNodeDEBUG(W);
        lsa.addNodeDEBUG(U3);
        lsa.addNodeDEBUG(D4);
        lsa.addNodeDEBUG(X2);
        lsa.addNodeDEBUG(U5);
        lsa.addNodeDEBUG(X3);
        lsa.addNodeDEBUG(U2);
        lsa.addNodeDEBUG(Y1);
        lsa.addNodeDEBUG(Y2);
        lsa.addNodeDEBUG(Y3);
        lsa.addNodeDEBUG(W);
        lsa.addNodeDEBUG(U3);
        lsa.addNodeDEBUG(D5);
        lsa.addNodeDEBUG(X3);
        lsa.addNodeDEBUG(U3);
        lsa.addNodeDEBUG(Y3);
        lsa.addNodeDEBUG(D3);
        lsa.addNodeDEBUG(YK);
*/
