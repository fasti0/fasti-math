package pl.fasti.math.configuration;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Header;

import java.util.ArrayList;
import java.util.List;

@Header("Permisja: fasti.math")
public class Configuration extends OkaeriConfig {

    public int seconds = 30;
    public boolean automaticTaskDraw = true;
    public int minAddition = 300;
    public int maxAddition = 100;
    public int minDivision = 60;
    public int maxDivision = 20;
    public int minMultiplication = 10;
    public int maxMultiplication = 15;
    public int minSubtract = 300;
    public int maxSubtract = 100;
    public String messageCommandUsage = "&7Prawidlowe uzycie &f/math <draw>";
    public String messageCommandDraw = "&aPomyslnie wylosowano nowe dzialanie!";
    public List<String> messageChatDrawMath = new ArrayList<String>() {{
        add("");
        add("&3&lMATEMATYKA...");
        add("&fRozwiaz dzialanie &a{OPERATION} &f= &a?");
        add("&fOdpowiedz napisz na &3czacie!");
        add("");
    }};
    public String messageChatWinner = "&2&lGRATULACJE... &fGracz &a{PLAYER} &frozwiazal dzialanie! &a(Poprawny wynik to {RESULT})";
    public String commandExecute = "say {PLAYER} brawo!";
}
