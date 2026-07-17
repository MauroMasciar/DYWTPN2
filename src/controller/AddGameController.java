package controller;

import app.Main;
import model.Categories;
import model.Libraries;
import model.Platforms;
import service.AddGameService;
import ui.AddGame;
import ui.Window;
import util.Utils;

public class AddGameController {
    private AddGame view;
    private AddGameService addGameService;
    public AddGameController(Window window) {
        view = new AddGame(window, this, true);
        addGameService = new AddGameService(view);

        loadCategories();
        loadLibraries();
        loadPlatforms();

        view.pack();

        view.showPopupCompletedDateListener(e -> showPopupCompletedDate());
        view.showPopupReleaseDateListener(e -> showPopupReleaseDate());
        view.setBtnSaveListener(e -> addGameService.saveData());
        view.setSpinGameTimeListener(e -> setSpinGameTimer());
        
        view.setVisible(true);
    }

    public void loadCategories() {
        for(Categories category : Main.categoryRepository.categories_list) {
            view.fillComboBoxCategory(category.getName());
        }
    }

    public void loadLibraries() {
        for(Libraries library : Main.librariesRepository.library_list) {
            view.fillComboBoxLibrary(library.getName());
        }
    }

    public void loadPlatforms() {
        for(Platforms platforms : Main.platformsRepository.platforms_list) {
            view.filLComboBoxPlatform(platforms.getName());
        }
    }

    public void showPopupCompletedDate() {
        view.showPopupCompletedDate();
    }

    public void showPopupReleaseDate() {
        view.showPopupReleaseDate();
    }

    public void setSpinGameTimer() {
        String string = "(" + Utils.getTotalHoursFromSeconds(view.getSpinGameTimeValue(), true) + ")";
        view.setLblConvertedSeconds(string);
    }
}
