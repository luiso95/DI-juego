
public class Conecta4 {
	
	public Casilla[][] tablero;
	int numFil;
	int numCol;
	int jugador;
	
	public Conecta4(){
		
		this.numFil = 8;
		this.numCol = 8;
		this.jugador = 1;
		this.tablero = new Casilla[numFil][numCol];
		vacia();
		/*When you want to test the reset before the buttona are implemented
		 * int e = (int) (Math.random()*8);
		this.tablero[e][e] = Casilla.JUGADOR1;*/
	}
	
	//Buscar el contenido de una casilla especifica
	public Casilla getCasilla(int c, int f){
		return this.tablero[f][c];
	}
	
	//Poner una ficha del jugador que está moviendo
	public int ponFicha(int c){
		int f = hayEspacio(c);
		if(f !=1){
			if(this.jugador == 1){
				this.tablero[f][c] = Casilla.JUGADOR1;
				this.jugador=2;
			}
			else{
				this.tablero[f][c] = Casilla.JUGADOR2;
				this.jugador=1;
			}
		}
		
		return f;
	}
	
	//Comprobar que hay espacio en la columna para una nueva ficha
	public int hayEspacio(int c){
		if(!columnaValida(c)){
			return -1;
		}
		int f = 0;
		while((filaValida(f)) && (this.tablero[f][c] == Casilla.LIBRE)){
			f++;
		}
		if (filaValida(f - 1)){
			return f-1;
		}
		return -1;		
		
	}
	
	//Comprobar que la fila existe
	private boolean filaValida(int f){
		return (f >= 0) && (f < this.numFil);
	}
	
	//Comprobar que la columna existe
	private boolean columnaValida(int c){
		return (c >=0) && (c < this.numCol);
	}
	
	//Creamos un tablero vacio
	public void vacia(){
		this.tablero = new Casilla[numFil][numCol];
		for(int f=0;f<numFil;f++){
			for(int c=0;c<numCol;c++){
				tablero[c][f]=Casilla.LIBRE;
			}
		}
	}
	
	//Comprobar si alguien ha ganado en el ultimo movimiento realizado
	 public int victoria(int f, int c)
	  {
	    if (!columnaValida(c)) {
	      return -1;
	    }
	    if (!filaValida(f)) {
	      return -1;
	    }
	    Casilla aBuscar = this.tablero[f][c];
	    
	    int fIni = f + 1;
	    int enLinea = 1;
	    while ((filaValida(fIni)) && (this.tablero[fIni][c] == aBuscar))
	    {
	      enLinea++;
	      fIni++;
	    }
	    fIni = f - 1;
	    while ((filaValida(fIni)) && (this.tablero[fIni][c] == aBuscar))
	    {
	      enLinea++;
	      fIni--;
	    }
	    if (enLinea >= 4) {
	      return 1;
	    }
	    int cIni = c + 1;
	    enLinea = 1;
	    while ((columnaValida(cIni)) && (this.tablero[f][cIni] == aBuscar))
	    {
	      enLinea++;
	      cIni++;
	    }
	    cIni = c - 1;
	    while ((columnaValida(cIni)) && (this.tablero[f][cIni] == aBuscar))
	    {
	      enLinea++;
	      cIni--;
	    }
	    if (enLinea >= 4) {
	      return 1;
	    }
	    cIni = c + 1;
	    fIni = f + 1;
	    enLinea = 1;
	    while ((filaValida(fIni)) && (columnaValida(cIni)) && (this.tablero[fIni][cIni] == aBuscar))
	    {
	      enLinea++;
	      cIni++;
	      fIni++;
	    }
	    fIni = f - 1;
	    cIni = c - 1;
	    while ((filaValida(fIni)) && (columnaValida(cIni)) && (this.tablero[fIni][cIni] == aBuscar))
	    {
	      enLinea++;
	      cIni--;
	      fIni--;
	    }
	    if (enLinea >= 4) {
	      return 1;
	    }
	    cIni = c + 1;
	    fIni = f - 1;
	    enLinea = 1;
	    while ((filaValida(fIni)) && (columnaValida(cIni)) && (this.tablero[fIni][cIni] == aBuscar))
	    {
	      enLinea++;
	      cIni++;
	      fIni--;
	    }
	    fIni = f + 1;
	    cIni = c - 1;
	    while ((filaValida(fIni)) && (columnaValida(cIni)) && (this.tablero[fIni][cIni] == aBuscar))
	    {
	      enLinea++;
	      cIni--;
	      fIni++;
	    }
	    if (enLinea >= 4) {
	      return 1;
	    }
	    return 0;
	  }
	 
	 
}
