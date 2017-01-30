package legend.datastructures

import legend.parsers.{MissingRequiredParameterException, params}
//import legend.parsers.params.get_param

/**
  * A class representing a process which is a collection of states. Each process must have at least on entry state and may have at least one exit state.
  *
  * All params subject to change, work in progress.
  *
  * @param name The name of the state.
  * @param cost The cost of entering a state, by default cost is charged only on state start.
  * @param yields The result of the state, what pool modification to perform when the state is exited
  * @param duration The duration of the state in sim-units (default: milliseconds)
  * @param on_start_message A string message thrown when the entity activates the state (it can only be thrown once, even if the entity enters the state several times, consecutively).
  * @param on_exit_message A string message thrown when the entity leaves the state (it can only be thrown once, even if the entity enters the state several times, consecutively).
  * @param on_hibernate_message A string message thrown when the state is toggled to void - only thrown if the state has a frequency. See [[TimeFreq]]
  * @param on_activate_message A string message thrown when the entity activates the state.
  * @param cost_on_activation A boolean value, if set to true, the cost will be charged each time a state is activated. Only applies if a frequency is set. See [[TimeFreq]]
  * @param yield_on_hibernate A boolean value, if set to true, the yields will be awarded each time a state is activated. Only applies if a frequency is set. See [[TimeFreq]]
  * @param onmeta_tags A map of key:value pairs that can be searched and indexed while the state is active.
  * @param offmeta_tags A map of key:value pairs that can be searched and indexed while the state is in hibernation (void). Only applies if a frequency is set. See [[TimeFreq]]
  *
  * @todo Finish this class, implement functionality through graphing library.
  * @todo Change cost to use pool types rather than specific pool names.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  * information.
  */
case class State(data:Map[String,String]){
  /*REQUIRED PARAMS*/
  val name = params.string(data=data)
  val duration = params.duration(data=data)

  /*TODO:Implement required parameter check*/
  /*OPTIONAL PARAMS*/
  val timefreq = params.timefreq(data=data)
  val concurrent = params.boolean("concurrent",data)
  val require_tags = params.stringlist("require_tags",data)
  val banned_tags = params.stringlist("banned_tags", data)
  val on_start_message = params.string("on_start_message", data)
  val on_exit_message = params.string("on_exit_message", data)
  val on_hibernate_message = params.string("on_hibernate_message", data)
  val on_entrance_message = params.string("on_entrance_message", data)
  val onmeta_tags = params.stringmap("onmeta_tags", data)
  val offmeta_tags = params.stringmap("offmeta_tags", data)
  val cost = params.resourcemodlist("cost", data)
  val yields = params.resourcemodlist("yields", data)
  val cost_on_activation = params.boolean("cost_on_activation", data)
  val yield_on_hibernate = params.boolean("yield_on_hibernate", data)

//  /*REQUIRED PARAMS*/
//  val name = required_param("name",classOf[String])
//  val duration = required_param("duration",classOf[Duration])
//
//  /*OPTIONAL PARAMS*/
//  val timefreq = optional_param("timefreq",classOf[TimeFreq],None)
//  val concurrent = optional_param("concurrent",classOf[Boolean],true)
//  val require_tags = optional_param("require_tags", classOf[List[String]],List[String]())
//  val banned_tags = optional_param("banned_tags", classOf[List[String]],List[String]())
//  val on_start_message = optional_param("on_start_message", classOf[List[String]],List[String]())
//  val on_exit_message = optional_param("on_exit_message", classOf[List[String]],List[String]())
//  val on_hibernate_message = optional_param("on_hibernate_message", classOf[List[String]],List[String]())
//  val on_entrance_message = optional_param("on_entrance_message", classOf[List[String]],List[String]())
//  val onmeta_tags = optional_param("onmeta_tags", classOf[Map[String,String]],Map[String,String]())
//  val offmeta_tags = optional_param("offmeta_tags", classOf[Map[String,String]],Map[String,String]())
//  val cost = optional_param("cost", classOf[ResourceModList],ResourceModList(List[ResourceMod]()))
//  val yields = optional_param("yields", classOf[ResourceModList],ResourceModList(List[ResourceMod]()))
//  val cost_on_activation = optional_param("cost_on_activation", classOf[Boolean],false)
//  val yield_on_hibernate = optional_param("yield_on_hibernate", classOf[Boolean],false)

 /*
  ("poolrestrictions", classOf[List[poolRestriction]]),//TODO: implement this
*/
  override def toString: String ={
    s"name: ${name}, duration: ${duration}, timefreq: ${timefreq}, concurrent: ${concurrent}, require_tags: ${require_tags}, banned_tags: ${banned_tags}, on_start_message: ${on_start_message}, on_exit_message: ${on_exit_message}, on_entrance_message: ${on_entrance_message}, on_hibernate_message: ${on_hibernate_message}, onmeta_tags: ${onmeta_tags}, offmeta_tags: ${offmeta_tags}, cost: ${cost}, yields: ${yields}, cost_on_activation: ${cost_on_activation}, yield_on_hibernate: ${yield_on_hibernate}"
  }
}
