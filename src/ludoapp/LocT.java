/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludoapp;

/**
 *
 * @author Abdurrahman
 */
public class LocT implements java.io.Serializable{
    int playerNum;
    int locNum;
    int pieceNum;
    
    //Bi yerden bi yere piyon taşımak için kullanılacak Obje
    public LocT(int playerNum, int locNum, int pnum) {
        this.playerNum = playerNum;
        this.locNum = locNum;
        this.pieceNum = pnum;
    }
    
}
