package logic;

public class Manager {

    LSA currentLSA;

    int mode;

    String[][] currentMap;

    public Manager(){
        currentLSA = new LSA();
    }

    private void checkForMap(){
        //if successful, update currentMap, if not - return err
    }

    private void manageMode(int mode){
        this.mode = mode;
    }
}
