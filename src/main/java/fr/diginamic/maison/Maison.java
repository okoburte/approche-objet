package fr.diginamic.maison;

public class Maison {
    Piece[] pieces;

    public Maison(){
        pieces = new Piece[0];
    }

    public Maison(Piece[] pieces){
        this.pieces = pieces;
    }

    public void ajouterPiece(Piece piece) throws Exception{
        if(piece == null) throw new Exception("Impossible d'ajouter une piece null.");

        Piece[] newPieces = new Piece[pieces.length + 1];
        for (int i = 0; i < pieces.length; i++) {
            newPieces[i] = pieces[i];
        }
        newPieces[newPieces.length - 1] = piece;
        pieces = newPieces;
    }

    public int getNumberPieceOf(Class<? extends Piece> pieceType){
        int sommes = 0;
        for(Piece piece:pieces){
            if(pieceType.isInstance(piece)) sommes += 1;
        }
        return sommes;
    }

    public double getSuperficie(){
        return getSuperficie(-1, Piece.class);
    }

    public double getSuperficie(int etage){
        return getSuperficie(etage, Piece.class);
    }

    public double getSuperficie(Class<? extends Piece> pieceType){
        return getSuperficie(-1, pieceType);
    }

    public double getSuperficie(int etage, Class<? extends Piece> pieceType){
        double totalSuperficie = 0;
        for(Piece piece:pieces){
            if(etage == -1 && pieceType.isInstance(piece)) totalSuperficie += piece.getSuperficie();
            else if (etage == piece.getEtage() && pieceType.isInstance(piece)) totalSuperficie += piece.getSuperficie();
        }
        return totalSuperficie;
    }
}
