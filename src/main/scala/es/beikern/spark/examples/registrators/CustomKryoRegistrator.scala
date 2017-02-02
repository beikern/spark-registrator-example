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

package es.beikern.spark.examples.registrators

import com.esotericsoftware.kryo.Kryo
import de.javakaffee.kryoserializers.jodatime.{
  JodaDateTimeSerializer,
  JodaLocalDateSerializer,
  JodaLocalDateTimeSerializer
}
import org.apache.spark.serializer.KryoRegistrator
import org.joda.time.{ DateTime, LocalDate, LocalDateTime }

/**
  * Created by beikern on 2/02/17.
  */
class CustomKryoRegistrator extends KryoRegistrator {
  override def registerClasses(kryo: Kryo): Unit = {
    kryo.register(classOf[DateTime], new JodaDateTimeSerializer())
    kryo.register(classOf[LocalDate], new JodaLocalDateSerializer())
    kryo.register(classOf[LocalDateTime], new JodaLocalDateTimeSerializer())
  }
}
