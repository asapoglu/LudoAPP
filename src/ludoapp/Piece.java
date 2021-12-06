/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludoapp;

import javafx.scene.image.ImageView;

/**
 *
 * @author Abdurrahman
 */
public class Piece {

    
    ImageView piece;
    boolean control;
    int location;
    int PieceNum;
    int engagement;
    int engagementClear;
    double firstX;
    double firstY;

    public Piece(ImageView piece, int pN, int eg) {
        this.piece = piece;
        this.control = false;
        this.location = 0;
        this.PieceNum = pN;
        this.engagement = eg;
        this.engagementClear = eg;
    }

}
