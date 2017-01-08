package legend.fileio

import scala.io.Source
import scala.collection.mutable.Map

object SimFileReader{
  val fdir = "resources/scenario/states"
  val tfile =  "/scenario/states/test_state.txt"
  val key_value_sep = ':'

  def main(args: Array[String]): Unit = {
    for(t<-load_resource(tfile)){
      println(t.toString)
    }

    print("end of file")
  }

  def load_file(targetFile: String): Map[String,String]={
    val file_args:Map[String,String] = Map[String,String]()

    for(line <- Source.fromFile(targetFile).getLines()){
      val split_point = line.indexOf(key_value_sep)
      file_args += (line.substring(0,split_point)->line.substring(split_point+1,line.length-1))
    }

    return file_args
  }


  def load_resource(tfile: String):  Map[String,String] ={
    val fileStream = getClass.getResourceAsStream(tfile)
    val lines = Source.fromInputStream(fileStream).getLines
    val file_args: Map[String,String] = Map[String,String]()
    lines.foreach(line => {
      val split_point = line.indexOf(key_value_sep)
      file_args += (line.substring(0,split_point)->line.substring(split_point+1,line.length-1))
    })
    return file_args
  }
}