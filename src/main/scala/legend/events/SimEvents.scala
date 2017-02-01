package legend.events
import legend.datastructures.Entity


/**
  * A base class for the sim events.
  *
  * All params subject to change, work in progress.
  *
  * @param source The source entity that generated the event.
  * @param time The time at which the event occurs.
  * @param args The optional arguments for the event.
  * @todo Finish this class.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
case class SimEvent(val source: Entity, val time:Long, val args: Option[Object]*){}

trait SpawnEvent{this:SimEvent=>}
trait DestroyEvent{this:SimEvent=>}
