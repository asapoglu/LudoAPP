/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludoapp;

import java.util.HashMap;
import javafx.scene.image.ImageView;

/**
 *
 * @author Abdurrahman
 */
public class PlayerP {

    public HashMap<Piece, HashMap> playerList = new HashMap<>();
    public HashMap<ImageView, Piece> playerImg = new HashMap<>();
    public HashMap<Integer, Piece> playerInt = new HashMap<>();
    public HashMap<Piece, Integer> playerIntNu = new HashMap<>();
    Piece p1;
    Piece p2;
    Piece p3;
    Piece p4;

    //2 taş üstüste geldiyse taş kırma fonksiyonu
    public static boolean crashControl(Piece p) {
        boolean control = false;
        if (LudoAPP.playerNum == 0) {
            Double myX = p.piece.getLayoutX();
            Double myY = p.piece.getLayoutY();
            Double t1x = FXMLDocumentController.instance.plister.get(1).p1.piece.getLayoutX();
            Double t1y = FXMLDocumentController.instance.plister.get(1).p1.piece.getLayoutY();
            Double t2x = FXMLDocumentController.instance.plister.get(1).p2.piece.getLayoutX();
            Double t2y = FXMLDocumentController.instance.plister.get(1).p2.piece.getLayoutY();
            Double t3x = FXMLDocumentController.instance.plister.get(1).p3.piece.getLayoutX();
            Double t3y = FXMLDocumentController.instance.plister.get(1).p3.piece.getLayoutY();
            Double t4x = FXMLDocumentController.instance.plister.get(1).p4.piece.getLayoutX();
            Double t4y = FXMLDocumentController.instance.plister.get(1).p4.piece.getLayoutY();
            Point myP = new Point(myX, myY);
            Point t1P = new Point(t1x, t1y);
            Point t2P = new Point(t2x, t2y);
            Point t3P = new Point(t3x, t3y);
            Point t4P = new Point(t4x, t4y);


            if (myP.equals(t1P)) {
                FXMLDocumentController.instance.plister.get(1).p1.control = false;
                FXMLDocumentController.instance.plister.get(1).p1.location = 0;
                FXMLDocumentController.instance.plister.get(1).p1.piece.setLayoutX(FXMLDocumentController.instance.plister.get(1).p1.firstX);
                FXMLDocumentController.instance.plister.get(1).p1.piece.setLayoutY(FXMLDocumentController.instance.plister.get(1).p1.firstY);
                crushPieceSender(new LocT(1, 101, 1));
            }
            if (myP.equals(t2P)) {

                FXMLDocumentController.instance.plister.get(1).p2.control = false;
                FXMLDocumentController.instance.plister.get(1).p2.location = 0;
                FXMLDocumentController.instance.plister.get(1).p2.piece.setLayoutX(FXMLDocumentController.instance.plister.get(1).p2.firstX);
                FXMLDocumentController.instance.plister.get(1).p2.piece.setLayoutY(FXMLDocumentController.instance.plister.get(1).p2.firstY);
                crushPieceSender(new LocT(1, 102, 2));
            }
            if (myP.equals(t3P)) {

                FXMLDocumentController.instance.plister.get(1).p3.control = false;
                FXMLDocumentController.instance.plister.get(1).p3.location = 0;
                FXMLDocumentController.instance.plister.get(1).p3.piece.setLayoutX(FXMLDocumentController.instance.plister.get(1).p3.firstX);
                FXMLDocumentController.instance.plister.get(1).p3.piece.setLayoutY(FXMLDocumentController.instance.plister.get(1).p3.firstY);
                crushPieceSender(new LocT(1, 103, 3));
            }
            if (myP.equals(t4P)) {

                FXMLDocumentController.instance.plister.get(1).p4.control = false;
                FXMLDocumentController.instance.plister.get(1).p4.location = 0;
                FXMLDocumentController.instance.plister.get(1).p4.piece.setLayoutX(FXMLDocumentController.instance.plister.get(1).p4.firstX);
                FXMLDocumentController.instance.plister.get(1).p4.piece.setLayoutY(FXMLDocumentController.instance.plister.get(1).p4.firstY);
                crushPieceSender(new LocT(1, 104, 4));
            }
        } else {
            Double myX = p.piece.getLayoutX();
            Double myY = p.piece.getLayoutY();
            Double t1x = FXMLDocumentController.instance.plister.get(0).p1.piece.getLayoutX();
            Double t1y = FXMLDocumentController.instance.plister.get(0).p1.piece.getLayoutY();
            Double t2x = FXMLDocumentController.instance.plister.get(0).p2.piece.getLayoutX();
            Double t2y = FXMLDocumentController.instance.plister.get(0).p2.piece.getLayoutY();
            Double t3x = FXMLDocumentController.instance.plister.get(0).p3.piece.getLayoutX();
            Double t3y = FXMLDocumentController.instance.plister.get(0).p3.piece.getLayoutY();
            Double t4x = FXMLDocumentController.instance.plister.get(0).p4.piece.getLayoutX();
            Double t4y = FXMLDocumentController.instance.plister.get(0).p4.piece.getLayoutY();
            Point myP = new Point(myX, myY);
            Point t1P = new Point(t1x, t1y);
            Point t2P = new Point(t2x, t2y);
            Point t3P = new Point(t3x, t3y);
            Point t4P = new Point(t4x, t4y);
            if (myP.equals(t1P)) {

                FXMLDocumentController.instance.plister.get(0).p1.control = false;
                FXMLDocumentController.instance.plister.get(0).p1.location = 0;
                FXMLDocumentController.instance.plister.get(0).p1.piece.setLayoutX(FXMLDocumentController.instance.plister.get(1).p1.firstX);
                FXMLDocumentController.instance.plister.get(0).p1.piece.setLayoutY(FXMLDocumentController.instance.plister.get(1).p1.firstY);
                crushPieceSender(new LocT(0, 101, 1));
            }
            if (myP.equals(t2P)) {

                FXMLDocumentController.instance.plister.get(0).p2.control = false;
                FXMLDocumentController.instance.plister.get(0).p2.location = 0;
                FXMLDocumentController.instance.plister.get(0).p2.piece.setLayoutX(FXMLDocumentController.instance.plister.get(1).p2.firstX);
                FXMLDocumentController.instance.plister.get(0).p2.piece.setLayoutY(FXMLDocumentController.instance.plister.get(1).p2.firstY);
                crushPieceSender(new LocT(0, 102, 2));
            }
            if (myP.equals(t3P)) {

                FXMLDocumentController.instance.plister.get(0).p3.control = false;
                FXMLDocumentController.instance.plister.get(0).p3.location = 0;
                FXMLDocumentController.instance.plister.get(0).p3.piece.setLayoutX(FXMLDocumentController.instance.plister.get(1).p3.firstX);
                FXMLDocumentController.instance.plister.get(0).p3.piece.setLayoutY(FXMLDocumentController.instance.plister.get(1).p3.firstY);
                crushPieceSender(new LocT(0, 103, 3));
            }
            if (myP.equals(t4P)) {

                FXMLDocumentController.instance.plister.get(0).p4.control = false;
                FXMLDocumentController.instance.plister.get(0).p4.location = 0;
                FXMLDocumentController.instance.plister.get(0).p4.piece.setLayoutX(FXMLDocumentController.instance.plister.get(1).p4.firstX);
                FXMLDocumentController.instance.plister.get(0).p4.piece.setLayoutY(FXMLDocumentController.instance.plister.get(1).p4.firstY);
                crushPieceSender(new LocT(0, 104, 4));
            }
        }
        return control;
    }

    //ImageView alır Piece döndürü
    public Piece pieceSearcer(ImageView im) {
        Piece tempP = playerImg.get(im);
        return tempP;
    }
    //İnteger alır Piece döndürü
    public Piece numPieceSearcer(int i) {
        Piece tempP = playerInt.get(i);
        return tempP;
    }
    
    //Piece alır İnteger döndürü
    public Integer getPieceNum(Piece p) {
        int tempP = playerIntNu.get(p);
        return tempP;
    }

    //kırık taşları gündelliyor
    public static void crushPieceSender(LocT t) {
        Message msg = new Message(Message.Message_Type.Locations);
        msg.loc = t;
        Client.Send(msg);
    }

    //taşları bi yerden bi yere taşır
    public static int pieceMov(Piece p, int movec) {
        p.control = true;
        int moveL = p.location + movec;
        p.location = moveL;
        p.engagement += movec;
        p.piece.setLayoutX(Path.listOfMaps.get(LudoAPP.playerNum).get(new Integer(moveL)).x);
        p.piece.setLayoutY(Path.listOfMaps.get(LudoAPP.playerNum).get(new Integer(moveL)).y);
        crashControl(p);
        return p.location;
    }
    //Rakibin taşlarını senkronize edeiyor.
    public static int rivalPieceMov(Piece p, int loc, int pNum) {
        p.location = loc;
        p.piece.setLayoutX(Path.listOfMaps.get(pNum).get(new Integer(p.location)).x);
        p.piece.setLayoutY(Path.listOfMaps.get(pNum).get(new Integer(p.location)).y);
        return p.location;
    }

    public PlayerP(ImageView p1_i, ImageView p2_i, ImageView p3_i, ImageView p4_i, HashMap p_p, int eg) {
        this.p1 = new Piece(p1_i, 1, eg);
        this.p1.firstX = p1_i.getLayoutX();
        this.p1.firstY = p1_i.getLayoutY();
        this.p2 = new Piece(p2_i, 2, eg);
        this.p2.firstX = p2_i.getLayoutX();
        this.p2.firstY = p2_i.getLayoutY();
        this.p3 = new Piece(p3_i, 3, eg);
        this.p3.firstX = p3_i.getLayoutX();
        this.p3.firstY = p3_i.getLayoutY();
        this.p4 = new Piece(p4_i, 4, eg);
        this.p4.firstX = p4_i.getLayoutX();
        this.p4.firstY = p4_i.getLayoutY();
        this.playerList.put(p1, p_p);
        this.playerList.put(p2, p_p);
        this.playerList.put(p3, p_p);
        this.playerList.put(p4, p_p);
        this.playerImg.put(p1_i, p1);
        this.playerImg.put(p2_i, p2);
        this.playerImg.put(p3_i, p3);
        this.playerImg.put(p4_i, p4);
        this.playerInt.put(1, p1);
        this.playerInt.put(2, p2);
        this.playerInt.put(3, p3);
        this.playerInt.put(4, p4);
        this.playerIntNu.put(p1, 1);
        this.playerIntNu.put(p2, 2);
        this.playerIntNu.put(p3, 3);
        this.playerIntNu.put(p4, 4);
    }

}
