package clases

final class MaquinaTuring(val transiciones: Map[(Estado, Char), (Estado, Char, Direccion)])
{
  
  def procesar(inicio: (Estado, Cinta)): (Estado, Cinta)={//B=Blanco (podria cambiarse)
    
    def generarListaCintaNueva(cinta:Cinta,charNuevo:Char):List[Char]=
    {
      
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
//          println(listaRecursiva.reverse) //para ver que pasa en cada iteracion BORRAR ANTES DE ENTREGAR
          listaRecursiva.reverse
        }
      }
      
      loop(List(),0)
    }
    
    def agregarAlFinal(lista:List[Char],char:Char):List[Char] ={
      val listaNueva=lista.reverse
      char::listaNueva   
    }
    
    def moviendoCinta(estadoActual:Estado,cinta:Cinta):(Estado,Cinta)={ //con este metodo simular el movimiento
     
      if(cinta.posActual<0){
         val charActual=cinta.listaDeChar.apply(cinta.posActual) 
         val tuplaDestino=transiciones(estadoActual,charActual) 
        
         val cintaNueva=new Cinta(generarListaCintaNueva(new Cinta('B'::cinta.listaDeChar,cinta.posActual),tuplaDestino._2),if (tuplaDestino._3.dir=='R') cinta.posActual+1 else cinta.posActual-1)
         (tuplaDestino._1,cintaNueva)
      } 
      else if(cinta.posActual>=cinta.listaDeChar.length){
        val charActual=cinta.listaDeChar.apply(cinta.posActual) 
        val tuplaDestino=transiciones(estadoActual,charActual) 
        val cintaNueva=new Cinta(generarListaCintaNueva(new Cinta(agregarAlFinal(cinta.listaDeChar,'B'),cinta.posActual),tuplaDestino._2),if (tuplaDestino._3.dir=='R') cinta.posActual+1 else cinta.posActual-1)
        (tuplaDestino._1,cintaNueva)
      }
      else{          
     
        val charActual=cinta.listaDeChar.apply(cinta.posActual) 
        val tuplaDestino=transiciones(estadoActual,charActual) 
        val cintaNueva=new Cinta(generarListaCintaNueva(cinta,tuplaDestino._2),if (tuplaDestino._3.dir=='R') cinta.posActual+1 else cinta.posActual-1)
        (tuplaDestino._1,cintaNueva)
      
      }
      
    }
    
    @annotation.tailrec
    def loop(estadoActual:Estado,cinta:Cinta):(Estado, Cinta)={
      if(estadoActual.esFinal){
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

