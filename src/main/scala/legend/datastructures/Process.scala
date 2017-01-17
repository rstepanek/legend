package legend.datastructures

/*
TODO: Complete process code
 */
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map
import legend.datastructures

/**
  * A class representing a process which is a collection of states. Each process must have at least on entry state and may have at least one exit state.
  *
  * All params subject to change, work in progress.
  *
  * @param entry_states A list of entry states.
  * @param state_list A list of all states in the process.
  * @param state_prob_map The map of states and their probabilistic transitions.
  * @param state_msg_map The map of states and the messages that cause them to transition to other states.
  * @todo Finish this class, implement functionality through graphing library.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GItHub]] for more "
  * information.
  */
abstract class Process{
val state_list: ListBuffer[datastructures.State]
val state_prob_map: Map[legend.datastructures.State,Map[datastructures.State,Double]]
val state_msg_map: Map[legend.datastructures.State,Map[String,datastructures.State]]

//def expected cost
def expected_cost(): Unit={//Map[String,Double]={
  //val exp_cost:Map[String,Double]
  for( state <- state_list ){
  //if()
}


}

  //def expected yield

  /*
  *Process is recursive, a process can contain processes.
  *A process is a dynamically constructed state graph that may
  be intitialized from a template, but may then have additional
  states (other processes) added of removed from it
  *A process must contain at least one state
   */
}