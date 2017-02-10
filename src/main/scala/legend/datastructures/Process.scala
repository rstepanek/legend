package legend.datastructures

/*
TODO: Complete process code
 */
import scala.collection.mutable.ListBuffer
import legend.datastructures
import legend.manfifests.StateManifest

/**
  * A class representing a process which is a collection of states. Each process must have at least on entry state and may have at least one exit state.
  *
  * All params subject to change, work in progress.
  *
  * @param entry_states A list of entry states.
  * @param state_list A list of all states in the process.
  * @param state_prob_map The map of states and their probabilistic transitions.
  * @param state_msg_map The map of states and the messages that cause them to transition to other states.
  * @todo Make state and process inherit from a common class to allow nested referencing within the class
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
case class Process(name:String, states:Set[State], entrance_states:Map[State,Double],
prob_trans:Map[State,Map[State,Double]],
event_trans:Map[State,Map[String,Map[State,Double]]])

  object Process{

    /**
      * This method constructs a process object from a map of param->value.
      * @param data The map of values with which to instantiate the state.
      * @return A new [[State]] object.
      */
    def apply(data:List[List[String]]): Process ={
      //each line is either the process name, an entrance state, or a state transition
      //exit states are implicit
      var name:String = ""
      val states = scala.collection.mutable.Set[State]()
      val entrance_states = scala.collection.mutable.Map[State,Double]()
      val prob_trans_map = scala.collection.mutable.Map[State,
        scala.collection.mutable.Map[State,Double]]()
      val event_trans = scala.collection.mutable.Map[State,
        scala.collection.mutable.Map[String,
          scala.collection.mutable.Map[State,Double]]]()

      //event_trans:Map[State,Map[String,Map[State,Double]]]
      data.foreach(line =>{
        line.length match {
            //entrance state or name
          case 2 => if(line(0)=="name") name = line(1) else{
            entrance_states += (StateManifest.loaded_states.get(line(1)).get->line(0).toDouble)
          }
          // a probability transition
          case 3 =>
            prob_trans_map += (StateManifest.loaded_states.get(line(0)).get ->
              scala.collection.mutable.Map(StateManifest.loaded_states.get(line(2)).get -> line(1).toDouble))
          // an event transition
          case 4 => event_trans += (StateManifest.loaded_states.get(line(0)).get ->
            scala.collection.mutable.Map( line(1)->
            scala.collection.mutable.Map(StateManifest.loaded_states.get(line(3)).get->line(2).toDouble)))
          case _ => throw BadlyFormattedProcessFile(s"Found badly formatted data:\n${line}\n")
        }
      })

      /**
        * An internal method that parses the Process' maps and generates a set of all states contained in the process.
        * @return The set of all [[State]]s in the process.
        */
      def get_all_states(): Set[State] ={
        var all_states = scala.collection.mutable.Set[State]()
        for((k1,v1)<-entrance_states) all_states += k1
        for((k1,v1)<-prob_trans_map){
          all_states += k1
          for((k2,v2)<-v1) all_states += k2
        }
        for((k1,v1)<-event_trans){
          all_states += k1
          for((k2,v2)<-v1){
            for((k3,v3)<-v2) all_states += k3
          }
        }
        all_states.toSet
      }

      new Process(name=name,states=get_all_states,entrance_states=entrance_states.toMap,
        prob_trans=prob_trans_map.map(kv=>(kv._1,kv._2.toMap)).toMap,
        event_trans=event_trans.map(kv=>(kv._1,kv._2.map(xc=> (xc._1,xc._2.toMap)).toMap)).toMap)
}

  }

case class BadlyFormattedProcessFile(message: String = "") extends Exception(message)