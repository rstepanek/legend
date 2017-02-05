package legend.main

import legend.configutils.configs
import com.typesafe.scalalogging._
import legend.datastructures.{Entity, State}
import legend.events.SimEvent
import legend.fileio.{SimEventFileReader, SimFileReader}

/**
  * The main driving class of the simulation, currently used for testing. It will hold the main event loop of the scenario.
  *
  * All params subject to change, work in progress.
  * @author Ryan Stepanek
  * @version 0.1
  * @see See [[https://github.com/rstepanek/legend Legend on GitHub]] for more.
  */
object SimDriver extends App with LazyLogging{

  print_banner
  print_configs
  val system_entity = init_system_entity
  private var time = init_clock_time



  /*Load all Sim Files*/
  SimInitializer.load_files()

  /*Validate all Sim Files*/
  //TODO: Finish writing model validator

    /*Test the construction of the state object*/
   // val file_data = SimFileReader.load_resource(SimFileReader.tfile)
   // logger.debug(s"Loaded file data:\n${file_data}\nCreating state class...")
   // val test_state = State(file_data)
   // logger.debug(s"State object constructed with the following params\n${test_state.toString}")

  /*
  val file_data:List[SimEvent] = SimEventFileReader.LoadSimEvents("/SimEventSchedule.txt")
  //file_data.map(x => logger.debug(x.toString))
  for(x<-file_data) logger.debug(x.toString)
  */
  /*
  TODO: Write EventScheduleParser,
  TODO: Implement Main Event Loop
  TODO: Implement spawning actor
  TODO: Implement output actor
  TODO: Have a log that records sim events, a log that records messages, a warning log, and an error log
   */
  /**
    * Initialize the reserved entity from system level events i.e. spawning, etc..
    * @return the system entity.
    */
  def init_system_entity():Entity={
    new Entity(-1)
  }

  /**
    * Initialize the sim clock.
    * @return 1 as a long
    */
  def init_clock_time():Long ={
    1
  }

  /**
    * Get the current sim time.
    * @return the current sim time.
    */
  def current_time():Long ={time}

  /**
    * Print the loaded config settings.
    */
  def print_configs(): Unit ={
    logger.info("=======>RUNNING WITH CONFIGS:")
    for((k,v)<-configs.runtime_configs) logger.info(k+"\t"+v)
    logger.info("=============================")
  }

  /**
    * Print the Legend banner.
    */
  def print_banner():Unit ={
    println()
    println("""               _|        _|_|_|_|    _|_|_|  _|_|_|_|  _|      _|  _|_|_|
              |_|        _|        _|        _|        _|_|    _|  _|    _|
              |_|        _|_|_|    _|  _|_|  _|_|_|    _|  _|  _|  _|    _|
              |_|        _|        _|    _|  _|        _|    _|_|  _|    _|
              |_|_|_|_|  _|_|_|_|    _|_|_|  _|_|_|_|  _|      _|  _|_|_|  """)
    println("\n.............................................Ground truth simulator v0.01\n")
  }
}
