package clases

final class MaquinaTuring(transiciones: Map[(Estado, Char), (Estado, Char, Direccion)]){
  
  def procesar(inicio: (Estado, Cinta)): (Estado, Cinta)={
    val lista=List('a', 'b', 'c', 'd')
    
    (new Estado("ad"),new Cinta(lista))
  }
  
  
}

