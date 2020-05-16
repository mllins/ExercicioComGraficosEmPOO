package edu.curso;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Bolinha extends Application {

	class Ponto {
		double x;
		double y;
		double velX = 1;
		double velY = 1;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Group grp = new Group();
		Scene scn = new Scene(grp, 640, 480);
		
		primaryStage.setScene(scn);
		Canvas canvas = new Canvas(640, 480);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		grp.getChildren().add(canvas);
		
		final Ponto p = new Ponto();
		
		new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				ctx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				ctx.setStroke(Color.DARKBLUE);
				ctx.setFill(Color.BLUE);
				ctx.beginPath();
				ctx.fillOval(p.x, p.y, 50, 50);
				p.x += p.velX;
				p.y += p.velY;
				if(p.x > canvas.getWidth() - 50) {
					p.velX = -1;
				}
				if(p.x < 0) {
					p.velX = 1;
				}
				if(p.y > canvas.getHeight() - 50) {
					p.velY = -1;
				}
				if(p.y < 0) {
					p.velY = 1;
				}
			}
			
		}.start();
		
		primaryStage.setTitle("Animação Bolinha");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(Bolinha.class, args);
	}
}
