package legend.datastructures

/*
TODO: Complete process code
 */
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map
import legend.datastructures

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