package legend.main

import legend.configutils.configs
import legend.datastructures.State
import legend.fileio.{SimFileReader => SFR}
import legend.manfifests.StateManifest
import com.typesafe.scalalogging._

/**
  * This class initializes the simulation by loading all files at startup.
  */
object SimInitializer extends LazyLogging{


  def load_files() = {
    //configs are automatically loaded first by virtue of calling the [[configs]] object

    load_states()




    //load processes
    //load entities and kml
  }


  /**
    * Get a list of all files in the states directory (taken from the configs), then read each file, turn it into a state object and attempt to register the file in the [[StateManifest]].
    */
  def load_states() ={
    logger.info("Loading states from: " + configs.state_file_directory)
    val state_files = SFR.get_all_files_in_dir(configs.state_file_directory)
    logger.debug(state_files.map(_ => toString).toString())
    for(file<-state_files){
      StateManifest.register_state(State(SFR.load_resource(file)))
    }
  }

}
