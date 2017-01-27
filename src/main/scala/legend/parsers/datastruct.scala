package legend.parsers

import legend.datastructures._
import legend.fileio.SimFileReader

/**
  * A trait to designate objects that hold a map of key-value pairs that designate configuration parameters.
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
  * A trait to denote objects that can be constructed on the fly from datastructs.
  *
  * Did you know: This trait is used for dynamic construction of sim objects at runtime.
  *
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  * information.
  */
trait structclass {}

/**
  * A class to hold the allowed keys and expected parameter types for the state object.
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
    ("message_on_entrance", classOf[List[String]]),
    ("cost",classOf[List[ResourceMod]]),
    ("yield",classOf[List[ResourceMod]]),
    ("onmeta",classOf[Map[String,String]]),
    ("offmeta",classOf[Map[String,String]])
    //TODO: have meta component handler memoize for differences to avoid computational overhead
  )
}

/**
  * The Sim Object Constructor, a static class that constructs simulation objects from string representations of those objects. Generally this is used right after loading the input files.
  *
  * All params subject to change, work in progress.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  */
object SOC{
  /*
  def create_state(dstruct: datastruct, data:String*): State = {
      val struct = dstruct.allowed_keys
      data.foreach(input =>{
        val split_point = input.indexOf(SimFileReader.key_value_sep)
        val key:String = input.substring(0,split_point)

        if(!struct.contains(key)){
          //TODO: When logging is setup make sure that both the allowed keys and the data are printed to the error log.
          throw new InvalidStateDataException()}

        val args:String = input.substring(split_point+1,input.length)
      })
  }
  */
}

case class InvalidStateDataException() extends Exception