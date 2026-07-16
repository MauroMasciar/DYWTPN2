package controller;

import ui.AddGame;
import ui.Window;

public class AddGameController {
    private AddGame view;
    public AddGameController(Window window) {
        view = new AddGame(window, this, true);  

        loadCategories();
        loadLibraries();
        loadPlatforms();
        
        view.pack();
        view.setVisible(true);
    }

    public void loadCategories() {

    }

    public void loadLibraries() {

    }

    public void loadPlatforms() {

    }

    public void saveData() {
        /*if(Validations.isEmpty(txtReleaseDate)) txtReleaseDate.setText("1900-01-01");
        if(Validations.isEmpty(txtGenre)) txtGenre.setText("N/A");
        if(Validations.isEmpty(txtDeveloper)) txtDeveloper.setText("N/A");
        if(Validations.isEmpty(txtPublisher)) txtPublisher.setText("N/A");
        if(Validations.isEmpty(txtSeries)) txtSeries.setText("N/A");
        if(Validations.isEmpty(txtStatus)) txtStatus.setText("N/A");
        if(Validations.isEmpty(txtSource)) txtSource.setText("N/A");
        if(Validations.isEmpty(txtPlayMode)) txtPlayMode.setText("N/A");
        if(Validations.isEmpty(txtVersion)) txtVersion.setText("N/A");
        if(Validations.isEmpty(txtRegion)) txtRegion.setText("N/A");
        if(Validations.isEmpty(txtPath)) txtPath.setText("N/A");
        if(Validations.isEmpty(txtCompletedDate)) txtCompletedDate.setText("1900-01-01");
        if(Validations.isEmpty(txtLastPlayed)) txtLastPlayed.setText("1900-01-01");
        if(Validations.isEmpty(txtaNotes)) txtaNotes.setText(" ");

        String completed = "0", ghost = "0";
        int hide = 0, favorite = 0, statistic = 0, portable = 0;
        

        if(chFavorite.isSelected()) favorite = 1;
        if(chCompleted.isSelected()) completed = "1";
        if(chStatistic.isSelected()) statistic = 1;
        if(chGhost.isSelected()) ghost = "1";
        if(chPortable.isSelected()) portable = 1;
        if(chHide.isSelected()) hide = 1;

        //name = name.replace("'", "");
        //name = name.replace("\"", "");
        
        if(Validations.isEmpty(txtGameName)) {
            JOptionPane.showMessageDialog(this, "Debes al menos ingresar el nombre", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            
        }*/
    }
}
