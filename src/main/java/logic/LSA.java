package logic;

import javafx.scene.robot.Robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LSA {

    private List<LSAnode> list; //used to store LSA;

    private List<Boolean> boolList; //used for Xs;

    public LSA(){
        list = new ArrayList<>();
        boolList = new ArrayList<>();
    }

    public void updateThis(String LSAnorm){

        List<LSAnode> temp = new ArrayList<>();

        for (int i = 0; i < LSAnorm.length(); i++){
            char c = LSAnorm.charAt(i);
            LSAnode tempNode;
            switch (c) {
                case 'U':
                case 'Y':
                case 'X':
                case 'D':
                    int number = 0;
                    if(Character.isDigit(LSAnorm.charAt(i+1))){
                        number = (int) LSAnorm.charAt(i + 1) - 48;
                    }
                    tempNode = new LSAnode("" + c, number, LSAnorm.substring(i,i+2));
                    temp.add(tempNode);
                    i++;
                    continue;
                case 'W':
                    tempNode = new LSAnode("" + c, 0, "" + c);
                    temp.add(tempNode);
                    continue;
                default:
                    break;
            }
        }

        list = temp;

    }

    public String getResultAutomatic() {

        LSAnode current;
        String result = "";
        boolean lastBool = false;

        for (int i = 0; i < list.size(); i++) {
            current = list.get(i);
            switch (current.getType()) {
                case "X":
                    lastBool = boolList.get(current.getSpecialAddress());
                    System.out.println(current.getContents() + " = " + boolList.get(current.getSpecialAddress()));
                    continue;
                case "Y":
                    result += current.getContents();
                    System.out.println(current.getContents());
                    if (current.getContents().equals("Yk")){
                        break;
                    }
                    continue;
                case "W":
                case "D":
                    System.out.println(current.getContents());
                    continue;
                case "U":
                    if (list.get(i - 1).getType().equals("W") || !lastBool ||list.get(i - 1).getType().equals("Y")) {

                        i = findD(current.getSpecialAddress());
                        System.out.println(current.getContents() + " go to  " + list.get(i).getContents());
                    } else {
                        continue;
                    }
                    continue;
                default:
                    break;
            }
        }
        return result;
    }

    public String getNextStepForLabyrinth(boolean[] bools) {

        LSAnode current;
        String result = "";
        boolean lastBool = false;

        for (int i = 0; i < list.size(); i++) {
            current = list.get(i);
            switch (current.getType()) {
                case "X":
                    lastBool = bools[current.getSpecialAddress()];
                    continue;
                case "Y":
                    if (current.getContents().equals("Yn")){
                        break;
                    }
                    if (current.getContents().equals("Yk")){
                        break;
                    }
                    result += current.getSpecialAddress();
                    continue;
                case "W":
                case "D":
                    continue;
                case "U":
                    if (current.getContents().equals("U1")) {
                         break;
                    } else if(list.get(i - 1).getType().equals("W") || !lastBool ||list.get(i - 1).getType().equals("Y")){
                        i = findD(current.getSpecialAddress());
                    }
                    else{
                        continue;
                    }
                default:
                    break;
            }
        }
        System.out.println(result);
        return result;
    }

    public List<RobotCoords> getPathThroughLabyrinth(String[][] labyrinth) {

        updateThis("YnD1X3U3D2Y3Y2U6WD3X2U5D4Y2U6WD5Y1U6WD6X4U1D7Yk");

        List<RobotCoords> path = new ArrayList<>();

        Point current = getStart(labyrinth);
        Point forward = new Point(current.getX(), current.getY() - 1);

        path.add(new RobotCoords(current,forward));

        boolean[] booleans = getBoolsLabyrinth(forward,current,labyrinth);

        String currentTODO;
        while (!labyrinth[current.getY()][current.getX()].equals("F")) {

            System.out.println(current  + " " + labyrinth[current.getY()][current.getX()] + " looking at " + forward + " " + labyrinth[forward.getY()][forward.getX()]);
            currentTODO = getNextStepForLabyrinth(booleans);

            for (int i = 0; i < currentTODO.length(); i++) {
                char c = currentTODO.charAt(i);
                switch (c) {
                    case '1':
                        forward = current.leftFromRotation(forward);
                        booleans = getBoolsLabyrinth(forward,current,labyrinth);
                        continue;
                    case '2':
                        int xadd = forward.getX() - current.getX();
                        int yadd = forward.getY() - current.getY() ;
                        current = new Point(forward.getX(), forward.getY());
                        forward = new Point(
                                current.getX() + xadd,
                                current.getY() + yadd
                        );
                        path.add(new RobotCoords(current,forward));
                        booleans = getBoolsLabyrinth(forward,current,labyrinth);
                        continue;
                    case '3':
                        forward = current.rightFromRotation(forward);
                        booleans = getBoolsLabyrinth(forward,current,labyrinth);
                        continue;
                    default:
                        continue;
                }

            }
        }
        return path;
    }



    /* Note to self:
        S - Start tile
        F - Finish tile
        E - Empty tile
        W - Wall tile
     */

    private Point getStart(String[][] labyrinth){

        Point startPoint = new Point();

        for(int y = 0; y < labyrinth.length; y++){
            for(int x = 0; x < labyrinth[0].length; x++){
                if(labyrinth[y][x].equals("S")){
                    startPoint = new Point(x,y);

                    return startPoint;
                }
            }
        }
        return startPoint;
    }

    public boolean[] getBoolsLabyrinth(Point forward, Point current, String[][] labyrinth){
        boolean[] booleans = new boolean[5];
            if(!labyrinth[forward.getY()][forward.getX()].equals("W")) {
                booleans[2] = true;
            }
            if(!labyrinth[current.leftFromRotation(forward).getY()][current.leftFromRotation(forward).getX()].equals("W")) {
                booleans[1] = true;
            }
            if(!labyrinth[current.rightFromRotation(forward).getY()][current.rightFromRotation(forward).getX()].equals("W")) {
                booleans[3] = true;
            }
            if(!labyrinth[current.getY()][current.getX()].equals("F")){
                booleans[4] = true;
            }
        return booleans;
    }


    private int findD(int address){
        int adr = 0;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getSpecialAddress() == address && list.get(i).getType().equals("D")){
                adr = i;
            }
        }

        return adr;
    }

    public void addNodeDEBUG(LSAnode node){
        list.add(node);
    }

    public void addBoolList(List<Boolean> newL){
        boolList = newL;
    }


    public void printLSAdebug(){
        String lsaPrinted = "";

        for(int i = 0; i < list.size(); i++){
            lsaPrinted += list.get(i).getContents() + "( " + list.get(i).getSpecialAddress() + " )";
        }

        System.out.println(lsaPrinted);
    }
}