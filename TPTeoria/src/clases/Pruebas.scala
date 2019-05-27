package clases

object Pruebas {
  def main(Args:Array [String]):Unit={
    
    val estado=new Estado("q")  //Esta bien definir los estados asi?
    val estadof=new Estado("f")// ^^^^^^^^^^^^^^^^^^^^^
    
    val transiciones= Map.apply((estado, '0')-> (estado, '0', new Direccion('R')), //pruebo con MT de ejemplo
                                (estado, '1')-> (estadof, '0', new Direccion('R')),//de las diapos
                                (estado, 'B')-> (estado, '1', new Direccion('L')))
                                
                                //las transiciones se pasan asi?
                        
    val maquina=new MaquinaTuring(transiciones) //inicializar maquina de esta forma?
    
    val listaChar=List('B', 'B', '0', '0','B','B') 
    val cinta=new Cinta(listaChar,2) //armar la cinta asi?
    
    println(maquina.procesar(estado,cinta).toString())
  }
}