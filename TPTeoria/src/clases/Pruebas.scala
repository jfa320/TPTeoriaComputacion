package clases

object Pruebas {
  def main(Args:Array [String]):Unit={
    
    val estado=new Estado("q")
    val estadof=new Estado("f")
    
    val transiciones= Map.apply((estado, '0')-> (estado, '1', new Direccion('R')), //pruebo con MT de ejemplo
                        (estado, '1')-> (estadof, '0', new Direccion('R')),//de las diapos
                        (estado, 'B')-> (estado, '1', new Direccion('L')))
                        
    val maquina=new MaquinaTuring(transiciones)
    
    val lista=List('B', 'B', '0', '0','B','B')
    
//    val lista2='a'::lista//agregar lista
    
    
    
   val cinta=new Cinta(lista,2)
   
//   println( transiciones(new Estado("q"),'0'))
    val tuplaFinal=maquina.procesar(estado,cinta)
    println(tuplaFinal._1.nombre,"(" + tuplaFinal._2.listaDeChar+","+tuplaFinal._2.posActual+")")
  }
}