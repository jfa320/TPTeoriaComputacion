package clases

final class MaquinaTuring(val transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]){
  
  def procesar(inicio: (Estado, Cinta)): (Estado, Cinta)={//B=Blanco (podria cambiarse)
    
    def generarCintaNueva(cinta:Cinta,charNuevo:Char):List[Char]={
      
      
//      def loop(listaRecursiva:List[Char],posicion:Integer):List[Char]={
//        val listaDeChar=List[Char]
//        if(posicion==cinta.posActual){
//          loop()
//        }
//        else{
//          
//        }
//      }
//      
      List('a') //cambiar esto,solo hecho para no tener error de no devolver nada
    }
    
    
    def moviendoCinta(estadoActual:Estado,cinta:Cinta):(Estado,Cinta)={ //con este metodo simular el movimiento
      val charActual=cinta.listaDeChar(cinta.posActual) 
      val tuplaDestino=transiciones(estadoActual,charActual)
      
      val cintaNueva=new Cinta(generarCintaNueva(cinta,tuplaDestino._2),if (tuplaDestino._3.dir=='R') cinta.posActual+1 else cinta.posActual-1)
      (tuplaDestino._1,cintaNueva)
    }
    
    @annotation.tailrec
    def loop(estadoActual:Estado,cinta:Cinta):(Estado, Cinta)={
      if(estadoActual.nombre=="f"){
        (estadoActual,cinta)  
      }
      else{
        val aux=moviendoCinta(estadoActual,cinta)
        loop(aux._1,aux._2)
      }
    }
    
    loop(inicio._1,inicio._2)
  }
  
}

