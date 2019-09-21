/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Carta;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.Timer;

/**
  *
 *@author 20152134110070
 */
public class tela1 extends javax.swing.JFrame {

    /**
     * Creates new form tela1
     */
    public static Carta cartas = new Carta();
    public static JLabel VetorL [] = new JLabel[20];
    public static boolean matrizB [][] = new boolean[5][4];
    public tela1() {
        initComponents();
        cartas.imagens[0] = "/imagens/Emblema.png";
        cartas.imagens[1] = "/imagens/Mario.jpg";
        cartas.imagens[2] = "/imagens/Ghost.jpg";
        cartas.imagens[3] = "/imagens/Flower.png";
        cartas.imagens[4] = "/imagens/Goomba.png";
        cartas.imagens[5] = "/imagens/Luigi.jpg";
        cartas.imagens[6] = "/imagens/Mushroom1UP.png";
        cartas.imagens[7] = "/imagens/Peach.jpg";
        cartas.imagens[8] = "/imagens/Poison-mushroom.jpg";
        cartas.imagens[9] = "/imagens/Star.png";
        cartas.imagens[10] = "/imagens/Bowser.jpg";
        
        cartas.imagensB[0] = "/imagens/Emblema.png";
        cartas.imagensB[1] = "/imagens/MarioB.jpg";
        cartas.imagensB[2] = "/imagens/GhostB.jpg";
        cartas.imagensB[3] = "/imagens/FlowerB.png";
        cartas.imagensB[4] = "/imagens/GoombaB.png";
        cartas.imagensB[5] = "/imagens/LuigiB.jpg";
        cartas.imagensB[6] = "/imagens/Mushroom1UPB.png";
        cartas.imagensB[7] = "/imagens/PeachB.jpg";
        cartas.imagensB[8] = "/imagens/Poison-mushroomB.jpg";
        cartas.imagensB[9] = "/imagens/StarB.png";
        cartas.imagensB[10] = "/imagens/BowserB.png";
        
        VetorL [0] = lblLogo1;
        VetorL [1] = lblLogo2;
        VetorL [2] = lblLogo3;
        VetorL [3] = lblLogo4;
        VetorL [4] = lblLogo5;
        VetorL [5] = lblLogo6;
        VetorL [6] = lblLogo7;
        VetorL [7] = lblLogo8;
        VetorL [8] = lblLogo9;
        VetorL [9] = lblLogo10;
        VetorL [10] = lblLogo11;
        VetorL [11] = lblLogo12;
        VetorL [12] = lblLogo13;
        VetorL [13] = lblLogo14;
        VetorL [14] = lblLogo15;
        VetorL [15] = lblLogo16;
        VetorL [16] = lblLogo17;
        VetorL [17] = lblLogo18;
        VetorL [18] = lblLogo19;
        VetorL [19] = lblLogo20;
        
        for(int linha=0;linha < 5; linha++){
            for(int coluna=0;coluna < 4;coluna++){
                matrizB [linha][coluna]= true;
            }
        }
        
        if(jogador == true){
            jLabel5.setText("Vez do Jogador 1");
        }else{
            jLabel5.setText("Vez do Jogador 2");
        }
        
    }
    
    public static boolean jogador = true;
    public static int num1 = 0;
    public static int num2 = 0;
    public static int pontos1 = 0;
    public static int pontos2 = 0;
    
    
    public static JLabel getLabel (int id){
        return VetorL [id];
    };
    
    public static int Nimagens [] = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10};
    
    public static int contaPar = 0;
    
    public static void embaralhar(int [] v) {
		
		Random random = new Random();
		
		for (int i=0; i < (v.length - 1); i++) {

			//sorteia um índice
			int j = random.nextInt(v.length); 
			
			//troca o conteúdo dos índices i e j do vetor
			int temp = v[i];
			v[i] = v[j];
			v[j] = temp;
		}
		
	}
    
    public void play(String NomeAudio){
        URL url = getClass().getResource(NomeAudio+".WAV");
        AudioClip audio = Applet.newAudioClip(url); 
        audio.play();
    }
   
    public static int NimagensV[] = {1,6,5,2,2,4,3,1,8,3,10,9,5,4,10,7,6,9,7,8};
    
    public static int linha1 = 0;
    public static int linha2 = 0;
    public static int coluna1 = 0;
    public static int coluna2 = 0;    
    
    public static int jogada = 0;

    public static int matriz [][] = new int [5][4];
    
    public static int lblNome1 = 0;
    public static int lblNome2 = 0;
     
    public void verificaPar(){
        if(matriz [linha1][coluna1] == matriz [linha2][coluna2]){
           play("/Sons/1up");
           getLabel(lblNome1).setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.imagensB[matriz [linha1][coluna1]])));
           getLabel(lblNome2).setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.imagensB[matriz [linha2][coluna2]])));
           matrizB[linha1][coluna1] = false;
           matrizB[linha2][coluna2] = false;
           if(jogador == true){
               num1++;
               jLabel9.setText(num1+"");
           }else{
               num2++;
               jLabel10.setText(num2+"");
           }
           if(num1 > num2){
               jLabel9.setForeground(Color.green);
               jLabel10.setForeground(Color.red);
           }else if(num2 > num1){
               jLabel9.setForeground(Color.red);
               jLabel10.setForeground(Color.green);
           }else if(num1 == num2){
               jLabel9.setForeground(Color.blue);
               jLabel10.setForeground(Color.blue);
           }
           contaPar++;
           if(contaPar == 10){
               if(num1 > num2){
                   
                   pontos1++;
                   jLabel1.setText(pontos1+"");
                   jLabel5.setText("Vencedor: Jogador 1");
                   play("/Sons/Game Over");
                   int escolha = JOptionPane.showConfirmDialog(null, "Jogador 1 venceu! Deseja Continuar?","Fim de jogo!" ,YES_NO_OPTION );
                   if(escolha == 0){
                       lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo11.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo12.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo15.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo13.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo16.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo14.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo17.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo20.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo18.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo19.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        for(int linha=0;linha < 5;linha++){
            for(int coluna=0;coluna < 4;coluna++){
                matriz[linha][coluna] = 0;
            }
        }
        embaralhar(Nimagens);
        for(int i=0;i < 20;i++){
            NimagensV [i] = Nimagens [i];
        }
        for(int linha=0;linha < 5; linha++){
            for(int coluna=0;coluna < 4;coluna++){
                matrizB [linha][coluna]= true;
            }
        }
        
        jogada = 0;
        contaPar = 0;
        play("/Sons/Stage Selected");
        num1 = 0;
        num2 = 0;
        jLabel9.setText("0");
        jLabel10.setText("0");
        jLabel9.setForeground(Color.black);
        jLabel10.setForeground(Color.black);
        if(pontos1 > pontos2){
           jogador = false;
           jLabel5.setText("Vez do Jogador 2");
        }else if(pontos2 > pontos1){
            jogador = true;
            jLabel5.setText("Vez do Jogador 1");
        }else{
            jogador = false;
            jLabel5.setText("Vez do Jogador 2");
        }
                   }else{
                       dispose();
                   }
               }else if(num2 > num1){
                   pontos2++;
                   jLabel2.setText(pontos2+"");
                   jLabel5.setText("Vencedor: Jogador 2");
                   play("/Sons/Game Over");
                   int escolha = JOptionPane.showConfirmDialog(null, "Jogador 2 venceu! Deseja Continuar?","Fim de jogo!" ,YES_NO_OPTION );
                   if(escolha == 0){
                       lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo11.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo12.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo15.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo13.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo16.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo14.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo17.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo20.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo18.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo19.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        for(int linha=0;linha < 5;linha++){
            for(int coluna=0;coluna < 4;coluna++){
                matriz[linha][coluna] = 0;
            }
        }
        embaralhar(Nimagens);
        for(int i=0;i < 20;i++){
            NimagensV [i] = Nimagens [i];
        }
        for(int linha=0;linha < 5; linha++){
            for(int coluna=0;coluna < 4;coluna++){
                matrizB [linha][coluna]= true;
            }
        }
        
        jogada = 0;
        contaPar = 0;
        play("/Sons/Stage Selected");
        num1 = 0;
        num2 = 0;
        jLabel9.setText("0");
        jLabel10.setText("0");
        jLabel9.setForeground(Color.black);
        jLabel10.setForeground(Color.black);
        if(pontos1 > pontos2){
           jogador = false;
           jLabel5.setText("Vez do Jogador 2");
        }else if(pontos2 > pontos1){
            jogador = true;
            jLabel5.setText("Vez do Jogador 1");
        }else{
            jogador = false;
            jLabel5.setText("Vez do Jogador 2");
        }
                   }else{
                       dispose();
                   }
               }else if(num1 == num2){
                   jLabel5.setText("Empate");
                   play("/Sons/Game Over");
                   int escolha = JOptionPane.showConfirmDialog(null, "Empate! Deseja Continuar?","Fim de jogo!" ,YES_NO_OPTION );
                   if(escolha == 0){
                       lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo11.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo12.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo15.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo13.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo16.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo14.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo17.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo20.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo18.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo19.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        for(int linha=0;linha < 5;linha++){
            for(int coluna=0;coluna < 4;coluna++){
                matriz[linha][coluna] = 0;
            }
        }
        embaralhar(Nimagens);
        for(int i=0;i < 20;i++){
            NimagensV [i] = Nimagens [i];
        }
        for(int linha=0;linha < 5; linha++){
            for(int coluna=0;coluna < 4;coluna++){
                matrizB [linha][coluna]= true;
            }
        }
        
        jogada = 0;
        contaPar = 0;
        play("/Sons/Stage Selected");
        num1 = 0;
        num2 = 0;
        jLabel9.setText("0");
        jLabel10.setText("0");
        jLabel9.setForeground(Color.black);
        jLabel10.setForeground(Color.black);
        if(pontos1 > pontos2){
           jogador = false;
           jLabel5.setText("Vez do Jogador 2");
        }else if(pontos2 > pontos1){
            jogador = true;
            jLabel5.setText("Vez do Jogador 1");
        }else{
            jogador = false;
            jLabel5.setText("Vez do Jogador 2");
        }
                   }else{
                       dispose();
                   }
               }
           }
       }else{ 
           play("/Sons/Warp");
           matrizB[linha1][coluna1] = true;
           matrizB[linha2][coluna2] = true;
           if(jogador == true){
               jogador = false;
               jLabel5.setText("Vez do Jogador 2");
           }else{
               jogador = true;
               jLabel5.setText("Vez do Jogador 1");
           }
           final Timer tempo = new Timer(500, new ActionListener() {//vai esperar 5 segundos e executar essa ação
            @Override
            public void actionPerformed(ActionEvent e) {
                   getLabel(lblNome1).setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
                   getLabel(lblNome2).setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
                    
            }
        });
        tempo.start();//inicio o tempo
       
        tempo.setRepeats(false);
             
       }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        P1 = new javax.swing.JPanel();
        P2 = new javax.swing.JPanel();
        P3 = new javax.swing.JPanel();
        P4 = new javax.swing.JPanel();
        P5 = new javax.swing.JPanel();
        P6 = new javax.swing.JPanel();
        P7 = new javax.swing.JPanel();
        P8 = new javax.swing.JPanel();
        P9 = new javax.swing.JPanel();
        P10 = new javax.swing.JPanel();
        P11 = new javax.swing.JPanel();
        P12 = new javax.swing.JPanel();
        P13 = new javax.swing.JPanel();
        P14 = new javax.swing.JPanel();
        P15 = new javax.swing.JPanel();
        P16 = new javax.swing.JPanel();
        P17 = new javax.swing.JPanel();
        P18 = new javax.swing.JPanel();
        P19 = new javax.swing.JPanel();
        P20 = new javax.swing.JPanel();
        Reflesh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("\t\t          Jogo da Memoria(Mario)");
        getContentPane().setLayout(null);

        P1.setBackground(new java.awt.Color(255, 255, 255));
        P1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P1MousePressed(evt);
            }
        });

        lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P1Layout = new javax.swing.GroupLayout(P1);
        P1.setLayout(P1Layout);
        P1Layout.setHorizontalGroup(
            P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P1Layout.setVerticalGroup(
            P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo1)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P1);
        P1.setBounds(273, 85, 111, 111);

        P2.setBackground(new java.awt.Color(255, 255, 255));
        P2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P2MousePressed(evt);
            }
        });

        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P2Layout = new javax.swing.GroupLayout(P2);
        P2.setLayout(P2Layout);
        P2Layout.setHorizontalGroup(
            P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P2Layout.setVerticalGroup(
            P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo2)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P2);
        P2.setBounds(390, 85, 111, 111);

        P3.setBackground(new java.awt.Color(255, 255, 255));
        P3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P3MousePressed(evt);
            }
        });

        lblLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P3Layout = new javax.swing.GroupLayout(P3);
        P3.setLayout(P3Layout);
        P3Layout.setHorizontalGroup(
            P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P3Layout.setVerticalGroup(
            P3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo3)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P3);
        P3.setBounds(507, 85, 111, 111);

        P4.setBackground(new java.awt.Color(255, 255, 255));
        P4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P4MousePressed(evt);
            }
        });

        lblLogo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P4Layout = new javax.swing.GroupLayout(P4);
        P4.setLayout(P4Layout);
        P4Layout.setHorizontalGroup(
            P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P4Layout.setVerticalGroup(
            P4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo4)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P4);
        P4.setBounds(624, 85, 111, 111);

        P5.setBackground(new java.awt.Color(255, 255, 255));
        P5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P5MousePressed(evt);
            }
        });

        lblLogo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P5Layout = new javax.swing.GroupLayout(P5);
        P5.setLayout(P5Layout);
        P5Layout.setHorizontalGroup(
            P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P5Layout.setVerticalGroup(
            P5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo5)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P5);
        P5.setBounds(273, 202, 111, 111);

        P6.setBackground(new java.awt.Color(255, 255, 255));
        P6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P6MousePressed(evt);
            }
        });

        lblLogo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P6Layout = new javax.swing.GroupLayout(P6);
        P6.setLayout(P6Layout);
        P6Layout.setHorizontalGroup(
            P6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P6Layout.setVerticalGroup(
            P6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo6)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P6);
        P6.setBounds(390, 202, 111, 111);

        P7.setBackground(new java.awt.Color(255, 255, 255));
        P7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P7MousePressed(evt);
            }
        });

        lblLogo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P7Layout = new javax.swing.GroupLayout(P7);
        P7.setLayout(P7Layout);
        P7Layout.setHorizontalGroup(
            P7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P7Layout.setVerticalGroup(
            P7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo7)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P7);
        P7.setBounds(507, 202, 111, 111);

        P8.setBackground(new java.awt.Color(255, 255, 255));
        P8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P8MousePressed(evt);
            }
        });

        lblLogo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P8Layout = new javax.swing.GroupLayout(P8);
        P8.setLayout(P8Layout);
        P8Layout.setHorizontalGroup(
            P8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P8Layout.setVerticalGroup(
            P8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo8)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P8);
        P8.setBounds(624, 202, 111, 111);

        P9.setBackground(new java.awt.Color(255, 255, 255));
        P9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P9MousePressed(evt);
            }
        });

        lblLogo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P9Layout = new javax.swing.GroupLayout(P9);
        P9.setLayout(P9Layout);
        P9Layout.setHorizontalGroup(
            P9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P9Layout.setVerticalGroup(
            P9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo9)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P9);
        P9.setBounds(273, 319, 111, 111);

        P10.setBackground(new java.awt.Color(255, 255, 255));
        P10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P10MousePressed(evt);
            }
        });

        lblLogo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P10Layout = new javax.swing.GroupLayout(P10);
        P10.setLayout(P10Layout);
        P10Layout.setHorizontalGroup(
            P10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P10Layout.setVerticalGroup(
            P10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo10)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P10);
        P10.setBounds(390, 319, 111, 111);

        P11.setBackground(new java.awt.Color(255, 255, 255));
        P11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P11MousePressed(evt);
            }
        });

        lblLogo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P11Layout = new javax.swing.GroupLayout(P11);
        P11.setLayout(P11Layout);
        P11Layout.setHorizontalGroup(
            P11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P11Layout.setVerticalGroup(
            P11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo11)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P11);
        P11.setBounds(507, 319, 111, 111);

        P12.setBackground(new java.awt.Color(255, 255, 255));
        P12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P12MousePressed(evt);
            }
        });

        lblLogo12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P12Layout = new javax.swing.GroupLayout(P12);
        P12.setLayout(P12Layout);
        P12Layout.setHorizontalGroup(
            P12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo12, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P12Layout.setVerticalGroup(
            P12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo12)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P12);
        P12.setBounds(624, 319, 111, 111);

        P13.setBackground(new java.awt.Color(255, 255, 255));
        P13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P13MousePressed(evt);
            }
        });

        lblLogo13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P13Layout = new javax.swing.GroupLayout(P13);
        P13.setLayout(P13Layout);
        P13Layout.setHorizontalGroup(
            P13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo13, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P13Layout.setVerticalGroup(
            P13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo13)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P13);
        P13.setBounds(273, 436, 111, 111);

        P14.setBackground(new java.awt.Color(255, 255, 255));
        P14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P14MousePressed(evt);
            }
        });

        lblLogo14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P14Layout = new javax.swing.GroupLayout(P14);
        P14.setLayout(P14Layout);
        P14Layout.setHorizontalGroup(
            P14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo14, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P14Layout.setVerticalGroup(
            P14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo14)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P14);
        P14.setBounds(390, 436, 111, 111);

        P15.setBackground(new java.awt.Color(255, 255, 255));
        P15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P15MousePressed(evt);
            }
        });

        lblLogo15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P15Layout = new javax.swing.GroupLayout(P15);
        P15.setLayout(P15Layout);
        P15Layout.setHorizontalGroup(
            P15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo15, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P15Layout.setVerticalGroup(
            P15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo15)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P15);
        P15.setBounds(507, 436, 111, 111);

        P16.setBackground(new java.awt.Color(255, 255, 255));
        P16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P16MousePressed(evt);
            }
        });

        lblLogo16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P16Layout = new javax.swing.GroupLayout(P16);
        P16.setLayout(P16Layout);
        P16Layout.setHorizontalGroup(
            P16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo16, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P16Layout.setVerticalGroup(
            P16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo16)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P16);
        P16.setBounds(624, 436, 111, 111);

        P17.setBackground(new java.awt.Color(255, 255, 255));
        P17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P17MousePressed(evt);
            }
        });

        lblLogo17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P17Layout = new javax.swing.GroupLayout(P17);
        P17.setLayout(P17Layout);
        P17Layout.setHorizontalGroup(
            P17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo17, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P17Layout.setVerticalGroup(
            P17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo17)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P17);
        P17.setBounds(273, 553, 111, 111);

        P18.setBackground(new java.awt.Color(255, 255, 255));
        P18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P18MousePressed(evt);
            }
        });

        lblLogo18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P18Layout = new javax.swing.GroupLayout(P18);
        P18.setLayout(P18Layout);
        P18Layout.setHorizontalGroup(
            P18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        P18Layout.setVerticalGroup(
            P18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo18)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P18);
        P18.setBounds(390, 553, 111, 111);

        P19.setBackground(new java.awt.Color(255, 255, 255));
        P19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P19MousePressed(evt);
            }
        });

        lblLogo19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N

        javax.swing.GroupLayout P19Layout = new javax.swing.GroupLayout(P19);
        P19.setLayout(P19Layout);
        P19Layout.setHorizontalGroup(
            P19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo19, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P19Layout.setVerticalGroup(
            P19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo19)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P19);
        P19.setBounds(507, 553, 111, 111);

        P20.setBackground(new java.awt.Color(255, 255, 255));
        P20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        P20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P20MousePressed(evt);
            }
        });

        lblLogo20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Emblema.png"))); // NOI18N
        lblLogo20.setToolTipText("");
        lblLogo20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblLogo20MousePressed(evt);
            }
        });

        javax.swing.GroupLayout P20Layout = new javax.swing.GroupLayout(P20);
        P20.setLayout(P20Layout);
        P20Layout.setHorizontalGroup(
            P20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo20, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        P20Layout.setVerticalGroup(
            P20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo20)
                .addGap(117, 117, 117))
        );

        getContentPane().add(P20);
        P20.setBounds(624, 553, 111, 111);

        Reflesh.setBackground(new java.awt.Color(204, 0, 0));
        Reflesh.setFont(new java.awt.Font("Aharoni", 0, 11)); // NOI18N
        Reflesh.setForeground(new java.awt.Color(255, 255, 255));
        Reflesh.setText("Novo Jogo");
        Reflesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefleshActionPerformed(evt);
            }
        });
        getContentPane().add(Reflesh);
        Reflesh.setBounds(419, 11, 175, 37);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("                 Jogador 2"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(756, 85, 176, 156);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("                 Jogador 1"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(67, 67, 67))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(80, 90, 175, 156);

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PLACAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(80, 10, 175, 53);

        jPanel4.setBackground(new java.awt.Color(51, 204, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PLACAR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(43, 43, 43))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(756, 11, 176, 53);

        jPanel5.setBackground(new java.awt.Color(102, 204, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(419, 59, 175, 20);

        jPanel6.setBackground(new java.awt.Color(51, 204, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Pontos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel6)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(753, 247, 176, 53);

        jPanel7.setBackground(new java.awt.Color(51, 204, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pontos");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel7)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7);
        jPanel7.setBounds(80, 250, 175, 53);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel9.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(47, 47, 47))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel9);
        jPanel9.setBounds(110, 310, 120, 111);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel10.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(46, 46, 46))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel10);
        jPanel10.setBounds(782, 306, 120, 111);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Plano de Fundo.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, -20, 990, 750);

        setBounds(0, 0, 957, 741);
    }// </editor-fold>//GEN-END:initComponents

    private void RefleshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefleshActionPerformed
        // TODO add your handling code here
        
        lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo11.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo12.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo15.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo13.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo16.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo14.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo17.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo20.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo18.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        lblLogo19.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(0))));
        for(int linha=0;linha < 5;linha++){
            for(int coluna=0;coluna < 4;coluna++){
                matriz[linha][coluna] = 0;
            }
        }
        embaralhar(Nimagens);
        for(int i=0;i < 20;i++){
            NimagensV [i] = Nimagens [i];
        }
        for(int linha=0;linha < 5; linha++){
            for(int coluna=0;coluna < 4;coluna++){
                matrizB [linha][coluna]= true;
            }
        }
        
        jogada = 0;
        contaPar = 0;
        play("/Sons/Stage Selected");
        num1 = 0;
        num2 = 0;
        jLabel9.setText("0");
        jLabel10.setText("0");
        jLabel9.setForeground(Color.black);
        jLabel10.setForeground(Color.black);
        if(pontos1 > pontos2){
           jogador = false;
           jLabel5.setText("Vez do Jogador 2");
        }else if(pontos2 > pontos1){
            jogador = true;
            jLabel5.setText("Vez do Jogador 1");
        }else{
            jogador = false;
            jLabel5.setText("Vez do Jogador 2");
        }
        
    }//GEN-LAST:event_RefleshActionPerformed

    private void P1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1MousePressed
        // TODO add your handling code here:
        
        if(matrizB[0][0] == true){
        lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[0]))));
            jogada++;
        matriz [0][0] = NimagensV[0];
        if(jogada%2 != 0){
            linha1 = 0;
            coluna1 = 0;
            lblNome1 = 0;
            play("/Sons/Coin");
            matrizB[0][0] = false;
        }else{
            
            linha2 = 0;
            coluna2 = 0;
            lblNome2 = 0;
            
            verificaPar();
        }
        }
    }//GEN-LAST:event_P1MousePressed

    private void P2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P2MousePressed
        // TODO add your handling code here:
        if(matrizB[0][1] == true){
        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[1]))));
        jogada++;
        matriz [0][1] = NimagensV[1];
        if(jogada%2 != 0){
            linha1 = 0;
            coluna1 = 1;
            lblNome1 = 1;
            play("/Sons/Coin");
            matrizB[0][1] = false;
        }else{
            
            linha2 = 0;
            coluna2 = 1;
            lblNome2 = 1;
            verificaPar();
        }
        }
    }//GEN-LAST:event_P2MousePressed

    private void P3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P3MousePressed
        // TODO add your handling code here:
        if(matrizB[0][2] == true ){
        lblLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[2]))));
        jogada++;
        matriz [0][2] = NimagensV[2];
        if(jogada%2 != 0){
            linha1 = 0;
            coluna1 = 2;
            lblNome1 = 2;
            play("/Sons/Coin");
            matrizB[0][2] = false;
        }else{
            
            linha2 = 0;
            coluna2 = 2;
            lblNome2 = 2;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P3MousePressed

    private void P4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P4MousePressed
        // TODO add your handling code here:
        if(matrizB[0][3] == true){
        lblLogo4.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[3]))));
        jogada++;
        matriz [0][3] = NimagensV[3];
        if(jogada%2 != 0){
            linha1 = 0;
            coluna1 = 3;
            lblNome1 = 3;
            play("/Sons/Coin");
            matrizB[0][3] = false;
        }else{
            
            linha2 = 0;
            coluna2 = 3;
            lblNome2 = 3;
            verificaPar();
        }
        }
    }//GEN-LAST:event_P4MousePressed

    private void P5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P5MousePressed
        // TODO add your handling code here:
        if(matrizB[1][0] == true){
        lblLogo5.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[4]))));
        jogada++;
        matriz [1][0] = NimagensV[4];
        if(jogada%2 != 0){
            linha1 = 1;
            coluna1 = 0;
            lblNome1 = 4;
            play("/Sons/Coin");
            matrizB[1][0] = false;
        }else{
            
            linha2 = 1;
            coluna2 = 0;
            lblNome2 = 4;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P5MousePressed

    private void P6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P6MousePressed
        // TODO add your handling code here:
        if(matrizB[1][1] == true){
        lblLogo6.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[5]))));
        jogada++;
        matriz [1][1] = NimagensV[5];
        if(jogada%2 != 0){
            linha1 = 1;
            coluna1 = 1;
            lblNome1 = 5;
            play("/Sons/Coin");
            matrizB[1][1] = false;
        }else{
            
            linha2 = 1;
            coluna2 = 1;
            lblNome2 = 5;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P6MousePressed

    private void P7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P7MousePressed
        // TODO add your handling code here:
        if(matrizB[1][2] == true){
        lblLogo7.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[6]))));
        jogada++;
        matriz [1][2] = NimagensV[6];
        if(jogada%2 != 0){
            linha1 = 1;
            coluna1 = 2;
            lblNome1 = 6;
            play("/Sons/Coin");
            matrizB[1][2] = false;
        }else{
            
            linha2 = 1;
            coluna2 = 2;
            lblNome2 = 6;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P7MousePressed

    private void P8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P8MousePressed
        // TODO add your handling code here:
        if(matrizB[1][3] == true){
        lblLogo8.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[7]))));
        jogada++;
        matriz [1][3] = NimagensV[7];
        if(jogada%2 != 0){
            linha1 = 1;
            coluna1 = 3;
            lblNome1 = 7;
            play("/Sons/Coin");
            matrizB[1][3] = false;
        }else{
            
            linha2 = 1;
            coluna2 = 3;
            lblNome2 = 7;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P8MousePressed

    private void P9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P9MousePressed
        // TODO add your handling code here:
        if(matrizB[2][0] == true){
        lblLogo9.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[8]))));
        jogada++;
        matriz [2][0] = NimagensV[8];
        if(jogada%2 != 0){
            linha1 = 2;
            coluna1 = 0;
            lblNome1 = 8;
            play("/Sons/Coin");
            matrizB[2][0] = false;
        }else{
            linha2 = 2;
            
            coluna2 = 0;
            lblNome2 = 8;
            verificaPar();
        }
        }
    }//GEN-LAST:event_P9MousePressed

    private void P10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P10MousePressed
        // TODO add your handling code here:
        if(matrizB[2][1] == true){
        lblLogo10.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[9]))));
        jogada++;
        matriz [2][1] = NimagensV[9];
        if(jogada%2 != 0){
            linha1 = 2;
            coluna1 = 1;
            lblNome1 = 9;
            play("/Sons/Coin");
            matrizB[2][1] = false;
        }else{
            
            linha2 = 2;
            coluna2 = 1;
            lblNome2 = 9;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P10MousePressed

    private void P11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P11MousePressed
        // TODO add your handling code here:
        if(matrizB[2][2] == true){
        lblLogo11.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[10]))));
        jogada++;
        matriz [2][2] = NimagensV[10];
        if(jogada%2 != 0){
            linha1 = 2;
            coluna1 = 2;
            lblNome1 = 10;
            play("/Sons/Coin");
            matrizB[2][2] = false;
        }else{
            
            linha2 = 2;
            coluna2 = 2;
            lblNome2 = 10;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P11MousePressed

    private void P12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P12MousePressed
        // TODO add your handling code here:
        if(matrizB[2][3] == true){
        lblLogo12.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[11]))));
        jogada++;
        matriz [2][3] = NimagensV[11];
        if(jogada%2 != 0){
            linha1 = 2;
            coluna1 = 3;
            lblNome1 = 11;
            play("/Sons/Coin");
            matrizB[2][3] = false;
        }else{
            
            linha2 = 2;
            coluna2 = 3;
            lblNome2 = 11;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P12MousePressed

    private void P13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P13MousePressed
        // TODO add your handling code here:
        if(matrizB[3][0] == true){
        lblLogo13.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[12]))));
        jogada++;
        matriz [3][0] = NimagensV[12];
        if(jogada%2 != 0){
            linha1 = 3;
            coluna1 = 0;
            lblNome1 = 12;
            play("/Sons/Coin");
            matrizB[3][0] = false;
        }else{
            
            linha2 = 3;
            coluna2 = 0;
            lblNome2 = 12;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P13MousePressed

    private void P14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P14MousePressed
        // TODO add your handling code here:
        if(matrizB[3][1] == true){
        lblLogo14.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[13]))));
        jogada++;
        matriz [3][1] = NimagensV[13];
        if(jogada%2 != 0){
            linha1 = 3;
            coluna1 = 1;
            lblNome1 = 13;
            play("/Sons/Coin");
            matrizB[3][1] = false;
        }else{
            
            linha2 = 3;
            coluna2 = 1;
            lblNome2 = 13;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P14MousePressed

    private void P15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P15MousePressed
        // TODO add your handling code here:
        if(matrizB[3][2] == true){
        lblLogo15.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[14]))));
        jogada++;
        matriz [3][2] = NimagensV[14];
        if(jogada%2 != 0){
            linha1 = 3;
            coluna1 = 2;
            lblNome1 = 14;
            play("/Sons/Coin");
            matrizB[3][2] = false;
        }else{
            
            linha2 = 3;
            coluna2 = 2;
            lblNome2 = 14;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P15MousePressed

    private void P16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P16MousePressed
        // TODO add your handling code here:
        if(matrizB[3][3] == true){
        lblLogo16.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[15]))));
        jogada++;
        matriz [3][3] = NimagensV[15];
        if(jogada%2 != 0){
            linha1 = 3;
            coluna1 = 3;
            lblNome1 = 15;
            play("/Sons/Coin");
            matrizB[3][3] = false;
        }else{
            
            linha2 = 3;
            coluna2 = 3;
            lblNome2 = 15;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P16MousePressed

    private void P17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P17MousePressed
        // TODO add your handling code here:
        if(matrizB[4][0] == true){
        lblLogo17.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[16]))));
        jogada++;
        matriz [4][0] = NimagensV[16];
        if(jogada%2 != 0){
            linha1 = 4;
            coluna1 = 0;
            lblNome1 = 16;
            play("/Sons/Coin");
            matrizB[4][0] = false;
        }else{
            
            linha2 = 4;
            coluna2 = 0;
            lblNome2 = 16;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P17MousePressed

    private void P18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P18MousePressed
        // TODO add your handling code here:
        if(matrizB[4][1] == true){
        lblLogo18.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[17]))));
        jogada++;
        matriz [4][1] = NimagensV[17];
        if(jogada%2 != 0){
            linha1 = 4;
            coluna1 = 1;
            lblNome1 = 17;
            play("/Sons/Coin");
            matrizB[4][1] = false;
        }else{
            linha2 = 4;
            coluna2 = 1;
            lblNome2 = 17;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P18MousePressed

    private void P19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P19MousePressed
        // TODO add your handling code here:
        if(matrizB[4][2] == true){
        lblLogo19.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[18]))));
        jogada++;
        matriz [4][2] = NimagensV[18];
        if(jogada%2 != 0){
            linha1 = 4;
            coluna1 = 2;
            lblNome1 = 18;
            play("/Sons/Coin");
            matrizB[4][2] = false;
        }else{
            
            linha2 = 4;
            coluna2 = 2;
            lblNome2 = 18;
         
            verificaPar();
        }
        }
    }//GEN-LAST:event_P19MousePressed

    private void P20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P20MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_P20MousePressed

    private void lblLogo20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogo20MousePressed
        // TODO add your handling code here:
        if(matrizB[4][3] == true){
        lblLogo20.setIcon(new javax.swing.ImageIcon(getClass().getResource(cartas.pegaImagePorId(NimagensV[19]))));
        jogada++;
        matriz [4][3] = NimagensV[19];
        if(jogada%2 != 0){
            linha1 = 4;
            coluna1 = 3;
            lblNome1 = 19;
            play("/Sons/Coin");
            matrizB[4][3] = false;
        }else{
            
            linha2 = 4;
            coluna2 = 3;
            lblNome2 = 19;
            verificaPar();
        
        }
        }
    }//GEN-LAST:event_lblLogo20MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel P1;
    private static javax.swing.JPanel P10;
    private static javax.swing.JPanel P11;
    private static javax.swing.JPanel P12;
    private static javax.swing.JPanel P13;
    private static javax.swing.JPanel P14;
    private static javax.swing.JPanel P15;
    private static javax.swing.JPanel P16;
    private static javax.swing.JPanel P17;
    private static javax.swing.JPanel P18;
    private static javax.swing.JPanel P19;
    private static javax.swing.JPanel P2;
    private static javax.swing.JPanel P20;
    private static javax.swing.JPanel P3;
    private static javax.swing.JPanel P4;
    private static javax.swing.JPanel P5;
    private static javax.swing.JPanel P6;
    private static javax.swing.JPanel P7;
    private static javax.swing.JPanel P8;
    private static javax.swing.JPanel P9;
    public static javax.swing.JButton Reflesh;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    public static final javax.swing.JLabel lblLogo1 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo10 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo11 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo12 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo13 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo14 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo15 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo16 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo17 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo18 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo19 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo2 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo20 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo3 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo4 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo5 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo6 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo7 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo8 = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblLogo9 = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables

}
