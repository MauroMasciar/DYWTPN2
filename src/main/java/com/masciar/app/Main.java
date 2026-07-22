/**
 * NewGame+
 *
 * Gestor de videojuegos de código abierto con estadísticas, historial de sesiones,
 * resúmenes y sincronización con el perfil en la web.
 *
 * Repositorio:
 * https://github.com/MauroMasciar/NewGamePlus
 *
 * Historial de versiones:
 * - v1.0 - Iniciada el 23 de octubre de 2023
 * - v2.0 - Iniciada el 13 de julio de 2026
 *
 * @author Mauro Masciadro
 * @version 2.0
 */

package com.masciar.app;

import com.masciar.repository.AchievementRepository;
import com.masciar.repository.CategoryRepository;
import com.masciar.repository.GameRepository;
import com.masciar.repository.HistoryRepository;
import com.masciar.repository.LibraryRepository;
import com.masciar.repository.PlatformsRepository;
import com.masciar.repository.PlayerRepository;
import com.masciar.service.TakeScreenshot;
import com.masciar.ui.Window;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;


public class Main {
    public static final String VERSION_APP = "2.0.0.22";
    public static PlayerRepository playerRepository;
    public static GameRepository gameRepository;
    public static CategoryRepository categoryRepository;
    public static LibraryRepository librariesRepository;
    public static PlatformsRepository platformsRepository;
    public static AchievementRepository achievementsRepository;
    public static HistoryRepository historyRepository;
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        // Se inician los repositorios
        playerRepository = new PlayerRepository();
        gameRepository = new GameRepository();
        categoryRepository = new CategoryRepository();
        librariesRepository = new LibraryRepository();
        platformsRepository = new PlatformsRepository();
        achievementsRepository = new AchievementRepository();
        historyRepository = new HistoryRepository();

        //TakeScreenshot takeScreenshot = new TakeScreenshot();

        // Se inicia la ventana principal
        Window mw = new Window();
    }
}
