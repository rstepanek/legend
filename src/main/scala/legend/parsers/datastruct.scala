package legend.parsers

import legend.datastructures._
import legend.fileio.SimFileReader
import com.typesafe.scalalogging._


/**
  * A static class that converts string values into object types of the form Option[InstanceOfObject].
  *
  * Did you know: This trait is used for dynamic construction of sim objects at runtime.
  *
  * @todo This implementation is cumbersome and does not easily allow for meaningful error messages. Re-implement this functionality using reflection and custom error messages.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
object params {
  def duration(name:String="duration",data:Map[String,String]) ={
    try if(data.get(name).get.toLowerCase.trim!="none") Some(TimeConversions.DurationFromString(data.get(name).get))
    else None
    catch{case _: Throwable => None}
  }

  def string(name:String="name",data:Map[String,String]) ={
    try if(data.get(name).get.toLowerCase.trim!="none") Some(data.get(name).get)
    else None
    catch{case _: Throwable => None}
  }

  def timefreq(name:String="timefreq",data:Map[String,String]) ={
    try if(data.get(name).get.toLowerCase.trim!="none")  Some(TimeConversions.TimeFreqFromString(data.get(name).get))
    else None
    catch{case _: Throwable => None}
  }

  def boolean(name:String,data:Map[String,String]) ={
    try if(data.get(name).get.toLowerCase.trim!="none") Some((data.get(name).get).toBoolean)
    else None
    catch{case _: Throwable => None}
  }

  def stringlist(name:String,data:Map[String,String]) ={
    try if(data.get(name).get.toLowerCase.trim!="none") Some((data.get(name).get).split(",").toList)
    else None
    catch{case _: Throwable => None}
  }

  def stringmap(name:String,data:Map[String,String]) ={
    try if(data.get(name).get.toLowerCase.trim!="none") Some(parseMap(data.get(name).get))
    else None
    catch{case _: Throwable => None}
  }

  def resourcemodlist(name:String,data:Map[String,String]) ={
    try if(data.get(name).get.toLowerCase.trim!="none") Some(data.get(name).get.split(",").map(x => ResourceConstructer.ResourceFromString(x)).toList)
    else None
    catch{case _: Throwable => None}
  }

  /**
    * Given a string, convert it to a map with arguments as key:value pairs that are separated by ","
    * @return a Map[String,String] of key values pairs, derived from the original string by key1:value1,key2:value2,etc...
   */
  def parseMap(s:String): Map[String,String] ={
    var returnmap = Map[String,String]( )
    for(kv <- s.split(",")){
      val Array(k,v) = kv.split(":")
      returnmap += (k.trim -> v)
    }
    return returnmap
  }

}

case class InvalidStateDataException(message: String = "") extends Exception(message)
case class MissingRequiredParameterException(message: String = "") extends Exception(message)
case class InvalidParameterValueException(message: String = "") extends Exception(message)