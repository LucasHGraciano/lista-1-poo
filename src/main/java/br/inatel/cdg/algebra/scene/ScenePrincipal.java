package br.inatel.cdg.algebra.scene;

import br.inatel.cdg.algebra.reta.Ponto;
import br.inatel.cdg.algebra.reta.Reta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button btnCalcCoefAngular, btnCalcCoefLinear; //Button representa botoes
    private Label lblP1X, lblP1Y, lblP2X, lblP2Y; //Label representa rótulos
    private TextField txtP1X,txtP1Y,txtP2X,txtP2Y, txtCoefAngular, txtCoefLinear; //TextField Representam áreas de texto

    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        lblP1X = new Label("Ponto P1.X"); //rótulos
        txtP1X = new TextField(); //área de texto

        lblP1Y = new Label("Ponto P1.Y");
        txtP1Y = new TextField();

        lblP2X = new Label("Ponto P2.X");
        txtP2X = new TextField();

        lblP2Y = new Label("Ponto P2.Y");
        txtP2Y = new TextField();

        //HBox é usado para agrupar elementos horizontalmente
        VBox vboxP1X = new VBox(lblP1X, txtP1X); //Criamos quatro grupos verticais com Rótulo e Área de Texto para a coordenada
        VBox vboxP1Y = new VBox(lblP1Y, txtP1Y);
        VBox vboxP2X = new VBox(lblP2X, txtP2X);
        VBox vboxP2Y = new VBox(lblP2Y, txtP2Y);

        //HBox é usada para agrupar elementos horizontal
        //No construtor passamos todos os elementos que serão agrupados
        VBox vboxEntradaCoord = new VBox(vboxP1X,vboxP1Y,vboxP2X,vboxP2Y);//Aqui vamos agrupar verticalmente os pontos para o usuário entrar com as coordenadas dos pontos

        //Caixas de texto que apresentaremos o resultado
        txtCoefAngular = new TextField();
        txtCoefAngular.setEditable(false);//Observe que deixamos "false" para evitar do usuário digitar alguma coisa nessas caixas
        txtCoefAngular.setText("Coef Angular: ");

        txtCoefLinear = new TextField();
        txtCoefLinear.setEditable(false);
        txtCoefLinear.setText("Coef Linear: ");

        //Agrupas as áreas onde apresentaremos o resultado
        HBox hboxRespostas = new HBox(txtCoefAngular,txtCoefLinear);

        //Criamos o botão
        btnCalcCoefAngular = new Button("Calcula CA");
        //Criamos a ação que o botão responderá as ser pressionado
        btnCalcCoefAngular.setOnAction(evento -> {
            Reta reta = construirReta();
            txtCoefAngular.setText("Coef Angular: " + reta.calcCoeficienteAngular());//Acessamos o componente textCoefAngular para colocar o resultado do cálculo
        });

        btnCalcCoefLinear = new Button("Calcula CL");
        btnCalcCoefLinear.setOnAction(evento -> {
            Reta reta = construirReta();
            txtCoefLinear.setText("Coef Linear: " + reta.calcCoeficienteLinear());
        });

        //Agrupamos os botões horizontalmente
        HBox hBoxBotoes = new HBox(btnCalcCoefAngular,btnCalcCoefLinear);

        //Finalmente criamo o layout vertical final!
        VBox layoutFinal = new VBox(vboxEntradaCoord,hBoxBotoes,hboxRespostas);

        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 500 , 500);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

    //Função interna que cria uma reta!
    private Reta construirReta(){
        Ponto p1 = new Ponto(Double.parseDouble(txtP1X.getText()),
                Double.parseDouble(txtP1Y.getText()));

        Ponto p2 = new Ponto(Double.parseDouble(txtP2X.getText()),
                Double.parseDouble(txtP2Y.getText()));

        Reta reta = new Reta(p1,p2);
        return reta;
    }
}
