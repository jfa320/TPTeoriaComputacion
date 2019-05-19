package clases

final class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]){
  
  def procesar(inicio: (Estado, Cinta)): (Estado, Cinta)={//B=Blanco (podria cambiarse)
    val cinta=inicio._2                         //aca estaria la magia . Hice esto para que no salte el error de que no devuelve nada
    val ret=(new Estado("ad"),cinta)
    
//    if(inicio._1.nombre=="f"){
//      
//    }
//    else{
//      procesar()
//    }
    
    ret
  }
  
}

