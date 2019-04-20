package view;

import java.awt.Color;
import javax.swing.JOptionPane;
import model.Dado;
import model.Jogada;
import model.Jogador;
import model.Partida;
import model.TipoJogada;

/**
 *
 * @author Alex Seródio Gonçalves
 */
public class PrincipalUi extends javax.swing.JFrame {

    private Partida partida;
    
    /**
     * Creates new form PrincipalUi
     */
    public PrincipalUi() {
        initComponents();
        initScreen(false);
        player3TextField.setEnabled(false);
        player4TextField.setEnabled(false);
    }

    private void initScreen(boolean isEnable) {
        die1Button.setEnabled(isEnable);
        die2Button.setEnabled(isEnable);
        die3Button.setEnabled(isEnable);
        die4Button.setEnabled(isEnable);
        die5Button.setEnabled(isEnable);
        rollButton.setEnabled(isEnable);
        
        initScorecardFields(isEnable);
        acesTextField.setEnabled(isEnable);
        twosTextField.setEnabled(isEnable);
        threesTextField.setEnabled(isEnable);
        foursTextField.setEnabled(isEnable);
        fivesTextField.setEnabled(isEnable);
        sixesTextField.setEnabled(isEnable);
        threeOfAKindTextField.setEnabled(isEnable);
        fourOfAKindTextField.setEnabled(isEnable);
        fullHouseTextField.setEnabled(isEnable);
        largeStraightTextField.setEnabled(isEnable);
        smallStraightTextField.setEnabled(isEnable);
        yahtzeeTextField.setEnabled(isEnable);
        chanceTextField.setEnabled(isEnable);
        
        MovesPanel.setEnabled(isEnable);
        scorecardPanel.setEnabled(isEnable);
        totalScorePanel.setEnabled(isEnable);
        
        acesTextField.setEditable(false);
        twosTextField.setEditable(false);
        threesTextField.setEditable(false);
        foursTextField.setEditable(false);
        fivesTextField.setEditable(false);
        sixesTextField.setEditable(false);
        threeOfAKindTextField.setEditable(false);
        fourOfAKindTextField.setEditable(false);
        fullHouseTextField.setEditable(false);
        largeStraightTextField.setEditable(false);
        smallStraightTextField.setEditable(false);
        yahtzeeTextField.setEditable(false);
        chanceTextField.setEditable(false);
        
    }
    
    private void initScorecardFields(boolean isEnable) {
        String initialValue = "";
        
        acesButton.setEnabled(isEnable);
        acesTextField.setText(initialValue);
        
        twosButton.setEnabled(isEnable);
        twosTextField.setText(initialValue);
        
        threesButton.setEnabled(isEnable);
        threesTextField.setText(initialValue);
        
        foursButton.setEnabled(isEnable);
        foursTextField.setText(initialValue);
        
        fivesButton.setEnabled(isEnable);
        fivesTextField.setText(initialValue);
        
        sixesButton.setEnabled(isEnable);
        sixesTextField.setText(initialValue);
        
        threeOfAKindButton.setEnabled(isEnable);
        threeOfAKindTextField.setText(initialValue);
        
        fourOfAKindButton.setEnabled(isEnable);
        fourOfAKindTextField.setText(initialValue);
        
        fullHouseButton.setEnabled(isEnable);
        fullHouseTextField.setText(initialValue);
        
        largeStraightButton.setEnabled(isEnable);
        largeStraightTextField.setText(initialValue);
        
        smallStraightButton.setEnabled(isEnable);
        smallStraightTextField.setText(initialValue);
        
        yahtzeeButton.setEnabled(isEnable);
        yahtzeeTextField.setText(initialValue);
        
        chanceButton.setEnabled(isEnable);
        chanceTextField.setText(initialValue);
    }
    
    private void ativaPainelJogadores(boolean estado){
        player1TextField.setEnabled(estado);
        player2TextField.setEnabled(estado);
        player3TextField.setEnabled(estado);
        player4TextField.setEnabled(estado);
        startGameButton.setEnabled(estado);
        numberOfPlayersComboBox.setEnabled(estado);
    }
    
    private void gerenciaJogadas(){
        for(Jogada jogada : partida.jogadorNaVez().getJogadasRealizadas()){
            switch(jogada.getTipoJogada()){
                case JOGADA_DE_1: 
                    acesButton.setEnabled(false);
                    acesTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
                case JOGADA_DE_2: 
                    twosButton.setEnabled(false);
                    twosTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
                case JOGADA_DE_3: 
                    threesButton.setEnabled(false);
                    threesTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
                case JOGADA_DE_4: 
                    foursButton.setEnabled(false);
                    foursTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
                case JOGADA_DE_5: 
                    fivesButton.setEnabled(false);
                    fivesTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
                case JOGADA_DE_6: 
                    sixesButton.setEnabled(false);
                    sixesTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
                case TRINCA: 
                    threeOfAKindButton.setEnabled(false);
                    threeOfAKindTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
                case QUADRA: 
                    fourOfAKindButton.setEnabled(false);
                    fourOfAKindTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
                case FULL_HOUSE: 
                    fullHouseButton.setEnabled(false);
                    fullHouseTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
                case SEQUENCIA_ALTA: 
                    largeStraightButton.setEnabled(false);
                    largeStraightTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
                case SEQUENCIA_BAIXA: 
                    smallStraightButton.setEnabled(false);
                    smallStraightTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
                case GENERAL: 
                    yahtzeeButton.setEnabled(false);
                    yahtzeeTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
                case JOGADA_ALEATORIA: 
                    chanceButton.setEnabled(false);
                    chanceTextField.setText(String.valueOf(jogada.getPontuacao()));
                    break;
            }
        }
    }
    
    private void zeraDados(){
        for(Dado dado : partida.jogadorNaVez().getBandejaDeDados().getDados()){
            dado.setManterDado(false);
            dado.setValor(0);
        }
        Dado [] dados = partida.jogadorNaVez().getBandejaDeDados().getDados();
        die1Button.setText(String.valueOf(dados[0].getValor()));
        die1Button.setForeground(Color.black);
        die2Button.setText(String.valueOf(dados[1].getValor()));
        die2Button.setForeground(Color.black);
        die3Button.setText(String.valueOf(dados[2].getValor()));
        die3Button.setForeground(Color.black);
        die4Button.setText(String.valueOf(dados[3].getValor()));
        die4Button.setForeground(Color.black);
        die5Button.setText(String.valueOf(dados[4].getValor()));
        die5Button.setForeground(Color.black);
    }
    
    private void validaJogada(TipoJogada tipoJogada, javax.swing.JTextField texto){
        if(!partida.jogadorNaVez().isDescartarJogada()){
            try{
                Jogada jogada = new Jogada(tipoJogada, partida.jogadorNaVez().getBandejaDeDados().getDados());
                partida.jogadorNaVez().realizarJogada(jogada);

                texto.setText(String.valueOf(jogada.getPontuacao()));

                partida.proximoJogador();

                partida.jogadorNaVez().setRolagensRestantes(3);
                jogadorNaVezLabel.setText(partida.jogadorNaVez().getNome());

                initScorecardFields(true);
                gerenciaJogadas();
                zeraDados();

                int valor;
                if(partida.getJogadores().length >= 2){
                    valor = partida.getJogadores()[0].calcularPontuacaoJogador();
                    player1ScoreLabel.setText(String.valueOf(valor));
                    valor = partida.getJogadores()[1].calcularPontuacaoJogador();
                    player2ScoreLabel.setText(String.valueOf(valor));
                }
                if(partida.getJogadores().length >= 3){
                    valor = partida.getJogadores()[2].calcularPontuacaoJogador();
                    player3ScoreLabel.setText(String.valueOf(valor));
                }
                if(partida.getJogadores().length == 4){
                    valor = partida.getJogadores()[3].calcularPontuacaoJogador();
                    player4ScoreLabel.setText(String.valueOf(valor));
                }                
            }catch(RuntimeException e){
                JOptionPane.showMessageDialog(null, "Jogada ou dados inválidos. Tente Novamente!");
            }
        }else{
            partida.jogadorNaVez().setDescartarJogada(false);
            Jogada jogada = new Jogada(tipoJogada);
            jogada.setPontuacao(0);
            partida.jogadorNaVez().realizarJogada(jogada);
            
            texto.setText(String.valueOf(jogada.getPontuacao()));

            partida.proximoJogador();

            partida.jogadorNaVez().setRolagensRestantes(3);
            jogadorNaVezLabel.setText(partida.jogadorNaVez().getNome());

            initScorecardFields(true);
            gerenciaJogadas();
            zeraDados();
        }
        
        if(partida.fimPartida())
            JOptionPane.showMessageDialog(null, "Game Over.\n The winner is " + partida.obterJogadorMaiorPontuacao().getNome()  + ".");
        
    }
    
    private void verificaDados(Dado dado, javax.swing.JButton botao){
        try{
            partida.jogadorNaVez().manterDado(dado);
            botao.setForeground(Color.red);
        }
        catch(RuntimeException e){
            JOptionPane.showMessageDialog(null, "You need to roll the dice first.");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playersPanel = new javax.swing.JPanel();
        player1Label = new javax.swing.JLabel();
        player1TextField = new javax.swing.JTextField();
        player2Label = new javax.swing.JLabel();
        player2TextField = new javax.swing.JTextField();
        player3TextField = new javax.swing.JTextField();
        player3Label = new javax.swing.JLabel();
        player4Label = new javax.swing.JLabel();
        player4TextField = new javax.swing.JTextField();
        startGameButton = new javax.swing.JButton();
        numberOfPlayersLabel = new javax.swing.JLabel();
        numberOfPlayersComboBox = new javax.swing.JComboBox<>();
        MovesPanel = new javax.swing.JPanel();
        DicePanel = new javax.swing.JPanel();
        die1Button = new javax.swing.JButton();
        die2Button = new javax.swing.JButton();
        die3Button = new javax.swing.JButton();
        die4Button = new javax.swing.JButton();
        die5Button = new javax.swing.JButton();
        rollButton = new javax.swing.JButton();
        scorecardPanel = new javax.swing.JPanel();
        acesButton = new javax.swing.JButton();
        twosButton = new javax.swing.JButton();
        threesButton = new javax.swing.JButton();
        foursButton = new javax.swing.JButton();
        fivesButton = new javax.swing.JButton();
        sixesButton = new javax.swing.JButton();
        threeOfAKindButton = new javax.swing.JButton();
        fourOfAKindButton = new javax.swing.JButton();
        fullHouseButton = new javax.swing.JButton();
        largeStraightButton = new javax.swing.JButton();
        smallStraightButton = new javax.swing.JButton();
        yahtzeeButton = new javax.swing.JButton();
        chanceButton = new javax.swing.JButton();
        acesTextField = new javax.swing.JTextField();
        twosTextField = new javax.swing.JTextField();
        threesTextField = new javax.swing.JTextField();
        foursTextField = new javax.swing.JTextField();
        fivesTextField = new javax.swing.JTextField();
        sixesTextField = new javax.swing.JTextField();
        threeOfAKindTextField = new javax.swing.JTextField();
        fourOfAKindTextField = new javax.swing.JTextField();
        fullHouseTextField = new javax.swing.JTextField();
        largeStraightTextField = new javax.swing.JTextField();
        smallStraightTextField = new javax.swing.JTextField();
        yahtzeeTextField = new javax.swing.JTextField();
        chanceTextField = new javax.swing.JTextField();
        totalScorePanel = new javax.swing.JPanel();
        player1Name_socreLabel = new javax.swing.JLabel();
        player2Name_scoreLabel = new javax.swing.JLabel();
        player3Name_scoreLabel = new javax.swing.JLabel();
        player4Name_scoreLabel = new javax.swing.JLabel();
        player1ScoreLabel = new javax.swing.JLabel();
        player2ScoreLabel = new javax.swing.JLabel();
        player3ScoreLabel = new javax.swing.JLabel();
        player4ScoreLabel = new javax.swing.JLabel();
        playerRoundLabel = new javax.swing.JLabel();
        jogadorNaVezLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Yahtzee");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        playersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Players"));

        player1Label.setText("Player 1:");

        player2Label.setText("Player 2:");

        player3Label.setText("Player 3:");

        player4Label.setText("Player 4:");

        startGameButton.setText("Start game");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });

        numberOfPlayersLabel.setText("Number of players:");

        numberOfPlayersComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 players", "3 players", "4 players" }));
        numberOfPlayersComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfPlayersComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout playersPanelLayout = new javax.swing.GroupLayout(playersPanel);
        playersPanel.setLayout(playersPanelLayout);
        playersPanelLayout.setHorizontalGroup(
            playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playersPanelLayout.createSequentialGroup()
                        .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(playersPanelLayout.createSequentialGroup()
                                .addComponent(player3Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(player3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(playersPanelLayout.createSequentialGroup()
                                .addComponent(player1Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(player1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(playersPanelLayout.createSequentialGroup()
                                        .addComponent(player4Label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(player4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(playersPanelLayout.createSequentialGroup()
                                        .addComponent(player2Label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(player2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(startGameButton))
                    .addGroup(playersPanelLayout.createSequentialGroup()
                        .addComponent(numberOfPlayersLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numberOfPlayersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        playersPanelLayout.setVerticalGroup(
            playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfPlayersLabel)
                    .addComponent(numberOfPlayersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playersPanelLayout.createSequentialGroup()
                        .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(player1Label)
                                .addComponent(player1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(playersPanelLayout.createSequentialGroup()
                                .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(player2Label)
                                    .addComponent(player2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(player3Label)
                                        .addComponent(player3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(player4Label)
                                        .addComponent(player4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playersPanelLayout.createSequentialGroup()
                        .addComponent(startGameButton)
                        .addGap(33, 33, 33))))
        );

        MovesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Move"));

        DicePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        die1Button.setBackground(new java.awt.Color(255, 255, 255));
        die1Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        die1Button.setText("0");
        die1Button.setToolTipText("Manter dado");
        die1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                die1ButtonActionPerformed(evt);
            }
        });

        die2Button.setBackground(new java.awt.Color(255, 255, 255));
        die2Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        die2Button.setText("0");
        die2Button.setToolTipText("Manter dado");
        die2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                die2ButtonActionPerformed(evt);
            }
        });

        die3Button.setBackground(new java.awt.Color(255, 255, 255));
        die3Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        die3Button.setText("0");
        die3Button.setToolTipText("Manter dado");
        die3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                die3ButtonActionPerformed(evt);
            }
        });

        die4Button.setBackground(new java.awt.Color(255, 255, 255));
        die4Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        die4Button.setText("0");
        die4Button.setToolTipText("Manter dado");
        die4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                die4ButtonActionPerformed(evt);
            }
        });

        die5Button.setBackground(new java.awt.Color(255, 255, 255));
        die5Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        die5Button.setText("0");
        die5Button.setToolTipText("Manter dado");
        die5Button.setBorder(null);
        die5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                die5ButtonActionPerformed(evt);
            }
        });

        rollButton.setText("Roll");
        rollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DicePanelLayout = new javax.swing.GroupLayout(DicePanel);
        DicePanel.setLayout(DicePanelLayout);
        DicePanelLayout.setHorizontalGroup(
            DicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DicePanelLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(die1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(die2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(die3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(die4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(die5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rollButton)
                .addGap(54, 54, 54))
        );
        DicePanelLayout.setVerticalGroup(
            DicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(die1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(die2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(die3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(die4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(die5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rollButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scorecardPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Scorecard"));

        acesButton.setText("Aces");
        acesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acesButtonActionPerformed(evt);
            }
        });

        twosButton.setText("Twos");
        twosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twosButtonActionPerformed(evt);
            }
        });

        threesButton.setText("Threes");
        threesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threesButtonActionPerformed(evt);
            }
        });

        foursButton.setText("Fours");
        foursButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foursButtonActionPerformed(evt);
            }
        });

        fivesButton.setText("Fives");
        fivesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fivesButtonActionPerformed(evt);
            }
        });

        sixesButton.setText("Sixes");
        sixesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixesButtonActionPerformed(evt);
            }
        });

        threeOfAKindButton.setText("Three Of A Kind");
        threeOfAKindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeOfAKindButtonActionPerformed(evt);
            }
        });

        fourOfAKindButton.setText("Four Of A Kind");
        fourOfAKindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourOfAKindButtonActionPerformed(evt);
            }
        });

        fullHouseButton.setText("Full House");
        fullHouseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullHouseButtonActionPerformed(evt);
            }
        });

        largeStraightButton.setText("Large Straight");
        largeStraightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largeStraightButtonActionPerformed(evt);
            }
        });

        smallStraightButton.setText("Small Straight");
        smallStraightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallStraightButtonActionPerformed(evt);
            }
        });

        yahtzeeButton.setText("Yahtzee");
        yahtzeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yahtzeeButtonActionPerformed(evt);
            }
        });

        chanceButton.setText("Chance");
        chanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chanceButtonActionPerformed(evt);
            }
        });

        acesTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        twosTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        threesTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        foursTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        fivesTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        sixesTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        threeOfAKindTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        fourOfAKindTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        fullHouseTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        largeStraightTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        smallStraightTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        yahtzeeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        chanceTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout scorecardPanelLayout = new javax.swing.GroupLayout(scorecardPanel);
        scorecardPanel.setLayout(scorecardPanelLayout);
        scorecardPanelLayout.setHorizontalGroup(
            scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scorecardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(scorecardPanelLayout.createSequentialGroup()
                        .addComponent(chanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chanceTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorecardPanelLayout.createSequentialGroup()
                        .addComponent(yahtzeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(yahtzeeTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorecardPanelLayout.createSequentialGroup()
                        .addComponent(smallStraightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(smallStraightTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorecardPanelLayout.createSequentialGroup()
                        .addComponent(largeStraightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(largeStraightTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorecardPanelLayout.createSequentialGroup()
                        .addComponent(fullHouseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fullHouseTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorecardPanelLayout.createSequentialGroup()
                        .addComponent(fourOfAKindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fourOfAKindTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorecardPanelLayout.createSequentialGroup()
                        .addComponent(threeOfAKindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(threeOfAKindTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorecardPanelLayout.createSequentialGroup()
                        .addComponent(sixesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sixesTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorecardPanelLayout.createSequentialGroup()
                        .addComponent(fivesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fivesTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorecardPanelLayout.createSequentialGroup()
                        .addComponent(foursButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(foursTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorecardPanelLayout.createSequentialGroup()
                        .addComponent(threesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(threesTextField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scorecardPanelLayout.createSequentialGroup()
                        .addComponent(twosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(twosTextField))
                    .addGroup(scorecardPanelLayout.createSequentialGroup()
                        .addComponent(acesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(acesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        scorecardPanelLayout.setVerticalGroup(
            scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scorecardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acesButton)
                    .addComponent(acesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(twosButton)
                    .addComponent(twosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(threesButton)
                    .addComponent(threesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(foursButton)
                    .addComponent(foursTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fivesButton)
                    .addComponent(fivesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sixesButton)
                    .addComponent(sixesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(threeOfAKindButton)
                    .addComponent(threeOfAKindTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fourOfAKindButton)
                    .addComponent(fourOfAKindTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullHouseButton)
                    .addComponent(fullHouseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(largeStraightButton)
                    .addComponent(largeStraightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(smallStraightButton)
                    .addComponent(smallStraightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yahtzeeButton)
                    .addComponent(yahtzeeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scorecardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chanceButton)
                    .addComponent(chanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        totalScorePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Total score"));

        player1Name_socreLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        player1Name_socreLabel.setText("               ");

        player2Name_scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        player2Name_scoreLabel.setText("               ");

        player3Name_scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        player3Name_scoreLabel.setText("               ");

        player4Name_scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        player4Name_scoreLabel.setText("               ");

        player1ScoreLabel.setText(" ");

        player2ScoreLabel.setText(" ");

        player3ScoreLabel.setText(" ");

        player4ScoreLabel.setText(" ");

        javax.swing.GroupLayout totalScorePanelLayout = new javax.swing.GroupLayout(totalScorePanel);
        totalScorePanel.setLayout(totalScorePanelLayout);
        totalScorePanelLayout.setHorizontalGroup(
            totalScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalScorePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(player2Name_scoreLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(player3Name_scoreLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(player4Name_scoreLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(player1Name_socreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(totalScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player1ScoreLabel)
                    .addComponent(player2ScoreLabel)
                    .addComponent(player3ScoreLabel)
                    .addComponent(player4ScoreLabel))
                .addGap(31, 31, 31))
        );
        totalScorePanelLayout.setVerticalGroup(
            totalScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalScorePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1Name_socreLabel)
                    .addComponent(player1ScoreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player2ScoreLabel)
                    .addComponent(player2Name_scoreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player3ScoreLabel)
                    .addComponent(player3Name_scoreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(totalScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player4ScoreLabel)
                    .addComponent(player4Name_scoreLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        playerRoundLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        playerRoundLabel.setForeground(new java.awt.Color(0, 153, 0));
        playerRoundLabel.setText("Player round:");

        jogadorNaVezLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jogadorNaVezLabel.setForeground(new java.awt.Color(0, 153, 0));
        jogadorNaVezLabel.setText("             ");

        javax.swing.GroupLayout MovesPanelLayout = new javax.swing.GroupLayout(MovesPanel);
        MovesPanel.setLayout(MovesPanelLayout);
        MovesPanelLayout.setHorizontalGroup(
            MovesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MovesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MovesPanelLayout.createSequentialGroup()
                        .addComponent(scorecardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(totalScorePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(MovesPanelLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(playerRoundLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jogadorNaVezLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MovesPanelLayout.setVerticalGroup(
            MovesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovesPanelLayout.createSequentialGroup()
                .addGroup(MovesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerRoundLabel)
                    .addComponent(jogadorNaVezLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MovesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scorecardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalScorePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MovesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MovesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sixesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixesButtonActionPerformed
        validaJogada(TipoJogada.JOGADA_DE_6, sixesTextField);
    }//GEN-LAST:event_sixesButtonActionPerformed

    private void instanciaJogador1e2(){
        Jogador jogador;
        initScreen(true);
        ativaPainelJogadores(false);
        
        partida = new Partida();
        
        jogador = new Jogador(player1TextField.getText());
        partida.inserirJogador(jogador);
        player1Name_socreLabel.setText(jogador.getNome());
        player1ScoreLabel.setText(String.valueOf(0));

        jogador = new Jogador(player2TextField.getText());
        partida.inserirJogador(jogador);
        player2Name_scoreLabel.setText(jogador.getNome());
        player2ScoreLabel.setText(String.valueOf(0));
        
        jogadorNaVezLabel.setText(partida.jogadorNaVez().getNome());
    }
    
    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameButtonActionPerformed
        final String message = "You must fill in all available fields to start a game.";
        
        if(numberOfPlayersComboBox.getSelectedIndex() == 0){
            if(!player1TextField.getText().isEmpty() && !player2TextField.getText().isEmpty())
                instanciaJogador1e2();
            else
                JOptionPane.showMessageDialog(null, message);         
        }
        if(numberOfPlayersComboBox.getSelectedIndex() == 1){
            if(!player1TextField.getText().isEmpty() && !player2TextField.getText().isEmpty()){
                if(!player3TextField.getText().isEmpty()){
                    instanciaJogador1e2();
                    Jogador jogador = new Jogador(player3TextField.getText());
                    partida.inserirJogador(jogador);

                    player3Name_scoreLabel.setText(jogador.getNome());
                    player3ScoreLabel.setText(String.valueOf(0));
                }else{
                    JOptionPane.showMessageDialog(null, message);
                }
            }else{
                JOptionPane.showMessageDialog(null, message);
            }
        }
        if(numberOfPlayersComboBox.getSelectedIndex() == 2){
            if(!player1TextField.getText().isEmpty() && !player2TextField.getText().isEmpty()){
                if(!player4TextField.getText().isEmpty()){
                    instanciaJogador1e2();
                    Jogador jogador = new Jogador(player3TextField.getText());
                    partida.inserirJogador(jogador);

                    player3Name_scoreLabel.setText(jogador.getNome());
                    player3ScoreLabel.setText(String.valueOf(0));
                }else{
                    JOptionPane.showMessageDialog(null, message);
                }
            }else{
                JOptionPane.showMessageDialog(null, message);
            }
        }
    }//GEN-LAST:event_startGameButtonActionPerformed

    private void rollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollButtonActionPerformed
        try{
            partida.jogadorNaVez().arremessarDados();
        
            Dado[] dados = partida.jogadorNaVez().getBandejaDeDados().getDados();
            
            die1Button.setText(String.valueOf(dados[0].getValor()));
            die2Button.setText(String.valueOf(dados[1].getValor()));
            die3Button.setText(String.valueOf(dados[2].getValor()));
            die4Button.setText(String.valueOf(dados[3].getValor()));
            die5Button.setText(String.valueOf(dados[4].getValor()));
            
        }catch(RuntimeException e){
            JOptionPane.showMessageDialog(null, "Your rolls are over. Select a move.");
        } 
        
        try{
            partida.jogadorNaVez().verificarJogadasPossiveis();
        }catch(RuntimeException e){
            JOptionPane.showMessageDialog(null, "There are no more possible moves. Select a play you want to discard.");
        }
    }//GEN-LAST:event_rollButtonActionPerformed

    private void die1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_die1ButtonActionPerformed
        Dado dado = partida.jogadorNaVez().getBandejaDeDados().getDados()[0];
        verificaDados(dado, die1Button);
    }//GEN-LAST:event_die1ButtonActionPerformed

    private void die2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_die2ButtonActionPerformed
        Dado dado = partida.jogadorNaVez().getBandejaDeDados().getDados()[1];
        verificaDados(dado, die2Button);
    }//GEN-LAST:event_die2ButtonActionPerformed

    private void die3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_die3ButtonActionPerformed
        Dado dado = partida.jogadorNaVez().getBandejaDeDados().getDados()[2];
        verificaDados(dado, die3Button);
    }//GEN-LAST:event_die3ButtonActionPerformed

    private void die4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_die4ButtonActionPerformed
        Dado dado = partida.jogadorNaVez().getBandejaDeDados().getDados()[3];
        verificaDados(dado, die4Button);
    }//GEN-LAST:event_die4ButtonActionPerformed

    private void die5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_die5ButtonActionPerformed
        Dado dado = partida.jogadorNaVez().getBandejaDeDados().getDados()[4];
        verificaDados(dado, die5Button);
    }//GEN-LAST:event_die5ButtonActionPerformed

    private void acesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acesButtonActionPerformed
        validaJogada(TipoJogada.JOGADA_DE_1, acesTextField);
    }//GEN-LAST:event_acesButtonActionPerformed

    private void twosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twosButtonActionPerformed
        validaJogada(TipoJogada.JOGADA_DE_2, twosTextField);
    }//GEN-LAST:event_twosButtonActionPerformed

    private void threesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threesButtonActionPerformed
        validaJogada(TipoJogada.JOGADA_DE_3, threesTextField);
    }//GEN-LAST:event_threesButtonActionPerformed

    private void foursButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foursButtonActionPerformed
        validaJogada(TipoJogada.JOGADA_DE_4, foursTextField);
    }//GEN-LAST:event_foursButtonActionPerformed

    private void fivesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fivesButtonActionPerformed
        validaJogada(TipoJogada.JOGADA_DE_5, fivesTextField);
    }//GEN-LAST:event_fivesButtonActionPerformed

    private void threeOfAKindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeOfAKindButtonActionPerformed
        validaJogada(TipoJogada.TRINCA, threeOfAKindTextField);
    }//GEN-LAST:event_threeOfAKindButtonActionPerformed

    private void fourOfAKindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourOfAKindButtonActionPerformed
        validaJogada(TipoJogada.QUADRA, fourOfAKindTextField);
    }//GEN-LAST:event_fourOfAKindButtonActionPerformed

    private void fullHouseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullHouseButtonActionPerformed
        validaJogada(TipoJogada.FULL_HOUSE, fullHouseTextField);
    }//GEN-LAST:event_fullHouseButtonActionPerformed

    private void largeStraightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_largeStraightButtonActionPerformed
        validaJogada(TipoJogada.SEQUENCIA_ALTA, largeStraightTextField);
    }//GEN-LAST:event_largeStraightButtonActionPerformed

    private void smallStraightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallStraightButtonActionPerformed
        validaJogada(TipoJogada.SEQUENCIA_BAIXA, smallStraightTextField);
    }//GEN-LAST:event_smallStraightButtonActionPerformed

    private void yahtzeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yahtzeeButtonActionPerformed
        validaJogada(TipoJogada.GENERAL, yahtzeeTextField);
    }//GEN-LAST:event_yahtzeeButtonActionPerformed

    private void chanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chanceButtonActionPerformed
        validaJogada(TipoJogada.JOGADA_ALEATORIA, chanceTextField);
    }//GEN-LAST:event_chanceButtonActionPerformed

    private void numberOfPlayersComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfPlayersComboBoxActionPerformed
        switch (numberOfPlayersComboBox.getSelectedIndex()) {
            case 0:
                player1TextField.setEnabled(true);
                player2TextField.setEnabled(true);
                player3TextField.setEnabled(false);
                player4TextField.setEnabled(false);
                player3TextField.setText(null);
                player4TextField.setText(null);
                break;
            case 1:
                player1TextField.setEnabled(true);
                player2TextField.setEnabled(true);
                player3TextField.setEnabled(true);
                player4TextField.setEnabled(false);
                player4TextField.setText(null);
                break;
            case 2:
                player1TextField.setEnabled(true);
                player2TextField.setEnabled(true);
                player3TextField.setEnabled(true);
                player4TextField.setEnabled(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_numberOfPlayersComboBoxActionPerformed
    
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
            java.util.logging.Logger.getLogger(PrincipalUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalUi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DicePanel;
    private javax.swing.JPanel MovesPanel;
    private javax.swing.JButton acesButton;
    private javax.swing.JTextField acesTextField;
    private javax.swing.JButton chanceButton;
    private javax.swing.JTextField chanceTextField;
    private javax.swing.JButton die1Button;
    private javax.swing.JButton die2Button;
    private javax.swing.JButton die3Button;
    private javax.swing.JButton die4Button;
    private javax.swing.JButton die5Button;
    private javax.swing.JButton fivesButton;
    private javax.swing.JTextField fivesTextField;
    private javax.swing.JButton fourOfAKindButton;
    private javax.swing.JTextField fourOfAKindTextField;
    private javax.swing.JButton foursButton;
    private javax.swing.JTextField foursTextField;
    private javax.swing.JButton fullHouseButton;
    private javax.swing.JTextField fullHouseTextField;
    private javax.swing.JLabel jogadorNaVezLabel;
    private javax.swing.JButton largeStraightButton;
    private javax.swing.JTextField largeStraightTextField;
    private javax.swing.JComboBox<String> numberOfPlayersComboBox;
    private javax.swing.JLabel numberOfPlayersLabel;
    private javax.swing.JLabel player1Label;
    private javax.swing.JLabel player1Name_socreLabel;
    private javax.swing.JLabel player1ScoreLabel;
    private javax.swing.JTextField player1TextField;
    private javax.swing.JLabel player2Label;
    private javax.swing.JLabel player2Name_scoreLabel;
    private javax.swing.JLabel player2ScoreLabel;
    private javax.swing.JTextField player2TextField;
    private javax.swing.JLabel player3Label;
    private javax.swing.JLabel player3Name_scoreLabel;
    private javax.swing.JLabel player3ScoreLabel;
    private javax.swing.JTextField player3TextField;
    private javax.swing.JLabel player4Label;
    private javax.swing.JLabel player4Name_scoreLabel;
    private javax.swing.JLabel player4ScoreLabel;
    private javax.swing.JTextField player4TextField;
    private javax.swing.JLabel playerRoundLabel;
    private javax.swing.JPanel playersPanel;
    private javax.swing.JButton rollButton;
    private javax.swing.JPanel scorecardPanel;
    private javax.swing.JButton sixesButton;
    private javax.swing.JTextField sixesTextField;
    private javax.swing.JButton smallStraightButton;
    private javax.swing.JTextField smallStraightTextField;
    private javax.swing.JButton startGameButton;
    private javax.swing.JButton threeOfAKindButton;
    private javax.swing.JTextField threeOfAKindTextField;
    private javax.swing.JButton threesButton;
    private javax.swing.JTextField threesTextField;
    private javax.swing.JPanel totalScorePanel;
    private javax.swing.JButton twosButton;
    private javax.swing.JTextField twosTextField;
    private javax.swing.JButton yahtzeeButton;
    private javax.swing.JTextField yahtzeeTextField;
    // End of variables declaration//GEN-END:variables
}