package legend.events
import legend.datastructures.Entity

case class SimEvent(val source: Entity, val time:Long, val args: Option[Object]*){}
