package clases

final class MaquinaTuring(val transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]){
  
  def procesar(inicio: (Estado, Cinta)): (Estado, Cinta)={//B=Blanco (podria cambiarse)
    
    def generarListaCintaNueva(cinta:Cinta,charNuevo:Char):List[Char]={
      @annotation.tailrec
      def loop(listaRecursiva:List[Char],posicionActual:Integer):List[Char]={
       
        if(posicionActual<cinta.listaDeChar.length){
          if(posicionActual==cinta.posActual){
            
            loop(charNuevo::listaRecursiva,posicionActual+1)
          }
          else{
            val lista=listaRecursiva
            loop(cinta.listaDeChar.apply(posicionActual)::lista,posicionActual+1)
          }
        }
        else{
          listaRecursiva
        }
      }
      
      loop(List(),0)
    }
    
    
    def moviendoCinta(estadoActual:Estado,cinta:Cinta):(Estado,Cinta)={ //con este metodo simular el movimiento
      val charActual=cinta.listaDeChar.apply(cinta.posActual) 
      val tuplaDestino=transiciones(estadoActual,charActual)
      
      val cintaNueva=new Cinta(generarListaCintaNueva(cinta,tuplaDestino._2),if (tuplaDestino._3.dir=='R') cinta.posActual+1 else cinta.posActual-1)
      
      (tuplaDestino._1,cintaNueva)
    }
    
    @annotation.tailrec
    def loop(estadoActual:Estado,cinta:Cinta):(Estado, Cinta)={
      if(estadoActual.nombre=="f"){
        (estadoActual,new Cinta(cinta.listaDeChar.reverse,cinta.posActual)) //reverse ya que :: al agregar char me los agrega al comienzo y no al final
      }
      else{
        val aux=moviendoCinta(estadoActual,cinta)
        loop(aux._1,aux._2)
      }
    }
    
    loop(inicio._1,inicio._2)
  }
  
}

