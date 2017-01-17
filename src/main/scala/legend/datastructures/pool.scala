package legend.datastructures


/**
  * The primary numerical datastructure of the simulation. A pool represents a real world or abstract resource such as fuel, cargo, durability, etc...
  *
  * All params subject to change, work in progress.
  *
  * @constructor Create a new pool with an initial value and (optionally) a max and min value.
  * @param value The initial value of the pool.
  * @param max The maximum possible value of the pool.
  * @param min The minimum possible value of the pool.
  * @author Ryan Stepanek
  * @version 0.1
  * @todo Use scala's Numeric to make this class handle any generic number.
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  * information.
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