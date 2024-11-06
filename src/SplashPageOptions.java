import java.util.Scanner;

public class SplashPageOptions {

    public void displayTitle(){
        System.out.print(
            Colors.RED + 
        "                                                                            \n" +    
        "██████   █████  ████████ ████████ ██      ███████ ███████ ██   ██ ██ ██████ \n" + 
        "██   ██ ██   ██    ██       ██    ██      ██      ██      ██   ██ ██ ██   ██\n" +
        "██████  ███████    ██       ██    ██      █████   ███████ ███████ ██ ██████ \n" +
        "██   ██ ██   ██    ██       ██    ██      ██           ██ ██   ██ ██ ██     \n" + 
        "██████  ██   ██    ██       ██    ███████ ███████ ███████ ██   ██ ██ ██     \n" +
        Colors.RESET + 
        "\n"
        );
    }

    public void displayBattleshipArt() {
        System.out.print(
    "                                                                            \n" + 
    "                                       # #  ( )                             \n" +
    "                                    ___#_#___|__                            \n" +
    "                                _  |____________|  _                        \n" +            
    "                         _=====| | |            | | |==== _                 \n" +            
    "                   =====| |.---------------------------. | |====            \n" +            
    "     <--------------------'   .  .  .  .  .  .  .  .   '--------------/     \n" +            
    "       \\                                                             /     \n" +            
    "        \\_____________________________BATTLESHIP____________________/      \n" + 
    Colors.BLUE +           
    "    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww   \n" +            
    "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwWWWW\n" +            
    "    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww     \n" +
    Colors.RESET +            
    "\n");
    }

    public static void displayShipSunk() {
        System.out.print(
    Colors.RED +
    "                                      ___                                   \n" +
    "                              __,-~~/~    `---.                             \n" +
    "                            _/_,---(      ,    )                            \n" +
    "                        __ /        <    /   )  \\___                       \n" +
    "         - ------===;;;'====------------------===;;;===----- -  -           \n" +
    "                           \\/  ~\"~\"~\"~\"~\"~\\~\"~)~\"/                 \n" +
    "                           (_ (   \\  (     >    \\)                        \n" +
    "                            \\_( _ <         >_>'                           \n" +
    "                               ~ `-i' ::>|--\"                              \n" +
    "                                   I;|.|.|                                  \n" +       
    "     <--------------------'   .  . I;|.|.|.  .  .  .   '--------------/     \n" +            
    "       \\                         <|i::|i|`.                          /     \n" +            
    "        \\_______________________(` ^'\\\"`-' \\\")__________________/      \n" + Colors.BLUE +  "\n" +         
    "    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww   \n" +            
    "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww \n" +            
    "    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww     \n" + 
    Colors.RESET +           
    "\n");
    }

    public void displayGameOptions() {
        System.out.println(
            "\n" +
            "To get started, choose one of the following options:\n" +
            "\n" +
            "1. Start One Player Game \n" +
            "2. Start Two Player Game      \n" +
            "3. Tutorial          \n" +
            "4. Exit                   \n" +
            "\n"
        );
    }

    public void startScreen(){
        displayTitle();
        displayBattleshipArt();
        //will delay the print of the game opptions so the player can see the title
        ConsoleHelper.delayPrint(2);

        displayGameOptions();
    }


}