package TPClasse;

public enum Couleur {
    Rouge("R"), Vert("V"), Bleu("B"), Jaune("J"), Noir("N");

    String code;

    Couleur(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    static Couleur getCouleurDefault(){
        return Noir;
    }

    static Couleur getCouleurByCode(String name){
        switch (name){
            case "R":
                return Rouge;
            case "V":
                return Vert;
            case "B":
                return Bleu;
            case "J":
                return Jaune;
            default:
                return Noir;
        }
    }
}
