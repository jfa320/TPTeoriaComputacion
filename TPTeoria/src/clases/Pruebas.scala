package clases

object Pruebas {
  def main(Args:Array [String]):Unit={
    
    //Que test serian interesantes en scala test? probar con funcionalidades pequeñas de diapos tales como invertir un numero,suma binaria
    //testear el caso borde de moverme a derecha o izquierda en la lista mas alla del length y deberia "agrandarse" sola la lista/cinta (HACER ESTO ANTES DE TESTEAR) 
    //Los atributos de clases tienen que ser privados? De ser asi,usar getters? No es necesario que sean privados
    

    //prueba 1 (con MT de ejemplo de las diapos)
    
    val estado=new Estado("q",false)  //Esta bien definir los estados asi?  si
    val estadoFinal=new Estado("f",true)// ^^^^^^^^^^^^^^^^^^^^^
    
     val transiciones= Map.apply((estado, '0')-> (estado, '0', new Direccion('R')),
                                (estado, '1')-> (estadoFinal, '0', new Direccion('R')),
                                (estado, 'B')-> (estado, '1', new Direccion('L')))
                                
                                //las transiciones se pasan asi? SI
                        
    val maquina=new MaquinaTuring(transiciones) //inicializar maquina de esta forma? SI
    
    val listaChar=List('B', 'B', '0', 'B','1','B') 
    val cinta=new Cinta(listaChar,2) //armar la cinta asi? ,el 2=posicion 2 en la cinta SI
    
    println(maquina.procesar(estado,cinta).toString())
    
    //prueba 2 complemento un numero
    
    
     val transiciones2= Map.apply((estado, '0')-> (estado, '1', new Direccion('R')),
                                  (estado, '1')-> (estado, '0', new Direccion('R')),
                                  (estado, 'B')-> (estadoFinal, 'B', new Direccion('L')))
                                
                                //las transiciones se pasan asi? SI
                        
    val maquina2=new MaquinaTuring(transiciones2) //inicializar maquina de esta forma? SI
    
    val listaChar2=List('1', '0', '0', '1','1','1','B') 
    val cinta2=new Cinta(listaChar2,0) //armar la cinta asi? ,el 2=posicion 2 en la cinta SI
    
    println(maquina2.procesar(estado,cinta2).toString())
    
    //prueba 3: suma binaria de dos numeros (2+7) 2=10 7=111
    val transiciones3= Map.apply((estado, '0')-> (estado, '1', new Direccion('R')),
                                 (estado, '1')-> (estado, '0', new Direccion('R')),
                                 (estado, 'B')-> (estadoFinal, 'B', new Direccion('L')))
    
    
    
//    //prueba 4: me voy de la cinta
//
//    
//     val transiciones4= Map.apply((estado, '0')-> (estado, '0', new Direccion('R')),
//                                (estado, '1')-> (estado, '0', new Direccion('R')),
//                                (estado, 'B')-> (estado, '1', new Direccion('R')))
//                                
//                                //las transiciones se pasan asi? SI
//                        
//    val maquina4=new MaquinaTuring(transiciones3) //inicializar maquina de esta forma? SI
//    
//    val listaChar4=List('B', 'B', '0', 'B','1','B') 
//    val cinta4=new Cinta(listaChar3,2) //armar la cinta asi? ,el 2=posicion 2 en la cinta SI
//    
//    println(maquina4.procesar(estado,cinta4).toString())
    
    
    
  }
}