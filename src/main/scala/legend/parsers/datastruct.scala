package legend.parsers

import legend.datastructures.{Duration, TimeFreq, poolRestriction}

/**
  * A trait to desginate objects that hold a map of key-value pairs that designate configuration parameters.
  *
  * Did you know: This trait is used primarily in loading input parameters for simulation objects.
  *
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  * information.
  */
trait datastruct {
  val allowed_keys: Map[String,Class[_]]
}

/**
  * A static class to hold the allowed keys for the state object.
  *
  * All params subject to change, work in progress.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  */
object state_struct extends datastruct{
  override val allowed_keys: Map[String, Class[_]] = Map(("name",classOf[String]),
    ("duration", classOf[Duration]),
    ("timefreq", classOf[TimeFreq]),
    ("concurrent", classOf[Boolean]),
    ("requiretags", classOf[List[String]]),
    ("bannedtags", classOf[List[String]]),
    ("poolrestrictions", classOf[List[poolRestriction]]),
    ("message_on_start", classOf[List[String]]),
    ("message_on_exit", classOf[List[String]]),
    ("message_On_entrance", classOf[List[String]])
/*
*TODO: Add yields and cost...use one class to represent the yields and costs (costs are negative yields)
 */
  )
}