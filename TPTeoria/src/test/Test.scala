import org.scalatest._
import clases._


class ListSpec extends UnitSpec {
  
    "Ejemplo Diapositivas: Al correr maquina "must " quedar en: Estado:f | Cinta (B, B, 0, 0, 1, B) | Posicion Actual: 4 "in {
      val estado=new Estado("q",false)  
      val estadoFinal=new Estado("f",true)
      
      val transiciones= Map.apply((estado, '0')-> (estado, '0', new Direccion('R')),
                                  (estado, '1')-> (estadoFinal, '0', new Direccion('R')),
                                  (estado, 'B')-> (estado, '1', new Direccion('L')))
                                  
                               
                          
      val maquina=new MaquinaTuring(transiciones) 
      
      val listaChar=List('B', 'B', '0', 'B','1','B') 
      val cinta=new Cinta(listaChar,2)
      assert(maquina.procesar(estado,cinta).toString()=="(Estado actual: <f> y es final,Lista: List(B, B, 0, 0, 1, B) | Posicion Actual: 4)")
   }
    
    "Ejemplo Complemento numero binario: Al correr maquina "must " quedar en: Estado:f | Cinta (0, 1, 1, 0, 0, 0, B) | Posicion Actual: 5 "in {
     val estado=new Estado("q",false)  
     val estadoFinal=new Estado("f",true)
     val transiciones2= Map.apply((estado, '0')-> (estado, '1', new Direccion('R')),
                                  (estado, '1')-> (estado, '0', new Direccion('R')),
                                  (estado, 'B')-> (estadoFinal, 'B', new Direccion('L')))
                                
                            
                        
     val maquina2=new MaquinaTuring(transiciones2)
      
     val listaChar2=List('1', '0', '0', '1','1','1','B') 
     val cinta2=new Cinta(listaChar2,0) 
    
     assert(maquina2.procesar(estado,cinta2).toString()=="(Estado actual: <f> y es final,Lista: List(0, 1, 1, 0, 0, 0, B) | Posicion Actual: 5)")
   }
    
    
    
    
    
  
}