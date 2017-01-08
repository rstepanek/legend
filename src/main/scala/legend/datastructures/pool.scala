package legend.datastructures


/*
The base numeric class of the simulator. A pool represents a group
of finite resources that are modified over time, but above or below
a set amount. Currently, only Int pools are supported.

TODO: Use scala's Numeric to make this class handle any generic number
 */
class Pool(var value: Int, var max:Int=Int.MaxValue: Int, var min:Int=0) {
  def inc: Unit ={
    value = if(( value+1 )<= max) value+1 else value
  }

  def dec: Unit ={
    value = if(( value-1 )>= min) value-1 else value
  }

  def add(n:Double): Unit ={
    value = if(( value+n )<= max) (value+n).toInt else value
  }

  def add(n:Int): Unit = {
    value = if(( value+n )<= max) value+n else value
  }

  def sub(n:Int): Unit ={
    value = if(( value-n )>= min) value-n else value
  }

  def sub(n:Double): Unit ={
    value = if(( value-n )>= min) (value-n).toInt else value
  }

  def mul(n:Int): Unit ={
    value = if((value*n)<= max) value*n else value
  }

  def mul(n:Double): Unit ={
    value = if((value*n)<= max) (value*n).toInt else value
  }

  def div(n:Int): Unit ={
    value = if((value/n)>= min) value/n else value
  }

  def div(n:Double): Unit ={
    if(n!=0){
      value = if((value/n)>= min) (value/n).toInt else value
    }
  }

  def hasCapacity(n:Int): Boolean ={
    return !( (n+value) > max)
  }

  def hasCapacity(n:Double): Boolean ={
    return !( (n+value) > max)
  }

  def hasRemaining(n:Int): Boolean ={
    return !( (value-n) < min)
  }

  def hasRemaining(n:Double): Boolean ={
    return !( (value-n) < min)
  }
}
/*
class pool(var value: Double, var max:Double=Double.MaxValue: Int, var min:Double=0) {
  def inc: Unit ={
    value = if(( value+1 )<= max) value+1 else value
  }

  def dec: Unit ={
    value = if(( value-1 )>= min) value-1 else value
  }

  def add(n:Double): Unit ={
    value = if(( value+n )<= max) value+n else value
  }

  def add(n:Int): Unit = {
    value = if(( value+n )<= max) value+n else value
  }

    value = if(( value-n )>= min) value-n else value  def sub(n:Int): Unit ={
    value = if(( value-n )>= min) value-n else value
  }

  def sub(n:Double): Unit ={

  }

  def mul(n:Int): Unit ={
    value = if((value*n)<= max) value*n else value
  }

  def mul(n:Double): Unit ={
    value = if((value*n)<= max) value*n else value
  }

  def div(n:Int): Unit ={
    value = if((value/n)>= min) value/n else value
  }

  def div(n:Double): Unit ={
    if(n!=0){
      value = if((value/n)>= min) value/n else value
    }
  }

  def hasCapacity(n:Int): Boolean ={
    return !( (n+value) > max)
  }

  def hasCapacity(n:Double): Boolean ={
    return !( (n+value) > max)
  }

  def hasRemaining(n:Int): Boolean ={
    return !( (value-n) < min)
  }

  def hasRemaining(n:Double): Boolean ={
    return !( (value-n) < min)
  }
}
*/