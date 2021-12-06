/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludoapp;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import sun.awt.image.InputStreamImageSource;

/**
 *
 * @author Abdurrahman
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private ImageView YellowPiece_1;
    @FXML
    private ImageView YellowPiece_2;
    @FXML
    private ImageView YellowPiece_3;
    @FXML
    private ImageView YellowPiece_4;
    @FXML
    private ImageView RedPiece_1;
    @FXML
    private ImageView RedPiece_2;
    @FXML
    private ImageView RedPiece_3;
    @FXML
    private ImageView RedPiece_4;
    @FXML
    private ImageView BluePiece_1;
    @FXML
    private ImageView BluePiece_2;
    @FXML
    private ImageView BluePiece_3;
    @FXML
    private ImageView BluePiece_4;
    @FXML
    private ImageView GreenPiece_1;
    @FXML
    private ImageView GreenPiece_2;
    @FXML
    private ImageView GreenPiece_3;
    @FXML
    private ImageView GreenPiece_4;

    @FXML
    private ImageView imageview;
    @FXML
    private SVGPath svgs;
    @FXML
    private Button btn1;
    private Image[] dice;
    private SVGPath[] svgss;
    @FXML
    private Rectangle r1;
    @FXML
    private ImageView sw;
    @FXML
    public Button play;
    @FXML
    public Button connect;
    @FXML
    public TextField name;
    @FXML
    public TextField rakipname;
    @FXML
    public TextField info;
    public static FXMLDocumentController instance;
    public static boolean playControl;
    @FXML
    Polygon yPolly;
    @FXML
    Polygon rPolly;
//    public PlayerP[] plister = new PlayerP[4];
    public List<PlayerP> plister = new ArrayList<PlayerP>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
        new Path();
        YellowPiece_1.setImage(new Image(new File("Yellow.png").toURI().toString()));
        YellowPiece_2.setImage(new Image(new File("Yellow.png").toURI().toString()));
        YellowPiece_3.setImage(new Image(new File("Yellow.png").toURI().toString()));
        YellowPiece_4.setImage(new Image(new File("Yellow.png").toURI().toString()));

        BluePiece_1.setImage(new Image(new File("Blue.png").toURI().toString()));
        BluePiece_2.setImage(new Image(new File("Blue.png").toURI().toString()));
        BluePiece_3.setImage(new Image(new File("Blue.png").toURI().toString()));
        BluePiece_4.setImage(new Image(new File("Blue.png").toURI().toString()));

        GreenPiece_1.setImage(new Image(new File("Green.png").toURI().toString()));
        GreenPiece_2.setImage(new Image(new File("Green.png").toURI().toString()));
        GreenPiece_3.setImage(new Image(new File("Green.png").toURI().toString()));
        GreenPiece_4.setImage(new Image(new File("Green.png").toURI().toString()));

        RedPiece_1.setImage(new Image(new File("Red.png").toURI().toString()));
        RedPiece_2.setImage(new Image(new File("Red.png").toURI().toString()));
        RedPiece_3.setImage(new Image(new File("Red.png").toURI().toString()));
        RedPiece_4.setImage(new Image(new File("Red.png").toURI().toString()));

        PlayerP p1 = new PlayerP(YellowPiece_1, YellowPiece_2, YellowPiece_3, YellowPiece_4, Path.pYellow, 0);
        PlayerP p2 = new PlayerP(RedPiece_1, RedPiece_2, RedPiece_3, RedPiece_4, Path.pRed, 13);
        PlayerP p3 = new PlayerP(BluePiece_1, BluePiece_2, BluePiece_3, BluePiece_4, Path.pBlue, 27);
        PlayerP p4 = new PlayerP(GreenPiece_1, GreenPiece_2, GreenPiece_3, GreenPiece_4, Path.pGreen, 40);
        plister.add(p1);
        plister.add(p2);
        plister.add(p3);
        plister.add(p4);
        Path.pYellow.put(101, new Point(YellowPiece_1.getLayoutX(), YellowPiece_1.getLayoutY()));
        Path.pYellow.put(102, new Point(YellowPiece_2.getLayoutX(), YellowPiece_2.getLayoutY()));
        Path.pYellow.put(103, new Point(YellowPiece_3.getLayoutX(), YellowPiece_3.getLayoutY()));
        Path.pYellow.put(104, new Point(YellowPiece_4.getLayoutX(), YellowPiece_4.getLayoutY()));
        Path.pRed.put(101, new Point(RedPiece_1.getLayoutX(), RedPiece_1.getLayoutY()));
        Path.pRed.put(102, new Point(RedPiece_2.getLayoutX(), RedPiece_2.getLayoutY()));
        Path.pRed.put(103, new Point(RedPiece_3.getLayoutX(), RedPiece_3.getLayoutY()));
        Path.pRed.put(104, new Point(RedPiece_4.getLayoutX(), RedPiece_4.getLayoutY()));

        dice = new Image[6];
        Image t = new Image(new File("Yellow.png").toURI().toString());
        for (int j = 1; j < 7; j++) {
            Image l = new Image(new File("dice" + j + ".png").toURI().toString());
            dice[j - 1] = l;
        }

    }

    // zarın rastgele dönmesini sağlayan thread
    class ThreadA extends Thread {

        public void run() {
            while (kon) {
                imageview.setImage(dice[new Random().nextInt(6)]);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
    public int con = 1;
    public boolean kon;
    public int diceNum;
    ThreadA threadA;

    //ilk eşleşme gerçekleşti
    public void rivalConnect(Message msg) {
        FXMLDocumentController.instance.rakipname.setText(msg.content.toString());
        FXMLDocumentController.instance.playerSelected(msg.playerNumber);
        if (LudoAPP.playerNum == 0) {
            kon = true;
            info.setText("Sizin Sıranız...");
            yPolly.setVisible(true);
            rPolly.setVisible(false);
            threadA = new ThreadA();
            threadA.start();
            btn1.setDisable(false);
        } else {
            info.setText("Rakibin Sırası...");
            kon = true;
            btn1.setDisable(true);
            yPolly.setVisible(true);
            rPolly.setVisible(false);
            threadA = new ThreadA();
            threadA.start();
        }
    }

    //sırayı alıyoruz 
    public void sirayiAl() {
        int t = 4;
        for (int i = 1; i < 5; i++) {
            if (plister.get(LudoAPP.playerNum).playerInt.get(i).control) {
                t++;
            } else {
                t--;
            }
        }
        if(t==0){
            zarkontol=false;
        }
        if (LudoAPP.playerNum == 0) {
            kon = true;
            info.setText("Sizin Sıranız...");
            yPolly.setVisible(true);
            rPolly.setVisible(false);
            threadA = new ThreadA();
            threadA.start();
            btn1.setDisable(false);
        } else {
            kon = true;
            info.setText("Sizin Sıranız...");
            yPolly.setVisible(false);
            rPolly.setVisible(true);
            threadA = new ThreadA();
            threadA.start();
            btn1.setDisable(false);
        }
    }

    //rakip geldikten sonra player idye göre oynayamayacağım taşları kitliyor
    public void playerSelected(int id) {
        for (int i = 0; i < 4; i++) {
            if (i == LudoAPP.playerNum) {
                plister.get(i).p1.piece.setDisable(true);
                plister.get(i).p2.piece.setDisable(true);
                plister.get(i).p3.piece.setDisable(true);
                plister.get(i).p4.piece.setDisable(true);
            } else {
                plister.get(i).p1.piece.setDisable(true);
                plister.get(i).p2.piece.setDisable(true);
                plister.get(i).p3.piece.setDisable(true);
                plister.get(i).p4.piece.setDisable(true);
            }

        }
    }

    //servera bağlanıyoruz
    @FXML
    private void connectButton(ActionEvent event) {
        //sunucuya bağlanan oyuncu sadece kendi butonunu görüyor.
        Client.Start("127.0.0.1", 2000);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        connect.setDisable(true);
    }

    public boolean zarkontol;
    int tr = 6;
    public boolean tekrarAt;

    //Zara tıkladığımızda çağrılan method
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //hali hazırda attığım zarı oynadım mı kontrolü yapıyorum
        if (kon) {

            kon = false;
            //random bi zar seçiyorum
            diceNum = Integer.valueOf(name.getText());
            imageview.setImage(dice[diceNum]);
//            diceNum = new Random().nextInt(6);
//            imageview.setImage(dice[diceNum]);
            //6 attım mı atmadım mı kontrolü
            if (diceNum == 5) {
                tekrarAt = true;
            } else {
                tekrarAt = false;
            }
            //tahta üzerinde zarım var mı yok mu kontrolü
            if (zarkontol) {
                pieceBooler(false);
            } else {
                if (tekrarAt) {
                    zarkontol = true;
                    pieceBooler(false);
                } else {
                    sirayiSav();
                }
            }
        }
    }

    //Serverdan gelen hareketleri tahtaya yansıtan method
    //Loct türünde nesne alıyor
    public void rivalMove(LocT t) {
        //plister arrayinde rakip oyuncunun playerını arayıp onun içindende oynadığı piyonu buluyoruz
        Piece tempP = plister.get(t.playerNum).numPieceSearcer(t.pieceNum);
        //Piyona bulduğumuz piyonu tahtada gitmesi gereken yere taşıyoruz.
        PlayerP.rivalPieceMov(tempP, t.locNum, t.playerNum);
    }

    //Sırası gelmeyen kullanıcının piyonlara tıklayıp event oluşturmasını engelleyen
    //Ya da sırası gelenin basabilmesini sağlayan method
    public void pieceBooler(boolean t) {
        plister.get(LudoAPP.playerNum).p1.piece.setDisable(t);
        plister.get(LudoAPP.playerNum).p2.piece.setDisable(t);
        plister.get(LudoAPP.playerNum).p3.piece.setDisable(t);
        plister.get(LudoAPP.playerNum).p4.piece.setDisable(t);
    }

    //Rakibe hareketlerimizi gönderiyoruz
    public void sendMove(LocT t) {
        Message msg = new Message(Message.Message_Type.Locations);
        msg.loc = t;
        Client.Send(msg);
    }

    //Sırayı rakibe geçiriyoruz
    public void sirayiSav() {
        info.setText("Rakibin Sırası...");
        yPolly.setVisible(false);
        rPolly.setVisible(false);
        Message msg = new Message(Message.Message_Type.nextPlayer);
        Client.Send(msg);
    }

    public boolean disaridaTasimVarMi;

    //piyonlara tıklanınca tetiklenen method
    @FXML
    private void buttonPress(MouseEvent event) {
        //tıklanan objeyi buluyoruz
        Object temp = event.getSource();
        //player numaramıza göre pul listemizden tıklanan pul ile pul nesnemizi döndürüyoruz
        Piece tempP = plister.get(LudoAPP.playerNum).pieceSearcer((ImageView) temp);
        //6 attık mı atmadık mı kontrol
        if (tekrarAt) {
            //seçtiğimiz piyon yuvadan çıkmış mı çıkmamış mı kontrol
            if (tempP.control) {
                //Zar değerimiz kadar seçtiğimiz piyonu hareket ettiriyoruz
                int i = PlayerP.pieceMov(tempP, diceNum + 1);
                //piyonları kitliyoruz
                pieceBooler(true);
                //hangi piyonu seçtiğimizi buluyoruz
                int t = plister.get(LudoAPP.playerNum).getPieceNum(tempP);
                sendMove(new LocT(LudoAPP.playerNum, i, t));

            } else {
                //daha önce oynanmamış taşı dışarı çıkarıyoruz.
                int i = PlayerP.pieceMov(tempP, 1);
                pieceBooler(true);
                int t = plister.get(LudoAPP.playerNum).getPieceNum(tempP);
                sendMove(new LocT(LudoAPP.playerNum, i, t));
            }
            tekrarAt = false;
            threadA = new ThreadA();
            threadA.start();
            kon = true;
        } else {
            //daha önce oynanmış taşı mı seçtiğimizi kontrol ediyoruz.
            if (tempP.control) {
                int i = PlayerP.pieceMov(tempP, diceNum + 1);
                pieceBooler(true);
                int t = plister.get(LudoAPP.playerNum).getPieceNum(tempP);
                sendMove(new LocT(LudoAPP.playerNum, i, t));
                //elimizi oynadık 6da atmadığımız için sırayı karşıya geçiriyoruz
                sirayiSav();
            } else {
                System.out.println("Bu tas oynamaz aq malı");
            }
        }

    }

}
