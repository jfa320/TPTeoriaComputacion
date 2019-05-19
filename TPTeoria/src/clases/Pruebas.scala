package clases

object Pruebas {
  def main(Args:Array [String]):Unit={
    val transicion= Map((new Estado("q"), '0')-> (new Estado("q"), '1', new Direccion('R')), //pruebo con MT de ejemplo
                        (new Estado("q"), '1')-> (new Estado("f"), '0', new Direccion('R')),//de las diapos
                        (new Estado("q"), 'B')-> (new Estado("q"), '1', new Direccion('L')))
                        
    val maquina=new MaquinaTuring(transicion)
    
    val lista=List('B', 'B', '0', '0','B','B')
    
    val cinta=new Cinta(lista,2)
    
    
    println(maquina.procesar(new Estado("q"),cinta))
  }
}