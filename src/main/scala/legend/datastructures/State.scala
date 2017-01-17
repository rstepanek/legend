package legend.datastructures

/**
  * A class representing a process which is a collection of states. Each process must have at least on entry state and may have at least one exit state.
  *
  * All params subject to change, work in progress.
  *
  * @param name The name of the state.
  * @param cost A map of the pool name
  * @param Duration The duration of the state in sim-units (default: milliseconds)
  * @param on_start_message A string message thrown when the entity activates the state.
  * @param on_exit_message A string message thrown when the entity leaves the state.
  * @param on_entrance A string message thrown when the entity initializes the state (it can only be thrown once, even if the entity enters the state several times, consecutively).
  * @todo Finish this class, implement functionality through graphing library.
  * @todo Change cost to use pool types rather than specific pool names.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  * information.
  */
case class State(val name: String,
                 //val state_freq:Option[TimeFreq],
                 //val restriction: Option[List[Restrictions]],
                 //val results: Option[List[Pool]],
                 val cost: Map[String,Int],
                 val Duration: Long,
                 val on_start_message: Option[String],//each time a state is reactivated if it's a freq state
                 val on_exit_message: Option[String],
                 val on_entrance: Option[String]//only once
                ){

}