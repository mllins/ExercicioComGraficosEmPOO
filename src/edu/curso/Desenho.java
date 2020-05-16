package edu.curso;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Desenho extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Group grp = new Group();
		Scene scn = new Scene(grp, 640, 480);

		/********************************************************
		 * Canvas é uma tela gráfica por onde se pode desenhar. *
		 ********************************************************/
		Canvas canvas = new Canvas(640, 480);
		
		/********************************************************
		 * Adiciona ao grupo o objeto canvas.                   *
		 ********************************************************/
		grp.getChildren().add(canvas);
		
		primaryStage.setScene(scn);
		
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		ctx.setStroke(Color.RED);
		ctx.beginPath();			// início de um conjunto de desenhos
		ctx.moveTo(320, 240);
		ctx.lineTo(640, 0);
		ctx.rect(50, 50, 200, 100);
		ctx.stroke();				// firma os desenhos
		ctx.setStroke(Color.BLUE);
		ctx.beginPath();			// novo início
		for(double altura = 0; altura <= 100; altura += 10) {
			double y = 100 - altura / 2;
			ctx.strokeOval(50, y, 200, altura);
		}
		for(double largura = 0; largura <= 200; largura += 10) {
			double x = 150 - largura / 2;
			ctx.strokeOval(x, 50, largura, 100);
		}
		ctx.stroke();				// firma os desenhos
		
		primaryStage.setTitle("Desenho");
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(Desenho.class, args);
	}
	
}
