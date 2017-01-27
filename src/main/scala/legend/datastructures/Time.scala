package legend.datastructures

import scala.concurrent.duration._

/**
  * A class representing a time frequency. Usually paired with a state to schedule recurring events.
  *
  * All params subject to change, work in progress.
  *
  * @param fmin The minimum number of times to occur within the time window.
  * @param fmax The max number of times to occur within the time window.
  * @param windowmin The minimum length of time window in which the event occurs with some frequency.
  * @param windowmax The maximum length of time window in which the event occurs with some frequency.
  * @todo Finish this class.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  * information.
  */
case class TimeFreq(val fmin:Int,val fmax:Int, val windowmin:Long, val windowmax:Long){}


/**
  * A class representing the duration of an event.
  *
  * All params subject to change, work in progress.
  *
  * @param min The minimum time of the duration in milliseconds.
  * @param max The maximum time of the duration in milliseconds.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  */
case class Duration(val min: Long=1, val max:Long){
  /**
    * @return Returns a random long between the minimum anc maximum possible duration (inclusive).
    */
  def getDuration(): Long = scala.util.Random.nextLong()*(max-min)+min

}


/**
  * A static class to help convert raw string inputs in Duration objects and simtime Long values
  *
  * All params subject to change, work in progress.
  *
  * @todo Finish this class.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  * information.
  */
object TimeConversions{
  /**
    * @param num The numerical part of a date string i.e. 20 in 20mins
    * @param unit The time unit part of a date string i.e. the mins in 20mins
    * @return The duration string converted to milliseconds as a Long
    */
  def TimeToLong(num:String, unit:String): Long={
    val lunit = unit.toLowerCase.trim
    val inittime:Double = num.trim.toDouble
    match lunit{
      case "s"  | "sec" | "secs" | "second" | "seconds" =>  (inittime seconds).toMillis
      case "m"  | "min" | "mins" | "minute" | "minutes" =>  (inittime minutes).toMillis
      case "h"  | "hr" | "hr" | "hour" | "hours" =>  (inittime hours).toMillis
      case "d"  | "day" | "days" =>  (inittime days).toMillis
      case _ => _
    }
  }

  /**
    * Splits any string into its numerical and character parts and passes them to [[TimeConversions.TimeToLong()]]
    * @param s The raw timestring i.e. "20s", "4.5hours","250day", etc...
    * @return The duration in millis as a Long
    */
  def RawStringToLong(s:String): Long = {
    val numberpart = s.filter(x => (x.isDigit | x=='.'))
    val unitpart = s.filter(_.isLetter)
    return TimeToLong(numberpart,unitpart)
  }


  /**
    * Converts in valid duration string into a [[Duration]] object.
    * @param s The raw timestring i.e. "20s", "4.5hours","250day", "2hr-4days","16s-80.6s", etc...
    * @return A new [[Duration]] object representing the max and min time of the duration.
    */
  def DurationFromString(s:String): Duration={
    if(s.contains("-")){
      val (min,max) = s.split("-")
      return new Duration(RawStringToLong(min),RawStringToLong(max))
    }
    else{
      return new Duration(max=RawStringToLong(s))
    }
  }
}