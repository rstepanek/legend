package legend.datastructures

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