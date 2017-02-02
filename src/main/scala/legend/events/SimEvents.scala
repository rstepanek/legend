package legend.events
import legend.datastructures.Entity


/**
  * A base for the sim events. Every
  *
  * All params subject to change, work in progress.
  *
  * @param source The source entity that generated the event.
  * @param time The time at which the event occurs.
  * @param args The optional arguments for the event.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
trait SimEvent{
  val source: Entity
  val time: Long
}

object SimEvent{


  private case class SpawnEvent(source: Entity,time: Long) extends SimEvent {}

  def apply(etype:String,source:Entity,time:Long,args:Option[Object]*): SimEvent ={
    new SpawnEvent(source,time)
  }
}
