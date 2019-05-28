package clases

class Estado(val nombre:String,val esFinal:Boolean) {
  
  override def toString():String={
    if(esFinal){
      s"Estado actual: <$nombre> y es final"}
    else{
      s"Estado actual: <$nombre> y no es final"
    }
  }
  
}


