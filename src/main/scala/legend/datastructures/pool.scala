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
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
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

/**
  * A class that represents a modification to an intended Pool. THis modification could represent a cost or production of resources.
  *
  * All params subject to change, work in progress.
  *
  * @constructor Create a new ResourceMod with a target pool name, an operation to apply to the pool, value.
  * @param poolname The target pool's name as a string.
  * @param operation The operation i.e. *,/,+,-
  * @param value The value by which to modify the pool as a double.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
case class ResourceMod(poolname:String, operation: String, var value: Double) {

  /**
    * This method applies the modification to a pool.
    * @return Nothing.
    * @param pool The that should be modified by the ResourceMod.
    */
  def apply(pool: Pool): Unit = {
    operation match {
      case "-" => pool - value
      case "+" => pool + value
      case "/" => pool / value
      case "*" => pool * value
        //TODO: after logging is enabled, add an error report on an invalid operation
    }
  }
}

/**
  * A helper class to construct a [[ResourceMod]] object from an input string.
  */
object ResourceConstructer{

  /**
    * Given a string, return a valid [[ResourceMod]] object.
    * @param s
    */
  def ResourceFromString(s:String): Unit ={
    var delim:String = ""
    if(s.contains("-")){
      delim = "-"
    }
    else if(s.contains("+")){
      delim = "+"
    }
    else if(s.contains("/")){
      delim = "/"
    }
    else if(s.contains("*")){
      delim = "*"
    }
    else{
      throw InvalidResourceMod(s"Invalid string for ${this.getClass}\n '${s}'\nPlease use a string of the format: <poolname><+,-,/,*><Int or Double> i.e. myPool+7 ")
    }
    val Array(poolname,mod) = s.split(delim)
    new ResourceMod(poolname.trim,delim,mod.filter(x => (x.isDigit | x=='.')).toDouble)
  }
}

case class InvalidResourceMod(message: String = "") extends Exception(message)