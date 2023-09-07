package finalfantasy.api.enums;

public enum GameEdition {

    FINAL_FANTASY_I,
    FINAL_FANTASY_II,
    FINAL_FANTASY_III,
    FINAL_FANTASY_IV,
    FINAL_FANTASY_V,
    FINAL_FANTASY_VI,
    FINAL_FANTASY_VII,
    FINAL_FANTASY_VIII,
    FINAL_FANTASY_IX,
    FINAL_FANTASY_X,
    FINAL_FANTASY_X2,
    FINAL_FANTASY_XII,
    FINAL_FANTASY_XIII,
    FINAL_FANTASY_XIII_2,
    FINAL_FANTASY_XIII_LIGHTNING_RETURNS,
    FINAL_FANTASY_XV,
    FINAL_FANTASY_TACTICS,
    FINAL_FANTASY_DISSIDIA;


    public static GameEdition createGameEditionFromString(String title){
        GameEdition newGameEdition = GameEdition.valueOf(title);
        return newGameEdition;
    }
}

