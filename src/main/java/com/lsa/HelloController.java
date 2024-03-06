package com.lsa;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;

public class HelloController {
    public GridPane gridMap;

    @FXML
    protected void onHelloButtonClick() {

        ImageView wall = new ImageView("/wall.png");
        ImageView empty = new ImageView("/empty.png");
        ImageView arr = new ImageView(new Image("/robot.png"));
        ImageView finish = new ImageView("/finish.png");
        ImageView start = new ImageView(new Image("/start.png"));

        int test = 64;

        wall.resize(test, test);
        empty.resize(test,test);
        arr.resize(test,test);
        start.resize(test,test);
        finish.resize(test,test);

        //column.setPercentWidth(100.0/test);
        //row.setPercentHeight(100.0/test);

        gridMap.getChildren().clear();

        String[][] labyrinthTEST1 = {
                {"W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W"},
                {"W","F","W","E","E","E","E","E","W","E","E","E","E","E","E","E","E","E","E","E","W"},
                {"W","E","W","E","W","W","W","E","E","E","W","W","W","W","W","W","W","E","W","E","W"},
                {"W","E","W","E","W","W","W","W","W","E","W","E","W","W","E","E","W","E","W","E","W"},
                {"W","E","W","E","W","E","E","W","W","E","E","E","E","E","E","W","W","E","W","E","W"},
                {"W","E","W","E","W","E","W","E","W","E","W","W","E","W","W","W","W","E","W","E","W"},
                {"W","E","E","E","E","E","W","E","E","E","W","W","E","E","W","W","W","S","W","E","W"},
                {"W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W"}
        };


        for (int i = 0; i < labyrinthTEST1.length; i++) {
            for (int y = 0; y < labyrinthTEST1[0].length; y++) {
                ImageView temp;
                switch (labyrinthTEST1[i][y]){
                    case "E":
                        temp = new ImageView(empty.getImage());
                        temp.resize(test,test);
                        gridMap.add(temp, y, i, 1, 1);
                        continue;
                    case "F":
                        temp = new ImageView(finish.getImage());
                        temp.resize(test,test);
                        gridMap.add(temp, y, i, 1, 1);
                        continue;
                    case "S":
                        temp = new ImageView(start.getImage());
                        temp.resize(test,test);
                        gridMap.add(temp, y, i, 1, 1);
                        continue;
                    case "W":
                        temp = new ImageView(wall.getImage());
                        temp.resize(test,test);
                        gridMap.add(temp, y, i, 1, 1);
                }
            }
        }
    }
}