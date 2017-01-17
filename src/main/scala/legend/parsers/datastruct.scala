package legend.parsers

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
  val allowed_keys: Map[String,List[Object]]
}
