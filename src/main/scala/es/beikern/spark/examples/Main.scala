/*
 * Copyright 2016 Beikern
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.beikern.spark.examples

import org.apache.spark.{ SparkConf, SparkContext }
import org.joda.time.DateTime

object Main extends App {

  println("Starting Spark Job!")
  val config = new SparkConf()
    .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    .set("spark.kryo.registrator",
         "es.beikern.spark.examples.registrators.CustomKryoRegistrator")

  val sc: SparkContext = SparkContext.getOrCreate(config)

  val me1 = (1, DateTime.now())
  val me2 = (2, DateTime.now())
  val me3 = (3, DateTime.now())
  val rdd = sc.parallelize(List(me1, me2, me3))

  val result = rdd.map { case (a, d) => (a, d.dayOfMonth().roundFloorCopy()) }.collect.toList
  result.foreach(println)
  sc.stop()
}
