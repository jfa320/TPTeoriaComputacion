package clases

object Pruebas {
  def main(Args:Array [String]):Unit={
    
    //Que test serian interesantes en scala test?
    //Los atributos de clases tienen que ser privados? De ser asi,usar getters?
    
    //prueba 1 (con MT de ejemplo de las diapos)
    
    val estado=new Estado("q",false)  //Esta bien definir los estados asi?
    val estadof=new Estado("f",true)// ^^^^^^^^^^^^^^^^^^^^^
    
    val transiciones= Map.apply((estado, '0')-> (estado, '0', new Direccion('R')),
                                (estado, '1')-> (estadof, '0', new Direccion('R')),
                                (estado, 'B')-> (estado, '1', new Direccion('L')))
                                
                                //las transiciones se pasan asi?
                        
    val maquina=new MaquinaTuring(transiciones) //inicializar maquina de esta forma?
    
    val listaChar=List('B', 'B', '0', '0','B','B') 
    val cinta=new Cinta(listaChar,2) //armar la cinta asi? ,el 2=posicion 2 en la cinta
    
    println(maquina.procesar(estado,cinta).toString())
    
    
    
  }
}