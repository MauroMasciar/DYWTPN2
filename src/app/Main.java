package app;

import repository.GameRepository;
import ui.Window;

public class Main {
    public static GameRepository repository;

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Se inician los repositorios
        repository = new GameRepository();

        // Se inicia la ventana principal
        Window mw = new Window();
    }
}
