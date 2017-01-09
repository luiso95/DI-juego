import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Interfaz extends JFrame implements ActionListener{
	
	private DrawCanvas canvas;
	Conecta4 con = new Conecta4();
	JTextArea texto;
	
	JButton buttonReiniciar;
	JButton buttonSalir;
	
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	
	
	public Interfaz (){
		super("Conecta 4");
		iniciarGUI();
		
	}
	
	public void iniciarGUI(){
		
		//Encabezado
		JPanel panelHead = new JPanel();
		
		JLabel head = new JLabel(" Conecta 4 ");
		
		panelHead.add(head);
		
		
		//Dibujar Tablero
		JPanel panelTablero = new JPanel(new GridLayout(1,2));
		
		
		JPanel panelInsertFicha = new JPanel();
		
		b1 = new JButton("T");
		b1.addActionListener(this);
		b1.setActionCommand("I1");
		b2 = new JButton("T");
		b2.addActionListener(this);
		b2.setActionCommand("I2");
		b3 = new JButton("T");
		b3.addActionListener(this);
		b3.setActionCommand("I3");
		b4 = new JButton("T");
		b4.addActionListener(this);
		b4.setActionCommand("I4");
		b5 = new JButton("T");
		b5.addActionListener(this);
		b5.setActionCommand("I5");
		b6 = new JButton("T");
		b6.addActionListener(this);
		b6.setActionCommand("I6");
		b7 = new JButton("T");
		b7.addActionListener(this);
		b7.setActionCommand("I7");
		b8 = new JButton("T");
		b8.addActionListener(this);
		b8.setActionCommand("I8");
		
		panelInsertFicha.add(b1);
		panelInsertFicha.add(b2);
		panelInsertFicha.add(b3);
		panelInsertFicha.add(b4);
		panelInsertFicha.add(b5);
		panelInsertFicha.add(b6);
		panelInsertFicha.add(b7);
		panelInsertFicha.add(b8);
		
		
		canvas = new DrawCanvas();    // Create the drawing canvas
		
		JPanel union = new JPanel(new BorderLayout());
		union.add(panelInsertFicha, BorderLayout.PAGE_START);
		union.add(canvas, BorderLayout.CENTER);
	    panelTablero.add(union);
		
		//Texto
		texto = new JTextArea();
		JScrollPane scroll = new JScrollPane(texto);
		
		panelTablero.add(scroll);
		
		
		//Botones
		JPanel panelButton = new JPanel();
		
		JButton buttonReiniciar = new JButton("Reiniciar");
		JButton buttonSalir = new JButton("Salir");
		
		buttonReiniciar.addActionListener(this);
		buttonReiniciar.setActionCommand("ButtonReiniciar");
		buttonSalir.addActionListener(this);
		buttonSalir.setActionCommand("ButtonSalir");
		
		panelButton.add(buttonReiniciar);
		panelButton.add(buttonSalir);
		
		
		//Añadimos los paneles a la interfaz
		add(panelHead, BorderLayout.PAGE_START);
		add(panelTablero, BorderLayout.CENTER);
		add(panelButton, BorderLayout.PAGE_END);
		
		
		
		
		
		setSize(810,530);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}
	
	
	//Operacionesa realizar por los botones
	public void actionPerformed(ActionEvent e){
		
		if(e.getActionCommand().equals("ButtonReiniciar")){
			
			reiniciar();
		}
		else if(e.getActionCommand().equals("ButtonSalir")){
			
			salir();
		}
		else if(e.getActionCommand().equals("I1")){
			ponerFicha(0);
		}
		else if(e.getActionCommand().equals("I2")){
			ponerFicha(1);
		}
		else if(e.getActionCommand().equals("I3")){
			ponerFicha(2);
		}
		else if(e.getActionCommand().equals("I4")){
			ponerFicha(3);
		}
		else if(e.getActionCommand().equals("I5")){
			ponerFicha(4);
		}
		else if(e.getActionCommand().equals("I6")){
			ponerFicha(5);
		}
		else if(e.getActionCommand().equals("I7")){
			ponerFicha(6);
		}
		else if(e.getActionCommand().equals("I8")){
			ponerFicha(7);
		}
		
		
		
	}
	
	//Poner ficha, dependiendo de la columna en la que queramos poner la ficha
	public void ponerFicha(int columna){
		int victory = 0;
		texto.append("El jugador "+this.con.jugador+" pone ficha en la columna "+columna+"\n");
		if(this.con.tablero[7][columna]==Casilla.LIBRE){
			this.con.tablero[7][columna]=pintarJugador();
			this.repaint();
			victory=this.con.victoria(7,columna);
			cambiarJugador();
		}
		else if(this.con.tablero[6][columna]==Casilla.LIBRE){
			this.con.tablero[6][columna]=pintarJugador();
			this.repaint();
			victory=this.con.victoria(6,columna);
			cambiarJugador();
		}
		else if(this.con.tablero[5][columna]==Casilla.LIBRE){
			this.con.tablero[5][columna]=pintarJugador();
			this.repaint();
			victory=this.con.victoria(5,columna);
			cambiarJugador();
		}
		else if(this.con.tablero[4][columna]==Casilla.LIBRE){
			this.con.tablero[4][columna]=pintarJugador();
			this.repaint();
			victory=this.con.victoria(4,columna);
			cambiarJugador();
		}
		else if(this.con.tablero[3][columna]==Casilla.LIBRE){
			this.con.tablero[3][columna]=pintarJugador();
			this.repaint();
			victory=this.con.victoria(3,columna);
			cambiarJugador();
		}
		else if(this.con.tablero[2][columna]==Casilla.LIBRE){
			this.con.tablero[2][columna]=pintarJugador();
			this.repaint();
			victory=this.con.victoria(2,columna);
			cambiarJugador();
		}
		else if(this.con.tablero[1][columna]==Casilla.LIBRE){
			this.con.tablero[1][columna]=pintarJugador();
			this.repaint();
			victory=this.con.victoria(1,columna);
			cambiarJugador();
		}
		else if(this.con.tablero[0][columna]==Casilla.LIBRE){
			this.con.tablero[0][columna]=pintarJugador();
			this.repaint();
			victory=this.con.victoria(0,columna);
			cambiarJugador();
		}
		else{
			texto.append("Column Taken");
		}
		
		if(victory==1){
			texto.append("Player "+this.con.jugador+" win.");
			JOptionPane.showMessageDialog(this, "El Jugador "+this.con.jugador+" ha ganado la partida.\nApreta aceptar para reiniciar.");
			reiniciar();
		}
		
	}
	
	public void reiniciar(){
		
		
		//Reiniciar
		
		this.con.vacia();
		this.borrarLista();
		this.con.jugador=1;
		this.repaint();
	}
	
	//Limpiar el texto
	public void borrarLista(){
		this.texto.setText("");
		
	}
	
	//Cerrar la aplicacion
	public void salir(){
		System.exit(0);
	}
	
	//Colocar la ficha en la casilla seleccionada por el jugador
	public Casilla pintarJugador(){
		Casilla c = Casilla.LIBRE;
		if(this.con.jugador==1){
			c=Casilla.JUGADOR1;
		}
		else{
			c=Casilla.JUGADOR2;
		}
		
		return c;
	}
	
	//Tras un movimiento aceptado se cambia de jugador
	public void cambiarJugador(){
		if(this.con.jugador==1){
			this.con.jugador=2;
		}
		else{
			this.con.jugador=1;
		}
	}


	
	/**
	    * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
	    */
	   private class DrawCanvas extends JPanel {
	      // Override paintComponent to perform your own painting
	      @Override
	      public void paintComponent(Graphics g) {
	         super.paintComponent(g);     // paint parent's background
	         setBackground(Color.BLUE);  // set background color for this JPanel
	 
	         g.fillRect(0,0,8,8);
	         
	         int fila = 10;
	         int columna = 10;
	         
	         
	         for(int f = 0; f<8;f++){
	        	 for(int c=0;c<8;c++){
	        		 if(Interfaz.this.con.getCasilla(c,f) == Casilla.LIBRE){
	        		 g.setColor(Color.WHITE);
	        		 g.fillOval(fila, columna, 45, 45);
	        		 fila +=48;
	        	 }
	        		 else if(Interfaz.this.con.getCasilla(c,f) == Casilla.JUGADOR1){
		        		 g.setColor(Color.YELLOW);
		        		 g.fillOval(fila, columna, 45, 45);
		        		 fila +=48;
		        	 }
	        		 else{
		        		 g.setColor(Color.RED);
		        		 g.fillOval(fila, columna, 45, 45);
		        		 fila +=48;
		        	 }
	        		 
	        		 
	        	 }
	        	 fila=10;
	        	 columna += 48;
	        	 
	         }

	      }
	   }

	   
	   public static void main (String [] args){
			
			Interfaz s = new Interfaz();
			s.setVisible(true);
		}

}
	


