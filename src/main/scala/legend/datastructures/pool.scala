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
  * @version 0.2
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  * information.
  */
class Pool(var value: Double, var max:Double=Double.MaxValue, var min:Double=0) {
  def ++(): Unit = inc
  def inc: Unit = add(1.0)

  def --(): Unit = dec
  def dec: Unit = sub(1.0)

  def +(n:Double): Unit = add(n)
  def add(n:Double): Unit = {
    value = if(( value+n ) <= max) value+n else value
  }

  def -(n:Double): Unit = sub(n)
  def sub(n:Double): Unit ={
    value = if(( value-n )>= min) value-n else value
  }

  def *(n:Double): Unit = mul(n)
  def mul(n:Double): Unit ={
    value = if((value*n)<= max) value*n else value
  }

  def /(n:Double): Unit = div(n)
  def div(n:Double): Unit ={
    if(n==0) return;
    value = if( (value/n) >= min) value/n else value
  }

  def hasCapacity(n:Double): Boolean ={
    return !( (n+value) > max)
  }

  def hasRemaining(n:Double): Boolean ={
    return !( (value-n) < min)
  }
}
