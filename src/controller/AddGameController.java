package controller;


import ui.AddGame;
import ui.Window;

public class AddGameController {
    private AddGame view;
    public AddGameController(Window window) {
        view = new AddGame(window, this, true);  
        
        view.setVisible(true);
    }

    public void saveData() {
        System.out.println("save data");
    }
}
