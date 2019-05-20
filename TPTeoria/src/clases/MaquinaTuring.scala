package clases

final class MaquinaTuring(val transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]){
  
  def procesar(inicio: (Estado, Cinta)): (Estado, Cinta)={//B=Blanco (podria cambiarse)
    val cinta=inicio._2                         //aca estaria la magia . Hice esto para que no salte el error de que no devuelve nada
    val ret=(new Estado("ad"),cinta)
    
//    if(inicio._1.nombre=="f"){
//      
//    }
//    else{
//      procesar()
//    }
    
    
    def moviendoCinta(estadoActual:Estado,cinta:Cinta):(Estado,Cinta)={
      val charActual=cinta.listaDeChar(cinta.posActual) //con este metodo simular el movimiento
      transiciones(estadoActual,charActual)
      
      ret
    }
    
    
    def loop(estadoActual:Estado,cinta:Cinta):(Estado, Cinta)={
      if(estadoActual.nombre=="f"){
        (estadoActual,cinta)  
      }
      else{
        //cambiar la cinta con pos actual y estado actual
        val aux=moviendoCinta(estadoActual,cinta)
        loop(aux._1,aux._2)
      }
      
    }
    ret //esto esta mal,corregir. Solo lo agregue para evitar problema de no devolver nada
  }
  
}

